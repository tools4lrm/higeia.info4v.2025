package br.edu.ifrn.higeia;

import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrn.higeia.persistencia.modelo.Ala;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class OlaSpringBoot {

    @GetMapping("/")
    public String index(){
        
        return "Olá Spring Boot ";
    }

}
