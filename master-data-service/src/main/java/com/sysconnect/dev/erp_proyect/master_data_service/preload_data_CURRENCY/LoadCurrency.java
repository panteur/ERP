package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_CURRENCY;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Currency;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCurrency {

    @Autowired
    private CurrencyRepository currencyRepository;

    public void loadCurrency() {


        //CLP
        Currency currency = new Currency();
        if (!currencyRepository.existsByAbrev("CLP")) {
            currency.setAbrev("CLP");
            currency.setName("Peso Chileno");
            currency.setDescription("Moneda de curso legal en Chile");
            currencyRepository.save(currency);
        }

        //USD
        currency = new Currency();
        if (!currencyRepository.existsByAbrev("USD")) {
            currency.setAbrev("USD");
            currency.setName("Dolar Americano");
            currency.setDescription("Moneda de curso legal en Estados Unidos");
            currencyRepository.save(currency);
        }

        //EUR
        currency = new Currency();
        if (!currencyRepository.existsByAbrev("EUR")) {
            currency.setAbrev("EUR");
            currency.setName("Euro");
            currency.setDescription("Moneda de curso legal en la Union Europea");
            currencyRepository.save(currency);
        }

    }


}
