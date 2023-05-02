package med.clinica.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //<< también podría ir Controller, pero como no va a retornar html, Rest tiene también ResponseBody que retorna xml o json
@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "Bienvenido usuario";
    }
}
