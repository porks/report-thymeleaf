package com.foo.app.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa uma Area interna do site (Um relatório, pagina administrativa, etc)
 */
public enum Area {
    HOME("", "home"), // Area principal, inicial

    /**
     * Relatórios
     */
    REP_BLOCKS("report-blocks", "report/blocks"), // Blocos
    REP_CREW("report-crew", "report/crew"), // Tripulantes

    /**
     * Parte adminsitrativa do sistema
     */
    ADM_PERMS("admin-perms", "admin/perms");

    /**
     * Subdiretorio dos templates que contém o html das areas
     */
    private static final String AREA_PREFIX = "area/";

    private static  Map<String, Area> allByPath = null;

    /**
     * O path para o arquivo html template que será renderizado. Sem o sufixo ".html"
     */
    public final String template;

    /**
     * Idica o path usado na URL para acessar essa area
     */
    public final String path;

    Area(final String path, final String template) { this.path = path; this.template = Area.AREA_PREFIX + template; }

    public static Area byPath(final String path) {
        if (allByPath == null) {
            synchronized(Area.class) {
                if (allByPath == null) {
                    Map<String, Area> __allByPath = new HashMap<>();
                    for (final Area area : Area.values())
                        __allByPath.put(area.path, area);
                    allByPath = __allByPath;
                }
            }
        }

        return allByPath.getOrDefault(path, Area.HOME);
    }
}