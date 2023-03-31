package org.dj.repository;

import java.io.Serializable;

import org.dj.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Serializable> {

}
