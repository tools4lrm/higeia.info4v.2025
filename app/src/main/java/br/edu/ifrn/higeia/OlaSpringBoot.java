package main.java.br.edu.ifrn.higeia;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.webbind.annotation.GetMapping;
@restController
    
public class OlaSpringBoot {
    @getMapping("/")
    public String index (){
        return "olá Spring Boot";
    }


    
}
