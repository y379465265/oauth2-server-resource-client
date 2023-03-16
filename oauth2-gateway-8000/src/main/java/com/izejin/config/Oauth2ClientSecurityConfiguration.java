package com.izejin.config;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizationRequestResolver;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author admin
 * Date 2022/5/13
 * @version 1.0
 */
@Configuration(proxyBeanMethods = false)
@EnableWebFluxSecurity
public class Oauth2ClientSecurityConfiguration {
    /***
     * 安全配置
     * @param http http
     * @return SecurityFilterChain
     * @throws Exception exception
     */
    @Bean
    public SecurityWebFilterChain oauth2ClientSecurityFilterChain(ServerHttpSecurity http,
                                                                  ServerLogoutSuccessHandler serverLogoutSuccessHandler
                                                                  ){
        http
                .authorizeExchange(authorize -> authorize
                        .anyExchange().authenticated()
                )
                .csrf().disable()
                .oauth2Login(withDefaults())
                .logout(logout -> logout
                        .requiresLogout(ServerWebExchangeMatchers.pathMatchers(HttpMethod.GET, "/logout"))
                        .logoutSuccessHandler(serverLogoutSuccessHandler)
                );
        return http.build();
    }

}

