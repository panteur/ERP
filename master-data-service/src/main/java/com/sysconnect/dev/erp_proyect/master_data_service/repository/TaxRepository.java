package com.sysconnect.dev.erp_proyect.master_data_service.repository;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaxRepository extends JpaRepository<Tax, Long> {
    @Query("select t from Tax t where upper(t.abrev) like upper(concat('%', ?1, '%'))")
    List<Tax> findByAbrev(String abrev);

    @Query("select (count(t) > 0) from Tax t where t.abrev = ?1")
    boolean existsByAbrev(String abrev);

}