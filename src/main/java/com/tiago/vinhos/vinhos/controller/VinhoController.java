package com.tiago.vinhos.vinhos.controller;

import com.tiago.vinhos.vinhos.exception.NegocioException;
import com.tiago.vinhos.vinhos.model.Vinho;
import com.tiago.vinhos.vinhos.service.VinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/vinhos")
public class VinhoController {

    @Autowired
    private VinhoService vinhoService;

    @GetMapping(value = "/novo")
    public ModelAndView novo(Vinho vinho) {
        ModelAndView modelAndView = new ModelAndView("vinhos/cadastro-vinho.html");
        modelAndView.addObject(vinho);
        modelAndView.addObject("tipos", this.vinhoService.getTiposDeVinho());
        return modelAndView;
    }

    @PostMapping(value = "/novo")
    public ModelAndView salvar(@Valid Vinho vinho, BindingResult errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            this.novo(vinho);
        }

        this.vinhoService.salvar(vinho);
        attributes.addFlashAttribute("message", "Vinho salvo com sucesso!");
        return new ModelAndView("redirect:/vinhos/novo");
    }

    @GetMapping(value = "/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        return this.novo(this.vinhoService.buscarPorId(id));
    }
}
