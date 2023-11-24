package com.quatrosphere.apigateway.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JwtUtils {
    
    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKeyProperty;

    public void validateToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(secretKeyProperty);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
    }

}
