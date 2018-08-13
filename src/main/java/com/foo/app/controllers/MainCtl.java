package com.foo.app.controllers;

import com.foo.app.model.Menu;
import com.foo.app.model.Area;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainCtl {
    @GetMapping("/login")
    public String login(final Model model) { return "login"; }

    @GetMapping("/") // index aponta para o /home
    public String index(final Model model) { return this.area(null, model); }

    /**
     * Qualquer /path (Ex: /blocos) aponta para o template main.html
     * definindo o include da area como sendo /area/{path}.html
     */
    @GetMapping("/{path}")
    public String area(@PathVariable final String path, final Model model) {
        // Obtem item conhecido da enum a partir do path, ou item padrão "home"
		model.addAttribute("current_area", Area.byPath(path));
        model.addAttribute("menus", Menu.menus());
        return "main"; // Renderiza o template main.html
    }

    /**
     * Retorna o path interno do include retornado no método this.area()
     * Desse modo conseguimos alterar o conteudo da divContent
     */
    @GetMapping("/_{path}")
    public String internalArea(@PathVariable final String path, final Model model) {
        // Obtem item conhecido da enum a partir do path, ou item padrão "home"
        final Area area = Area.byPath(path);
		model.addAttribute("current_area", area);
        return area.template;
    }
}