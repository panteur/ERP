package com.sysconnect.dev.erp_proyect.master_data_service.repository;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    @Query("select r from Region r where upper(r.name) like upper(concat('%', ?1, '%'))")
    List<Region> findByNameContainsIgnore(String name);

    @Query("select r from Region r where upper(r.ordinal) like upper(concat('%', ?1, '%'))")
    List<Region> findByOrdinal(String ordinal);


    @Override
    boolean existsById(Long aLong);

    @Query("select (count(r) > 0) from Region r where r.name = ?1")
    boolean existsByName(String name);
}