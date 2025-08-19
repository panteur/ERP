package com.sysconnect.dev.erp_proyect.master_data_service.service;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Currency;

import java.util.List;

public interface CurrencyService {

    public Currency findById(Long id);

    public List<Currency> findAll();

    public List<Currency> findByName(String name);

    public Currency create(Currency currency);

    public Currency update(Currency currency);

    public Currency delete(Long id);

}
