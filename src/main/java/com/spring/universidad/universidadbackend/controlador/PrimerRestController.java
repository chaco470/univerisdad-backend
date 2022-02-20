package com.spring.universidad.universidadbackend.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi")
public class PrimerRestController {

    @GetMapping("/hola-mundo")
    public ResponseEntity<String> holaMunco(){
        return new ResponseEntity<String>("hola world", HttpStatus.ACCEPTED);
    }
}
