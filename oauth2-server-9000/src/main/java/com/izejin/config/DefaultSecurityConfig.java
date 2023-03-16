package com.izejin.config;


import com.izejin.filter.CustomAuthenticationProvider;
import com.izejin.filter.MyLoginFilter;
import com.izejin.security.CustomUserDetailsServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPublicKey;

/**
 * <p>授权服务器安全策略</p>
 *
 * @author 土味儿
 * Date 2022/5/10
 * @version 1.0
 */
@EnableWebSecurity(debug = true)
@EnableConfigurationProperties()
public class DefaultSecurityConfig  {




    /**
     * 配置 请求授权
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        MyLoginFilter authenticationFilter = new MyLoginFilter(authenticationManager);
        // 配置 请求授权
        http.authorizeRequests(authorizeRequests ->
                        // 任何请求都需要认证（不对未登录用户开放）
                        {
                            try {
                                authorizeRequests
                                        .mvcMatchers("/myLogin","/loginHtml").permitAll() //放行loginHtml请求
                                        .anyRequest()
                                        .authenticated()
                                        .and()
                                        .csrf().disable();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                )
                .addFilterAt(authenticationFilter ,UsernamePasswordAuthenticationFilter.class)
                // 表单登录
                .formLogin(form ->
                        form.loginPage("/loginHtml")
                                .loginProcessingUrl("/myLogin"))
//                .loginPage("/loginHtml")//用来指定自定义登录界面，不使用SpringSecurity默认登录界面
//                .loginProcessingUrl("/login")//指定处理登录的请求url
                .logout()
                .logoutSuccessUrl("http://127.0.0.1:8000")
                .and()
                .oauth2ResourceServer().jwt();
        return http.build();
    }

    @Bean
    MyLoginFilter myLoginFilter(AuthenticationManager authenticationManager) throws Exception {
        MyLoginFilter authenticationFilter = new MyLoginFilter(authenticationManager);
        return authenticationFilter;
    }

    @Bean
    UserDetailsService users() {
        return new CustomUserDetailsServiceImpl();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * jwt解码器
     * 客户端认证授权后，需要访问user信息，解码器可以从令牌中解析出user信息
     *
     * @return
     */
    @SneakyThrows
    @Bean
    JwtDecoder jwtDecoder() {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("x.509");
        // 读取cer公钥证书来配置解码器
        ClassPathResource resource = new ClassPathResource("myjks.cer");
        Certificate certificate = certificateFactory.generateCertificate(resource.getInputStream());
        RSAPublicKey publicKey = (RSAPublicKey) certificate.getPublicKey();
        return NimbusJwtDecoder.withPublicKey(publicKey).build();
    }

    /**
     * 开放一些端点的访问控制
     * 不需要认证就可以访问的端口
     * @return
     */
    //@Bean
/*    WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().antMatchers("/actuator/health", "/actuator/info");
    }*/
}

