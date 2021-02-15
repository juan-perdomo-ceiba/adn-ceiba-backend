package com.ceiba.configuracion.security;

import com.ceiba.autenticacion.controlador.Usuario;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
    private final JwtTokenFilter jwtTokenFilter;
    private final DaoUsuario daoUsuario;

    public SecurityConfig(JwtTokenFilter jwtTokenFilter, DaoUsuario daoUsuario) {
        super();
        this.jwtTokenFilter = jwtTokenFilter;
        this.daoUsuario = daoUsuario;
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }

    @Bean
    public PasswordEncoder passwordEncoder(JwtTokenFilter jwtTokenFilter) {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> mapUsuario(daoUsuario.detallePorUsuario(username))).passwordEncoder(new BCryptPasswordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http.csrf().ignoringAntMatchers("/autenticacion",
                "/paquetes-turisticos/**",
                "/paquetes-turisticos",
                "/lugares-turisticos",
                "/lugares-turisticos/**",
                "/reservas",
                "/reservas/**",
                "/municipios").and();

        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            LOGGER.error("Unauthorized request - {}", ex.getMessage());
                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
                        }
                )
                .and();

        http.authorizeRequests()
                .antMatchers("/").hasIpAddress("127.0.0.1")
                .antMatchers(HttpMethod.POST, "/autenticacion").hasIpAddress("127.0.0.1")
                .antMatchers(HttpMethod.GET, "/paquetes-turisticos/**").hasIpAddress("127.0.0.1")
                .antMatchers(HttpMethod.POST, "/reservas").hasIpAddress("127.0.0.1")
                .antMatchers(HttpMethod.GET, "/reservas/detalle/**").hasIpAddress("127.0.0.1")
                .anyRequest().hasAnyAuthority();

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    private UserDetails mapUsuario(DtoUsuario usuario) {
        return new Usuario(usuario.getId(), usuario.getNombre(), usuario.getClave());
    }
}
