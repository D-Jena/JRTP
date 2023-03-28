package org.dj.repository;

import java.util.List;

import org.dj.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {

	List<CityEntity> findAllByStateId(Integer stateId);
}
