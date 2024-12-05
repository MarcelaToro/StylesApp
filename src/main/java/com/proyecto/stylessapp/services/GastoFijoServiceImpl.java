
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.GastoFijo;
import com.proyecto.stylessapp.repository.GastoFijoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GastoFijoServiceImpl implements GastoFijoService {
    
   @Autowired
   private GastoFijoRepository gastoFijoRepository;

    @Override
    public GastoFijo saveGastoFijo(GastoFijo gastoFijo) {
        return gastoFijoRepository.save(gastoFijo); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<GastoFijo> getGastoFijoById(Long id) {
        return gastoFijoRepository.findById(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GastoFijo> getAllGastosFijos() {
        return gastoFijoRepository.findAll(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GastoFijo updateGastoFijo(GastoFijo gastoFijo) {
        return gastoFijoRepository.save(gastoFijo); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteGastoFijo(Long id) {
         gastoFijoRepository.deleteById(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
   
}
