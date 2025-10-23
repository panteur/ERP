package com.sysconnect.dev.erp_proyect.entity_service.service;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Supplier;

import java.util.List;

public interface SupplierService {

    public Supplier findById(Long id);
    public Supplier findByEntitie_Id(Long id);
    public List<Supplier> findAll();
    public List<Supplier> findByStatusId(Long statusId);
    public List<Supplier> findByPayDay(int payDay);
    public Supplier updateStatus(Long id, Long statusId);
    public Supplier updatePayInformation(Long id, int payDay, String medioPago, String formaPago);

    public Supplier save(Supplier supplier);
    public Supplier update(Supplier supplier);
    public Supplier delete(Long id);

}
