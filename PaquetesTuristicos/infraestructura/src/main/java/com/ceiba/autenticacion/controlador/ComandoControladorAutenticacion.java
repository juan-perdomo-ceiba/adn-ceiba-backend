package com.ceiba.autenticacion.controlador;

import com.ceiba.configuracion.security.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autenticacion")
@Api(tags = { "Controlador comando autenticacion"})
public class ComandoControladorAutenticacion {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public ComandoControladorAutenticacion(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping
    @ApiOperation(value = "Autenticacion", notes = "realiza la autenticacion y devuelve el token de seguridad")
    public ResponseEntity<AutenticacionResponse> crear(@RequestBody Autenticacion autenticacion) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(autenticacion.getUsuario(), autenticacion.getClave()));

            Usuario user = (Usuario) authenticate.getPrincipal();
            AutenticacionResponse autenticacionResponse = new AutenticacionResponse();
            autenticacionResponse.setUsuario(user);
            autenticacionResponse.setToken(jwtTokenUtil.generateAccessToken(user));
            return ResponseEntity.ok()
                    .body(autenticacionResponse);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
