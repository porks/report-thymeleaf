package com.foo.app.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foo.app.model.EMainArea;
import com.foo.app.model.BlockDTO;
import com.foo.app.model.EController;

@Controller
@RequestMapping(EController.ID_REPORT_BLOCKS)
public class ReportBlocksCTL extends AMainArea {
	public ReportBlocksCTL() {
		super(EMainArea.REP_BLOCKS);
	}

	@Override
	@GetMapping("/main")
	public String main(final Model model) {
		final String main = super.main(model);

		// Lista de blocos
		final List<BlockDTO> blocks = BlockDTO.sampleList();
		model.addAttribute("blocks", blocks);

		return main;
	}
}
