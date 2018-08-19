package com.foo.app.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private static final List<Menu> menus = new ArrayList<>();
	static {
		menus.add(new Menu("Gerencial", null, //
			new MenuItem("Blocos", EMainArea.REP_BLOCKS), //
			new MenuItem("Tripulantes", EMainArea.REPORT_CREW)) //
		);

		menus.add(new Menu("Administrativo", null, //
			new MenuItem("Permissões", EMainArea.ADMIN_PERMS)) //
		);
	}

	public static List<Menu> menus() {
		return menus;
	}

	private final String label; // Texto do menu
	private final EMainArea area; // Recurso aberto pelo menu
	private final List<MenuItem> items = new ArrayList<>();

	public Menu(final String label, final EMainArea area, final MenuItem... items) {
		this.label = label;
		this.area = area;
		if (items == null)
			return;
		for (final MenuItem item : items)
			this.items.add(item);
	}

	public String getLabel() {
		return this.label;
	}

	public EMainArea getArea() {
		return this.area;
	}

	public List<MenuItem> getItems() {
		return this.items;
	}
}