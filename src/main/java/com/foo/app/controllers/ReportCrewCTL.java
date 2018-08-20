package com.foo.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foo.app.model.EMainArea;
import com.foo.app.model.EController;

@Controller
@RequestMapping(EController.ID_REPORT_CREW)
public class ReportCrewCTL extends AMainArea {

	public ReportCrewCTL()
	{
		super(EMainArea.REPORT_CREW);
	}
}
