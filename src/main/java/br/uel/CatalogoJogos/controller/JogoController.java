package br.uel.CatalogoJogos.controller;

import br.edu.uel.jogos.model.Jogo;
import br.edu.uel.jogos.service.JogoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/jogos")
public class JogoController {
    @Autowired
    private JJogoService service;

    //Rota de Listagem, Ordenação e Pesquisa


    @GetMapping("/novo")
    public String novoJogo(Model model) {
        model.addAttribute("jogo", new Jogo());
        return "jogos/form";
    }

    @GetMapping("/editar/{id}")
    public String editarJogo(@PathVariable Long id, Model model) {
        model.addAttribute("jogo", service.buscarPorId(id));
        return "jogos/form";
    }


    @PostMapping("/salvar")
    public String salvarJogo(@Valid @ModelAttribute("jogo") Jogo jogo,
                             BindingResult result,
                             RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "jogos/form";
        }
        service.salvar(jogo);
        redirect.addFlashAttribute("mensagemSucesso", "Jogo salvo com sucesso!");
        return "redirect:/jogos";
    }

    //Rota para excluir registro

}