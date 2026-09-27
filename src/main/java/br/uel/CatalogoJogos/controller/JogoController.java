package br.uel.CatalogoJogos.controller;

import br.uel.CatalogoJogos.model.Jogo;
import br.uel.CatalogoJogos.service.JogoService;
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
    private JogoService service;

    @GetMapping
    public  String listarJogos(@RequestParam(required = false) String buscar,
                               @RequestParam(defaultValue = "titulo") String ordem,
                               @RequestParam(defaultValue = "asc") String dir,
                               Model model) {
        model.addAttribute("jogos", service.buscarEOrdenar(buscar, ordem, dir));
        model.addAttribute("buscar", buscar);
        model.addAttribute("ordem", ordem);
        model.addAttribute("dir", dir);
        return "jogos/list";
}

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

    @GetMapping("/excluir/{id}")
    public String excluirJogo(@PathVariable Long id, RedirectAttributes redirect) {
        service.excluir(id);
        redirect.addFlashAttribute("mensagemSucesso", "Jogo excluído com sucesso!");
        return "redirect:/jogos";
    }
}