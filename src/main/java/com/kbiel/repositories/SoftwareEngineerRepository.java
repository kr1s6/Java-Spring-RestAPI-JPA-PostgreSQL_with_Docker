package com.kbiel.repositories;

import com.kbiel.model.SoftwareEngineer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SoftwareEngineerRepository extends JpaRepository<SoftwareEngineer, Integer>{
	Optional<SoftwareEngineer> findById(Integer id);

	@Query("SELECT DISTINCT e FROM SoftwareEngineer e LEFT JOIN FETCH e.techStack")
	List<SoftwareEngineer> findAllWithTechStack();
}
