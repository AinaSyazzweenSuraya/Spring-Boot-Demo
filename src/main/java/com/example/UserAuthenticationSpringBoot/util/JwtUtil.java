package com.example.UserAuthenticationSpringBoot.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String secretKey="Hello";
    public String generateToken(String username){
        JwtBuilder jwt = Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 *60*60 *10))
                .signWith(SignatureAlgorithm.HS256, generateJwtSecretKey());
        return jwt.compact();
    }

    public SecretKey generateJwtSecretKey(){
        //Convert the static word to a byte array
        byte[] keyBytes = secretKey.getBytes();

        //Ensure key length is compatible with algorithm
        byte[] keyBytesPadded = new byte[32];
        System.arraycopy(keyBytes, 0, keyBytesPadded, 0, Math.min(keyBytes.length, 3));

        //Generate the secret key using static word
        return Keys.hmacShaKeyFor(keyBytesPadded);
    }
}
