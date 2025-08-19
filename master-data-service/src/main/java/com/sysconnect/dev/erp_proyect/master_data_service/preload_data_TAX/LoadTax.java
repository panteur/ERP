package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_TAX;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Tax;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadTax {

    @Autowired
    private TaxRepository taxRepository;

    public void loadTax() {

        //IVA
        Tax tax = new Tax();
        if (!taxRepository.existsByAbrev("IVA")) {
            tax.setName("Impuesto al Valor agregado");
            tax.setAbrev("IVA");
            tax.setDescription("El Impuesto a las Ventas y Servicios grava la " +
                    "venta de bienes y prestaciones de servicios que define " +
                    "la ley del ramo, efectuadas entre otras, por las " +
                    "empresas comerciales, industriales, mineras, y de servicios");
            tax.setValue(0.19);
            taxRepository.save(tax);
        }
        //ILA_A
        tax = new Tax();
        if (!taxRepository.existsByAbrev("ILA_A1")) {
            tax.setName("Impuesto a Bebidas analcohólicas");
            tax.setAbrev("ILA_A");
            tax.setDescription("Impuesto a bebidas analcohólicas naturales o artificiales, " +
                    "energizantes o hipertónicas, jarabes y en general cualquier otro producto" +
                    " que las sustituya o que sirva para preparar bebidas similares, y " +
                    "aguas minerales o termales a las cuales se les haya adicionado colorante");
            tax.setValue(0.1);
            taxRepository.save(tax);
        }

        //ILA_A2
        tax = new Tax();
        if (!taxRepository.existsByAbrev("ILA_A2")) {
            tax.setName("Impuesto a Bebidas analcohólicas Alto contenido de azucar");
            tax.setAbrev("ILA_A2");
            tax.setDescription("Impuesto a las bebidas que presenten la composición nutricional " +
                    "de elevado contenido de azúcares a que se refiere el artículo 5° de la " +
                    "ley N°20.606, la que para estos efectos se considerará existente cuando " +
                    "tengan más de 15 gramos (g) por cada 240 mililitros (ml) o porción equivalente");
            tax.setValue(0.18);
            taxRepository.save(tax);
        }


        //ILA_B
        tax = new Tax();
        if (!taxRepository.existsByAbrev("ILA_B")) {
            tax.setName("Impuesto a Licores, piscos, whisky, aguardientes, destilados y vermouth");
            tax.setAbrev("ILA_B");
            tax.setDescription("Impuesto a Licores, piscos, whisky, aguardientes y destilados, " +
                    "incluyendo los vinos licorosos o aromatizados similares al vermouth");
            tax.setValue(0.315);
            taxRepository.save(tax);
        }

        //ILA_C
        tax = new Tax();
        if (!taxRepository.existsByAbrev("ILA_C")) {
            tax.setName("Impuesto a Cervezas, Vinos espumosos y sidras");
            tax.setAbrev("ILA_C");
            tax.setDescription("Impuesto a Vinos destinados al consumo, comprendidos los vinos gasificados, " +
                    "los espumosos o champaña, los generosos o asoleados, chichas y sidras destinadas al " +
                    "consumo, cualquiera que sea su envase, cervezas y otras bebidas alcohólicas, cualquiera " +
                    "que sea su tipo, calidad o denominación");
            tax.setValue(0.205);
            taxRepository.save(tax);
        }



    }


}
