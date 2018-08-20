package com.foo.app.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.foo.app.model.EMainArea;

public abstract class AMainArea {
	protected final EMainArea area;

	public AMainArea(final EMainArea area) {
		this.area = area;
	}

	@GetMapping("/")
	public String ROOT(final Model model) {
		return MainCTL.mainArea(this.area.controller.id, model);
	}

	/**
	 * Retorna o conteúdo principal dessa EMainArea, é o template que será
	 * renderizado no painel principal do template main.html
	 */
	@GetMapping("/main")
	public String main(final Model model) {
		model.addAttribute("mainArea", this.area);
		return this.area.template;
	}

}
