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

import application.model.Questao;
import application.model.Alternativa;
import application.repository.QuestaoRepository;

@Controller
@RequestMapping("/questao")
public class QuestaoController {
    @Autowired
    private QuestaoRepository questaoRepo;
    @Autowired

    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("questoes", questaoRepo.findAll());
        return "questao/list";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "questao/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("enunciado") String titulo) {

        Questao questao = new Questao();
        questao.setEnunciado(enunciado);
        Optional<Alternativa> alternativa = alternativaRepo.findById(id_alternativas);

        questaoRepo.save(questao);
        return "redirect:/questao/list";
    }

    @RequestMapping("/update")
    public String update(
        @RequestParam("id") long id,
        Model ui) {
            Optional<Questao> questao = questaoRepo.findById(id);
            if(questao.isPresent()) {
                ui.addAttribute("questao", questao.get());                
                return "questao/update";
            }
        return "redirect:/questao/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") long id,
        @RequestParam("enunciado") String enunciado) {
            Optional<Questao> questao = questaoRepo.findById(id);
            if(questao.isPresent()) {
                questao.get().setEnunciado(enunciado);
                questaoRepo.save(questao.get());
            }
            return "redirect:/questao/list";
    }

    @RequestMapping("/delete")
    public String delete(
        @RequestParam("id") long id,
        Model ui) {
            Optional<Plataforma> questao = questaoRepo.findById(id);
            if(questao.isPresent()) {
                ui.addAttribute("questao", questao.get());
                return "questao/delete";
            }
            return "redirect:/questao/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        questaoRepo.deleteById(id);
        return "redirect:/questao/list";
    }
}