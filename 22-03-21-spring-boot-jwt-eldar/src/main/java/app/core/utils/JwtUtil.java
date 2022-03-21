package app.core.utils;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Data;

@Component
public class JwtUtil {

	private String signatureAlgorithm = SignatureAlgorithm.HS256.getJcaName();
	@Value("${jwt.util.secret.key}")
	private String encodedSecretKey;
	private Key key;
	// expiration time
	@Value("${jwt.util.chrono.unit.number}")
	private int unitsNumber;
	@Value("${jwt.util.chrono.unit}")
	private String chronoUnit;
	//

	@PostConstruct
	public void init() {
		// create the key using the secret key (decoded to base-64) and the chosen
		// algorithm
		this.key = new SecretKeySpec(Base64.getDecoder().decode(encodedSecretKey), signatureAlgorithm);
	}

	public String generateToken(ClientDetails clientDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("clientType", clientDetails.getClientType());
		claims.put("clientId", clientDetails.getClientId());
		return createToken(claims, clientDetails.getEmail());
	}

	private String createToken(Map<String, Object> claims, String subject) {
		Instant now = Instant.now();
		Instant expiration = now.plus(unitsNumber, ChronoUnit.valueOf(this.chronoUnit));
		return Jwts.builder()

				.setClaims(claims)

				.setSubject(subject)

				.setIssuedAt(Date.from(now))

				.setExpiration(Date.from(expiration))

				.signWith(key)

				.compact();
	}

	@Data
	@AllArgsConstructor
	public static class ClientDetails {
		public int clientId;
		public String email;
		public ClientType clientType;

		public enum ClientType {
			ADMIN, COMPANY, CUSTOMER;
		}
	}

}
