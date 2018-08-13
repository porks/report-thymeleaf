package com.foo.app.model;

public class MenuItem {
	private String label; // Texto do item do menu
	private Area area; // Recurso aberto pelo item do menu

	public MenuItem(final String label, final Area area) {
		this.label = label;
		this.area = area;
	}

	public String getLabel() {
		return this.label;
	}

	public Area getArea() {
		return this.area;
	}
}