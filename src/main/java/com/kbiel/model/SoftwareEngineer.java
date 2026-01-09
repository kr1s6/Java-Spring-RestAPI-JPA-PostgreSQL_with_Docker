package com.kbiel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "engineers")
public class SoftwareEngineer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private String name;

	@NotNull
	@ElementCollection
	private List<String> techStack;

	public SoftwareEngineer(String name, List<String> techStack) {
		this.name = name;
		this.techStack = techStack;
	}

	@Override
	public String toString() {
		return "SoftwareEngineer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", techStack=" + techStack +
				'}';
	}
}
