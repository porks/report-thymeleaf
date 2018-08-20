package com.foo.app.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum para identificação dos controllers, evitando conflito de paths
 * 
 * @author Marcelo Rossi
 */
public enum EController {
	REPORT_BLOCKS(EController.ID_REPORT_BLOCKS), REPORT_CREW(EController.ID_REPORT_CREW),
	ADMIN_PERMS(EController.ID_ADMIN_PERMS),

	MAIN(EController.ID_MAIN);

	/****************************************
	 *** Constantes para o ID único
	 ****************************************/

	public static final String ID_MAIN = "";

	public static final String ID_REPORT_BLOCKS = "report-blocks";

	public static final String ID_REPORT_CREW = "report-crew";

	public static final String ID_ADMIN_PERMS = "admin-perms";

	/****************************************
	 *** Implementação da Classe
	 ****************************************/

	private static Map<String, EController> allById = null;

	public final String id;

	/**
	 * @param id Seu ID, único, deve ser usado apenas letras, números e hífen.
	 *           Tentamos manter uma ordem nos paths dos controllers, esse ID indica
	 *           o primeiro segmento de path.
	 */
	EController(final String id) {
		this.id = id;
	}

	public static EController byId(final String id) {
		if (allById == null) {
			synchronized (EController.class) {
				if (allById == null) {
					final Map<String, EController> __allById = new HashMap<>();
					for (final EController controller : EController.values()) {
						if (controller.id.matches("[A-Za-z0-9\\-]"))
							throw new RuntimeException("O ID <" + controller.id
									+ "> do Controller deve conter apenas letras, números e hífen");
						final EController alreadySetValue = __allById.put(controller.id, controller);
						if (alreadySetValue != null)
							throw new RuntimeException("Controller com ID <" + controller.id + "> duplicado");
					}
					allById = __allById;
				}
			}
		}

		return allById.getOrDefault(id, EController.MAIN);
	}
}