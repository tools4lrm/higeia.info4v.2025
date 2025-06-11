package br.edu.ifrn.higeia;

import org.springframework.web.bind.annotation.*;

@RestController    
public class OlaSpringBoot {
    @GetMapping("/")
    public String index (){
        return "olá Spring Boot";
    }


    
}
