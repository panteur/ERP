package com.sysconnect.dev.erp_proyect.master_data_service.service;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Tax;

import java.util.List;

public interface TaxService {

    public Tax findById(Long id);
    public List<Tax> findAll();
    public List<Tax> findByAbrev(String abrev);

    public Tax create(Tax tax);
    public Tax update(Tax tax);
    public Tax delete(Long id);



}
