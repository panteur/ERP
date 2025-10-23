package com.sysconnect.dev.erp_proyect.entity_service.service;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Supplier;
import com.sysconnect.dev.erp_proyect.entity_service.enums.paymentShape;
import com.sysconnect.dev.erp_proyect.entity_service.enums.paymentMethod;
import com.sysconnect.dev.erp_proyect.entity_service.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier findById(Long id) {return supplierRepository.findById(id).orElse(null);}

    @Override
    public Supplier findByEntitie_Id(Long id) {return supplierRepository.findByEntitie_Id(id).orElse(null);}

    @Override
    public List<Supplier> findAll() {return supplierRepository.findAll();}

    @Override
    public List<Supplier> findByStatusId(Long statusId) {return supplierRepository.findByStatusId(statusId);}

    @Override
    public List<Supplier> findByPayDay(int payDay) {return supplierRepository.findByPayDay(payDay);}

    @Override
    public Supplier updateStatus(Long id, Long statusId) {
        Supplier supplierBD = supplierRepository.findById(id).orElse(null);
        if (supplierBD == null) return null;
        supplierBD.setStatusId(statusId);
        return supplierRepository.save(supplierBD);
    }

    @Override
    public Supplier updatePayInformation(Long id, int payDay, String medioPago, String formaPago) {
        Supplier supplierBD = supplierRepository.findById(id).orElse(null);
        if (supplierBD == null) return null;
        supplierBD.setPayDay(payDay);
        supplierBD.setPaymentMethod(paymentMethod.valueOf(medioPago));
        supplierBD.setPaymentShape(paymentShape.valueOf(formaPago));
        return supplierRepository.save(supplierBD);
    }

    @Override
    public Supplier save(Supplier supplier) {return supplierRepository.save(supplier);}

    @Override
    public Supplier update(Supplier supplier) {
        Supplier supplierBD = supplierRepository.findById(supplier.getId()).orElse(null);
        if (supplierBD == null) return null;
        supplierBD.setStatus(supplier.getStatus());
        supplierBD.setFirstPurchase(supplier.getFirstPurchase());
        supplierBD.setPaymentMethod(supplier.getPaymentMethod());
        supplierBD.setPaymentShape(supplier.getPaymentShape());
        supplierBD.setPayDay(supplier.getPayDay());
        return supplierRepository.save(supplierBD);
    }

    @Override
    public Supplier delete(Long id) {
        Supplier supplierBD = supplierRepository.findById(id).orElse(null);
        if (supplierBD == null) return null;
        supplierRepository.delete(supplierBD);
        return supplierBD;
    }
}
