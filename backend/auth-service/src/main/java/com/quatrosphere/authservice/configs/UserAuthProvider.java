package com.quatrosphere.authservice.configs;

import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.quatrosphere.authservice.models.dtos.UserDto;

@Component
public class UserAuthProvider {
    
    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKeyProperty;
    
    public String createToken(UserDto userDto){
        long timeExpiration = 3_600_000;
        Date currentTime = new Date();
        Date timeValidityToken = new Date(currentTime.getTime() + timeExpiration);

        return JWT.create()
            .withIssuer(userDto.getEmailClient())
            .withIssuedAt(currentTime)
            .withExpiresAt(timeValidityToken)
            .withClaim("firstNameClient", userDto.getFirstNameClient())
            .withClaim("lastNameClient", userDto.getLastNameClient())
            .sign(Algorithm.HMAC256(secretKeyProperty));
    }

    public Authentication validateToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(secretKeyProperty);

        JWTVerifier verifier = JWT.require(algorithm).build();

        DecodedJWT decodedJWT = verifier.verify(token);

        UserDto user = UserDto.builder()
            .emailClient(decodedJWT.getIssuer())
            .firstNameClient(decodedJWT.getClaim("firstNameClient").asString())
            .lastNameClient(decodedJWT.getClaim("lastNameClient").asString())
            .build();

        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }
}
