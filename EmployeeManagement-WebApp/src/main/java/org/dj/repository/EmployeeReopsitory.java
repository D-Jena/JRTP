package org.dj.repository;

import java.io.Serializable;
import java.util.Optional;

import org.dj.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeReopsitory extends JpaRepository<EmployeeEntity, Serializable> {

	Optional<EmployeeEntity>  findByEmpEmailAndEmpPassword(String empEmail, String empPassword);
	
}
