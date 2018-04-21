package com.tiago.vinhos.vinhos.controller;

import com.tiago.vinhos.vinhos.model.Vinho;
import com.tiago.vinhos.vinhos.service.VinhoService;
import com.tiago.vinhos.vinhos.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/vinhos")
public class VinhoController {

    @Autowired
    private VinhoService vinhoService;

    @Autowired
    private MessageUtil messageUtil;

    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("vinhos/lista-vinhos");
        modelAndView.addObject("vinhos", this.vinhoService.buscarTodos());
        return modelAndView;
    }

    @GetMapping(value = "/novo")
    public ModelAndView novo(Vinho vinho) {
        ModelAndView modelAndView = new ModelAndView("vinhos/cadastro-vinho");
        modelAndView.addObject(vinho);
        modelAndView.addObject("tipos", this.vinhoService.getTiposDeVinho());
        return modelAndView;
    }

    @PostMapping(value = "/novo")
    public ModelAndView salvar(@Valid Vinho vinho, BindingResult errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            return this.novo(vinho);
        }

        this.vinhoService.salvar(vinho);
            attributes.addFlashAttribute("message", this.messageUtil.getMessage("vinho.salvo"));
        return new ModelAndView("redirect:/vinhos/novo");
    }

    @GetMapping(value = "/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        return this.novo(this.vinhoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes attributes) {
        this.vinhoService.deletar(id);
        attributes.addFlashAttribute("message", this.messageUtil.getMessage("vinho.deletado"));
        return "redirect:/vinhos";
    }
}
