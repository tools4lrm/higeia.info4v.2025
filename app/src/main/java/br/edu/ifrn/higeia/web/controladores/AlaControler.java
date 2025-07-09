package br.edu.ifrn.higeia.web.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrn.higeia.persistencia.modelo.Ala;
import br.edu.ifrn.higeia.persistencia.repositorio.AlaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/alas")
public class AlaControler  {

    @Autowired
    private AlaRepository alaRepository;

    @GetMapping
    public String listar(Model model) {
        List<Ala> alas = alaRepository.findAll();
        model.addAttribute("alas", alas);
        return "alas/lista-alas";
    }

    @GetMapping("/nova")
    public String formulario(Model model) {
        model.addAttribute("ala", new Ala());
        return "alas/formulario-ala";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute Ala ala, BindingResult result, Model model) {
        // Valida duplicidade
        if (alaRepository.findByDescricao(ala.getDescricao()).isPresent()) {
            result.rejectValue("descricao", "erro.duplicado", "Já existe uma ala com essa descrição");
        }

        if (result.hasErrors()) {
            return "alas/formulario-ala";
        }

        alaRepository.save(ala);
        return "redirect:/alas";
    }
}
