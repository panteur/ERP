package com.sysconnect.dev.erp_proyect.master_data_service.repository;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommuneRepository extends JpaRepository<Commune, Long> {

    @Query("select c from Commune c where upper(c.name) like upper(concat('%', ?1, '%'))")
    List<Commune> findByNameContains(String name);

    @Query("select c from Commune c where c.region.id = ?1")
    List<Commune> findByRegion_Id(Long id);

    @Query("select (count(c) > 0) from Commune c where c.region.id = ?1 and c.name = ?2")
    boolean existsByRegion_IdAndName(Long id, String name);
}