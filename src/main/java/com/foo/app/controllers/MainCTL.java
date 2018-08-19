package com.foo.app.controllers;

import com.foo.app.model.Menu;
import com.foo.app.model.EMainArea;
import com.foo.app.model.EController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(EController.ID_MAIN)
public class MainCTL {
	@GetMapping("/") // index aponta para o /home
	public String index(final Model model) {
		return this.area(null, model);
	}

	/**
	 * Acesso principal das URLs mais usadas e mais comuns de cada area principal do
	 * site
	 */
	@GetMapping("/{areaId}")
	public String area(@PathVariable final String areaId, final Model model) {
		return MainCTL.mainArea(areaId, model);
	}

	/**
	 * Qualquer URL acessada onde "/path" fazer match com o ID de um item da enum
	 * EMainArea, irá retornar o template "main.html" e define o include de conteúdo
	 * (no main.html) como sendo o template da area.
	 */
	public static String mainArea(@PathVariable final String areaId, final Model model) {
		// Obtem item conhecido da enum a partir do areaId, ou item padrão "home"
		model.addAttribute("mainArea", EMainArea.byId(areaId));
		model.addAttribute("menus", Menu.menus());
		return "main"; // Renderiza o template main.html
	}
}