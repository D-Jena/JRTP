package org.dj.repository;

import java.io.Serializable;
import java.util.Optional;

import org.dj.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Serializable> {
	
	 Optional<AdminEntity> findByuserNameAndPassword(String userName, String password);
	
}
