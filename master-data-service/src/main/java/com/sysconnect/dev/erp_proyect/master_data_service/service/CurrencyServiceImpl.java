package com.sysconnect.dev.erp_proyect.master_data_service.service;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Currency;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService{

    @Autowired
    private CurrencyRepository currencyRepository;


    @Override
    public Currency findById(Long id) {return currencyRepository.findById(id).orElse(null);}

    @Override
    public List<Currency> findAll() {return currencyRepository.findAll();}

    @Override
    public List<Currency> findByName(String name) {return currencyRepository.findByName(name);}

    @Override
    public Currency create(Currency currency) {return currencyRepository.save(currency);}

    @Override
    public Currency update(Currency currency) {
        Currency currencyDB = currencyRepository.findById(currency.getId()).orElse(null);
        if(currencyDB == null) return null;
        currencyDB.setName(currency.getName());
        currencyDB.setAbrev(currency.getAbrev());
        currencyDB.setDescription(currency.getDescription());
        return currencyRepository.save(currencyDB);
    }

    @Override
    public Currency delete(Long id) {
        Currency currencyDB = currencyRepository.findById(id).orElse(null);
        if(currencyDB == null) return null;
        currencyRepository.delete(currencyDB);
        return currencyDB;
    }
}
