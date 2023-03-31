package org.dj.repository;

import java.io.Serializable;

import org.dj.entity.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<SalaryEntity, Serializable> {

}
