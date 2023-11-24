package com.quatrosphere.apigateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.quatrosphere.apigateway.configs.ConfigAuthFilter;
import com.quatrosphere.apigateway.utils.JwtUtils;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<ConfigAuthFilter>{

    private Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Autowired
    private JwtUtils jwtUtils;

    public AuthenticationFilter() {
        super(ConfigAuthFilter.class);
    }

    @Override
    public GatewayFilter apply(ConfigAuthFilter config) {
        return ((exchange, chain) -> {

            if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
                throw new RuntimeException("Missing Authorization Header");
                
            try {
                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

                if(authHeader != null && authHeader.startsWith("Bearer ")){
                    jwtUtils.validateToken(authHeader.substring(7));
                }
            } catch (Exception e) {
                logger.error("Error validacion token JWT en GatewayFilter -> Clase AuthenticationFilter");
            }

            return chain.filter(exchange);
        });
    }
    

}
