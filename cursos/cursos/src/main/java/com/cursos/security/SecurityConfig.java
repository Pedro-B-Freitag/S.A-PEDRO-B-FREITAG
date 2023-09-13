package com.cursos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //Filtros
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        authorizeConfig ->{
                            authorizeConfig.requestMatchers("/pessoas/create").permitAll();
                            authorizeConfig.requestMatchers("/pessoas/role").permitAll();
                            authorizeConfig.requestMatchers("/logout").permitAll();
                            //qualquer requisicao tem que ser feita por alguem auteticado
                            authorizeConfig.anyRequest().authenticated();
                        }
                )
                //formulario de login
                .formLogin(Customizer.withDefaults())
                .build();
    }
    @Autowired
    CustomPessoaDetailsService pessoaDetailsService;

    private BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(pessoaDetailsService).passwordEncoder(passwordEncoder());
    }
}
