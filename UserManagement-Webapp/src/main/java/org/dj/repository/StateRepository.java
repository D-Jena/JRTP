package org.dj.repository;

import java.io.Serializable;
import java.util.List;

import org.dj.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<StateEntity, Serializable> {

	List<StateEntity> findAllByCountryId(Integer countryId);


}
