package com.quatrosphere.configserver.configs;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import jakarta.annotation.PostConstruct;

@Configuration
@PropertySource(value = {"classpath:/configurations/apigateway.yml", "classpath:/configurations/apigateway.yml"})
public class ConfigManager {

    private Logger logger = LoggerFactory.getLogger(ConfigManager.class);

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKeyProperty;

    @PostConstruct
    public void initComponent() {
        try {
            if(secretKeyProperty == null || secretKeyProperty.isEmpty()){
                String algorithm = "HmacSHA256";

                KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
                
                SecretKey secretKey = keyGenerator.generateKey();
                
                String base64Key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
                
                System.setProperty("security.jwt.token.secret-key", base64Key);
            }
        } catch (NoSuchAlgorithmException e) {
            logger.error("Error al crear Secret Key JWT -> Clase ConfigManager", e.getMessage());      
        }
    }

}
