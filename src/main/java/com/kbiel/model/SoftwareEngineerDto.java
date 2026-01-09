package com.kbiel.model;

import lombok.Data;

import java.util.List;

@Data
public class SoftwareEngineerDto {
	private Integer id;
	private String name;
	private List<String> techStack;

	public SoftwareEngineerDto(Integer id, String name, List<String> techStack) {
		this.id = id;
		this.name = name;
		this.techStack = techStack;
	}
}

