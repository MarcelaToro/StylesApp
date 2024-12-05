
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Pago;
import com.proyecto.stylessapp.repository.PagoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoServiceImpl implements PagoService{
    
    @Autowired
    public PagoRepository pagoRepository;

    @Override
    public Pago savePago(Pago pago) {
        return pagoRepository.save(pago); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Pago> getPagoById(Long id) {
        return pagoRepository.findById(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pago> getAllPagos() {
        return pagoRepository.findAll(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pago updatePago(Pago pago) {
        return pagoRepository.save(pago); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletePago(Long id) {
        pagoRepository.deleteById(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
