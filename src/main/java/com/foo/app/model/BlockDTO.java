package com.foo.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockDTO {
	private Long id;

	private String code;

	private String startTime;

	private String endTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public static List<BlockDTO> sampleList() {
		
		final List<BlockDTO> list = new ArrayList<>();

		BlockDTO block = new BlockDTO();
		block.id = 291l;
		block.code = "1";
		block.startTime = "07:29";
		block.endTime = "16:23";
		list.add(block);

		block = new BlockDTO();
		block.id = 421l;
		block.code = "2";
		block.startTime = "07:57";
		block.endTime = "17:12";
		list.add(block);

		block = new BlockDTO();
		block.id = 152l;
		block.code = "3";
		block.startTime = "08:22";
		block.endTime = "18:03";
		list.add(block);

		for (int a = 0; a < 100; a++) {
			block = new BlockDTO();
			block.id = (long) (911l * (Math.random() * 100));
			block.code = String.valueOf((int) (4 * (Math.random() * 100)));
			block.startTime = ((int) (23 * (Math.random() * 100))) + ":" + ((int) (59 * (Math.random() * 100)));
			block.endTime = "18:09";
			list.add(block);
		}
		
		return list;
	}
}
