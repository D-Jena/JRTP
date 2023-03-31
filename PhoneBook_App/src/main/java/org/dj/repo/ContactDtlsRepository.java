package org.dj.repo;

import java.io.Serializable;
import java.util.List;

import org.dj.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDtlsRepository extends JpaRepository<ContactEntity, Serializable> {

	public List<ContactEntity> findByEmail(String email); 
}
