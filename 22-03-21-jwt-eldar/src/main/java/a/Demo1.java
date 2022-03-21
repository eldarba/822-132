package a;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Demo1 {

	public static void main(String[] args) {

		// 1. secret key
		String secret = "aaaaaaaaa1aaaaaaaaa2aaaaaaaaa3aaaaaaaaa4aaa";
		// 2. decode the secret key so it is platform neutral
		byte[] secretDecoded = Base64.getDecoder().decode(secret);
		// 3. choose sign algorithm
		String alg = SignatureAlgorithm.HS256.getJcaName();
		System.out.println("alg: " + alg);
		// 4. creat key
		Key key = new SecretKeySpec(secretDecoded, alg);

		Instant now = Instant.now();
		Instant expiration = now.plus(5, ChronoUnit.MINUTES);

		String token = Jwts.builder().signWith(key)
				// set the subject - owner of the token
				.setSubject("eldarba@gmail.com")
				// set issued at
				.setIssuedAt(Date.from(now))
				// set expiration
				.setExpiration(Date.from(expiration))
				// add claim
				.claim("first name", "Eldar")
				// add claim
				.claim("last name", "Bakshi")
				// create the token
				.compact();

		System.out.println(token);

	}

}
