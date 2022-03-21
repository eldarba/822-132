package a;

import java.security.Key;
import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Demo2 {

	public static void main(String[] args) {

		// 1. secret key
		String secret = "aaaaaaaaa1aaaaaaaaa2aaaaaaaaa3aaaaaaaaa4aaa";
		// 2. decode the secret key so it is platform neutral
		byte[] secretDecoded = Base64.getDecoder().decode(secret);
		// 3. choose sign algorithm
		String alg = SignatureAlgorithm.HS256.getJcaName();
		// 4. creat key
		Key key = new SecretKeySpec(secretDecoded, alg);

		// JWS - JSON Web Signature - encoded
		String jws = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlbGRhcmJhQGdtYWlsLmNvbSIsImlhdCI6MTY0Nzg4NjkxNSwiZXhwIjoxNjQ3ODg3MjE1LCJmaXJzdCBuYW1lIjoiRWxkYXIiLCJsYXN0IG5hbWUiOiJCYWtzaGkifQ.Y18TY0O2aUhS644oHN3exCbPmo6zrQH13YroGcdIdBU";

		// decode the JWS to get JWT - JSON Web Token
		// 1. get a parser
		JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
		// 2. get the JWT
		Jws<Claims> jwt = jwtParser.parseClaimsJws(jws);
		System.out.println(jwt.getHeader());
		System.out.println(jwt.getBody()); // the pay load
		System.out.println(jwt.getSignature());
	}

}
