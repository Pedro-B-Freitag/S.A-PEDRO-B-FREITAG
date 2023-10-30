package com.cursos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {




    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select usuario,senha, ativado from pessoa where usuario = ?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT p.usuario, r.role FROM pessoa p JOIN roles r ON p.roles_id = r.id WHERE p.usuario = ?");


        return jdbcUserDetailsManager;
    }

    //Filtros
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/cursos/list").permitAll()
                        .requestMatchers("/cursos/display/**").permitAll()
                        .requestMatchers("/vagas/list").permitAll()
                        .requestMatchers("/empresas/**").hasRole("ADMIN")
                        .requestMatchers("/cursos/mostrarFormCadastrarCurso").hasRole("ADMIN")
                        .anyRequest().authenticated()
                        )

                        .formLogin(form ->
                                form
                                        .loginPage("/showMyLoginPage")
                                        .loginProcessingUrl("/authenticateTheUser")
                                        .permitAll()
                        ).logout(logout -> logout.permitAll()


                        );

        return http.build();
    }

/*

    @Autowired
    CustomPessoaDetailsService pessoaDetailsService;

    private BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(pessoaDetailsService).passwordEncoder(passwordEncoder());
    }
    */

}
