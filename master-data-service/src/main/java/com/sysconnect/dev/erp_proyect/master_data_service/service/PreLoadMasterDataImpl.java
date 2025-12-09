package com.sysconnect.dev.erp_proyect.master_data_service.service;

import com.sysconnect.dev.erp_proyect.master_data_service.preload_data_CRITICITY.LoadCriticity;
import com.sysconnect.dev.erp_proyect.master_data_service.preload_data_CURRENCY.LoadCurrency;
import com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune.*;
import com.sysconnect.dev.erp_proyect.master_data_service.preload_data_MEASUREMENT_UNIT.*;
import com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Region.LoadRegion;
import com.sysconnect.dev.erp_proyect.master_data_service.preload_data_STATUS.*;
import com.sysconnect.dev.erp_proyect.master_data_service.preload_data_TAX.LoadTax;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "app.preload.data.enabled", havingValue = "true")
public class PreLoadMasterDataImpl {


    @Autowired
    private LoadStatusType loadStatusType;

    @Autowired
    private LoadStatusUser loadStatusUser;

    @Autowired
    private LoadStatusEmployee loadStatusEmployee;

    @Autowired
    private LoadStatusCustomer loadStatusCustomer;

    @Autowired
    private LoadStatusSupplier loadStatusSupplier;

    @Autowired
    private LoadCriticity loadCriticity;

    @Autowired
    private LoadTax loadTax;

    @Autowired
    private LoadCurrency loadCurrency;

    @Autowired
    private LoadMeasurementUnitType loadMeasurementUnitType;

    @Autowired
    private LoadMeasurementUnit_Longitud loadMeasurementUnit_Longitud;
    @Autowired
    private LoadMeasurementUnit_Masa loadMeasurementUnit_Masa;
    @Autowired
    private LoadMeasurementUnit_Tiempo loadMeasurementUnit_Tiempo;
    @Autowired
    private LoadMeasurementUnit_Temperatura loadMeasurementUnit_Temperatura;
    @Autowired
    private LoadMeasurementUnit_Energia loadMeasurementUnit_Energia;
    @Autowired
    private LoadMeasurementUnit_Fuerza loadMeasurementUnit_Fuerza;
    @Autowired
    private LoadMeasurementUnit_Potencia loadMeasurementUnit_Potencia;
    @Autowired
    private LoadMeasurementUnit_Superficie loadMeasurementUnit_Superficie;
    @Autowired
    private LoadMeasurementUnit_Velocidad loadMeasurementUnit_Velocidad;
    @Autowired
    private LoadMeasurementUnit_Presion loadMeasurementUnit_Presion;
    @Autowired
    private LoadMeasurementUnit_Electricas loadMeasurementUnit_Electricas;
    @Autowired
    private LoadMeasurementUnit_Luminosas loadMeasurementUnit_Luminosas;
    @Autowired
    private LoadMeasurementUnit_Volumen loadMeasurementUnit_Volumen;
    @Autowired
    private LoadMeasurementUnit_Informacion loadMeasurementUnit_Informacion;
    @Autowired
    private LoadMeasurementUnit_Numeracion loadMeasurementUnit_Numeracion;
    @Autowired
    private LoadRegion loadRegion;
    @Autowired
    private LoadCommuneRegion_I loadCommuneRegion_I;
    @Autowired
    private LoadCommuneRegion_II loadCommuneRegion_II;
    @Autowired
    private LoadCommuneRegion_III loadCommuneRegion_III;
    @Autowired
    private LoadCommuneRegion_IV loadCommuneRegion_IV;
    @Autowired
    private LoadCommuneRegion_V loadCommuneRegion_V;
    @Autowired
    private LoadCommuneRegion_VI loadCommuneRegion_VI;
    @Autowired
    private LoadCommuneRegion_VII loadCommuneRegion_VII;
    @Autowired
    private LoadCommuneRegion_VIII loadCommuneRegion_VIII;
    @Autowired
    private LoadCommuneRegion_IX loadCommuneRegion_IX;
    @Autowired
    private LoadCommuneRegion_X loadCommuneRegion_X;
    @Autowired
    private LoadCommuneRegion_XI loadCommuneRegion_XI;
    @Autowired
    private LoadCommuneRegion_XII loadCommuneRegion_XII;
    @Autowired
    private LoadCommuneRegion_XIII loadCommuneRegion_XIII;
    @Autowired
    private LoadCommuneRegion_XIV loadCommuneRegion_XIV;
    @Autowired
    private LoadCommuneRegion_XV loadCommuneRegion_XV;
    @Autowired
    private LoadCommuneRegion_XVI loadCommuneRegion_XVI;




    @PostConstruct
    private void LoadData() {
        loadStatusType.loadStatusType();
        loadStatusUser.loadUserStatus();
        loadStatusEmployee.loadStatusEmployee();
        loadStatusCustomer.loadStatusCustomer();
        loadStatusSupplier.loadStatusSupplier();
        loadCriticity.loadCriticity();
        loadTax.loadTax();
        loadCurrency.loadCurrency();
        loadMeasurementUnitType.loadMeasurementUnitType();

        //Units of measurement
        loadMeasurementUnit_Longitud.loadMeasurementUnit_Longitud();
        loadMeasurementUnit_Masa.loadMeasurementUnit_Masa();
        loadMeasurementUnit_Tiempo.loadMeasurementUnit_Tiempo();
        loadMeasurementUnit_Temperatura.loadMeasurementUnit_Temperatura();
        loadMeasurementUnit_Energia.loadMeasurementUnit_Energia();
        loadMeasurementUnit_Fuerza.loadMeasurementUnit_Fuerza();
        loadMeasurementUnit_Potencia.loadMeasurementUnit_Potencia();
        loadMeasurementUnit_Superficie.loadMeasurementUnit_Superficie();
        loadMeasurementUnit_Velocidad.loadMeasurementUnit_Velocidad();
        loadMeasurementUnit_Presion.loadMeasurementUnit_Presion();
        loadMeasurementUnit_Electricas.loadMeasurementUnit_Electricas();
        loadMeasurementUnit_Luminosas.loadMeasurementUnit_Luminosas();
        loadMeasurementUnit_Volumen.loadMeasurementUnit_Volumen();
        loadMeasurementUnit_Informacion.loadMeasurementUnit_Informacion();
        loadMeasurementUnit_Numeracion.loadMeasurementUnit_Numeracion();

        //Regions
       loadRegion.loadRegion();
        loadCommuneRegion_I.LoadCommuneRegion_I();
        loadCommuneRegion_II.LoadCommuneRegion_II();
        loadCommuneRegion_III.LoadCommuneRegion_III();
        loadCommuneRegion_IV.LoadCommuneRegion_IV();
        loadCommuneRegion_V.LoadCommuneRegion_V();
        loadCommuneRegion_VI.LoadCommuneRegion_VI();
        loadCommuneRegion_VII.LoadCommuneRegion_VII();
        loadCommuneRegion_VIII.LoadCommuneRegion_VIII();
        loadCommuneRegion_IX.LoadCommuneRegion_IX();
        loadCommuneRegion_X.LoadCommuneRegion_X();
        loadCommuneRegion_XI.LoadCommuneRegion_XI();
        loadCommuneRegion_XII.LoadCommuneRegion_XII();
        loadCommuneRegion_XIII.LoadCommuneRegion_XIII();
        loadCommuneRegion_XIV.LoadCommuneRegion_XIV();
        loadCommuneRegion_XV.LoadCommuneRegion_XV();
        loadCommuneRegion_XVI.LoadCommuneRegion_XVI();
            }
}
