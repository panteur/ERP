package com.sysconnect.dev.erp_proyect.master_data_service.repository;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {


    @Query("select c from Currency c where upper(c.name) like upper(concat('%', ?1, '%'))")
    List<Currency> findByName(String name);

    @Query("select c from Currency c where upper(c.abrev) = upper(?1)")
    Currency findByAbrev(String abrev);

    @Query("select (count(c) > 0) from Currency c where c.abrev = ?1")
    boolean existsByAbrev(String abrev);
}