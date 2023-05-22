package com.example.RentACarV3.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserController {
    
    @GetMapping("/user")
    // Las llaves de nuestro mapa van a ser tipo String, y los valores objetos
    // Strings a objetos 
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        /* El Framework Collections, permite almacenar todos los datos recibidos del usuario,
        con él, podemos obtener los datos como objetos, necesario para los valores */
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }
}

