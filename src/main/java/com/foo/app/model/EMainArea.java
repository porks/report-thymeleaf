package com.foo.app.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa uma Area do Controller MainCTL, que detem controle do primeiro
 * segmento de path da aplicação
 * 
 * @author Marcelo Rossi
 */
public enum EMainArea {
	HOME(EController.MAIN, "main"), // Area principal, inicial

	/**
	 * Relatórios
	 */
	REP_BLOCKS(EController.REPORT_BLOCKS, "report/blocks/main"), // Blocos
	REPORT_CREW(EController.REPORT_CREW, "report/crew/main"), // Tripulantes

	/**
	 * Parte adminsitrativa do sistema
	 */
	ADMIN_PERMS(EController.ADMIN_PERMS, "admin/perms/main");

	/**
	 * Subdiretorio dos templates que contém o html das areas
	 */
	private static final String AREA_PREFIX = "area/";

	private static Map<String, EMainArea> allById = null;

	public final String template;

	public final EController controller;

	/**
	 * @param controller O controller.id como ID da MainArea, e é também para fazer
	 *                   uma relação direta com o path da URL acessada na area
	 *                   principal
	 * 
	 * @param template   caminho para o arquivo com sufixo ".html" relativo ao path
	 *                   $PROJETO/resources/templates/area/
	 */
	EMainArea(final EController controller, final String template) {
		this.controller = controller;
		this.template = EMainArea.AREA_PREFIX + template;
	}

	public static EMainArea byId(final String id) {
		if (allById == null) {
			synchronized (EMainArea.class) {
				if (allById == null) {
					final Map<String, EMainArea> __allById = new HashMap<>();
					for (final EMainArea area : EMainArea.values()) {
						if (area.getId().matches("[A-Za-z0-9\\-]"))
							throw new RuntimeException("O ID <" + area.getId()
									+ "> do Controller deve conter apenas letras, números e hífen");
						final EMainArea alreadySetValue = __allById.put(area.getId(), area);
						if (alreadySetValue != null)
							throw new RuntimeException(
									"Area Principal com ID <" + area.getId() + "> duplicado templates <"
											+ area.template + "> <" + alreadySetValue.template + ">");
					}
					allById = __allById;
				}
			}
		}

		return allById.getOrDefault(id, EMainArea.HOME);
	}

	public String getId() {
		return this.controller.id;
	}
}