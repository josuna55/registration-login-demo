package net.guides.springboot.registrationlogindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    //Metodo de controlador para manejar la solicitud de pagina de inicio
    @GetMapping("/index")
    public String home() {
        return "home";
    }
}
