package com.foo.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foo.app.model.EMainArea;
import com.foo.app.model.EController;

@Controller
@RequestMapping(EController.ID_ADMIN_PERMS)
public class AdminPermsCTL extends AMainArea {
	public static final String CONTROLLER_ID = "admin-perms";

	public AdminPermsCTL()
	{
		super(EMainArea.ADMIN_PERMS);
	}
}
