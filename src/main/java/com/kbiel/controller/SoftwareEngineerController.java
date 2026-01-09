package com.kbiel.controller;

import com.kbiel.model.SoftwareEngineer;
import com.kbiel.model.SoftwareEngineerDto;
import com.kbiel.service.SoftwareEngineerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class SoftwareEngineerController {
	private final SoftwareEngineerService softwareEngineerService;

	@GetMapping("/getSoftwareEngineers")
	public ResponseEntity<List<SoftwareEngineer>> getSoftwareEngineers() {
		return ResponseEntity.ok().body(List.of(
				new SoftwareEngineer(1, "Albert", List.of("react", "js", "java")),
				new SoftwareEngineer(2, "Megan", List.of("java, docker"))
		));
	}

	@PostMapping("/createSoftwareEngineers")
	public ResponseEntity<String> createSoftwareEngineers() {
		return softwareEngineerService.createSoftwareEngineers();
	}

	@GetMapping("/getAllEngineers")
	public ResponseEntity<List<SoftwareEngineerDto>> getAllEngineers() {
		return softwareEngineerService.getAllEngineers();
	}

}
