package com.qoobico.remindme.server.controller;

import com.qoobico.remindme.server.security.JwtAuthenticationRequest;
import com.qoobico.remindme.server.security.UserAuthentication;
import com.qoobico.remindme.server.service.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthenticationController {

    @Autowired
    private TokenAuthenticationService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    @ResponseBody
    public void authenticate(@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        service.addAuthentication(response, authentication);
    }
}
