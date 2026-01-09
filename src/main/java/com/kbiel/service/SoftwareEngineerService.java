package com.kbiel.service;

import com.kbiel.model.SoftwareEngineer;
import com.kbiel.model.SoftwareEngineerDto;
import com.kbiel.repositories.SoftwareEngineerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SoftwareEngineerService {
	private final SoftwareEngineerRepository softwareEngineerRepository;

	public ResponseEntity<String> createSoftwareEngineers() {
		List<SoftwareEngineer> list = List.of(
				new SoftwareEngineer("Albert", List.of("react", "js", "java")),
				new SoftwareEngineer("Megan", List.of("java, docker"))
		);
		softwareEngineerRepository.saveAll(list);
		return ResponseEntity.ok("Engineers created.");
	}

	public ResponseEntity<List<SoftwareEngineerDto>> getAllEngineers() {
		List<SoftwareEngineerDto> engineers = softwareEngineerRepository.findAllWithTechStack().stream().map(
				e -> new SoftwareEngineerDto(e.getId(), e.getName(), e.getTechStack())
		).toList();
		engineers.forEach(System.out::println);
		return ResponseEntity.ok().body(engineers);
	}
}
