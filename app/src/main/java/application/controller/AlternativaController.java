package application.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Alternativa;
import application.model.Questao;
import application.repository.AlternativaRepository;
import application.repository.QuestaoRepository;


@Controller
@RequestMapping("/alternativa")
public class AlternativaController {
    @Autowired
    private AlternativaRepository alternativaRepo;
    // @Autowired
    // private CategoriaRepository textoRepo;
    // @Autowired
    // private AlternativasRepository alternativasRepo;

    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("alternativas", alternativaRepo.findAll());
        return "alternativa/list";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "alternativa/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("texto") String texto,
        @RequestParam("isCorreta") boolean isCorreta) {

        Alternativa alternativa = new Alternativa();
        alternativa.setTexto(texto);
        alternativa.setIsCorreta(isCorreta);
        alternativaRepo.save(alternativa);
        return "redirect:/alternativa/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") long id,
        @RequestParam("texto") String texto,
        @RequestParam("isCorreta") boolean isCorreta,
        Model ui) {
            Optional<Alternativa> alternativa = alternativaRepo.findById(id);
            if(alternativa.isPresent()) {
                ui.addAttribute("texto", alternativaRepo.findAll());
                ui.addAttribute("isCorreta", alternativaRepo.findAll());                
                return "alternativa/update";
            }
        return "redirect:/alternativa/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") long id,
        @RequestParam("texto") String texto,
        @RequestParam("isCorreta") boolean isCorreta) {
            Optional<Alternativa> alternativa = alternativaRepo.findById(id);
            if(alternativa.isPresent()) {
                alternativa.get().setTexto(texto);
                alternativa.get().setIsCorreta(isCorreta);
            }
            return "redirect:/alternativa/list";
    }

    @RequestMapping("/delete")
    public String delete(
        @RequestParam("id") long id,
        Model ui) {
            Optional<Alternativas> alternativa = alternativaRepo.findById(id);
            if(alternativa.isPresent()) {
                ui.addAttribute("alternativa", alternativa.get());
                return "alternativa/delete";
            }
            return "redirect:/alternativa/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        alternativaRepo.deleteById(id);
        return "redirect:/alternativa/list";
    }
}