package org.dj.repository;

import java.io.Serializable;

import org.dj.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeReopsitory extends JpaRepository<EmployeeEntity, Serializable> {

}
