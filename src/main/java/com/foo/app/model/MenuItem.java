package com.foo.app.model;

public class MenuItem {
	private String label; // Texto do item do menu
	private EMainArea area; // Recurso aberto pelo item do menu

	public MenuItem(final String label, final EMainArea area) {
		this.label = label;
		this.area = area;
	}

	public String getLabel() {
		return this.label;
	}

	public EMainArea getArea() {
		return this.area;
	}
}