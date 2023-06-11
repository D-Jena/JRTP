package org.dj.repository;

import java.io.Serializable;
import java.util.List;

import org.dj.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<DistrictEntity, Serializable> {

}
