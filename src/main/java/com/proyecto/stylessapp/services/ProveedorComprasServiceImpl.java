
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.ProveedorCompras;
import com.proyecto.stylessapp.model.ProveedorComprasId;
import com.proyecto.stylessapp.repository.ProveedorComprasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorComprasServiceImpl implements ProveedorComprasService{
    
    @Autowired
    private ProveedorComprasRepository proveedorComprasRepository;

    @Override
    public List<ProveedorCompras> getAllProveedorCompras() {
        return proveedorComprasRepository.findAll(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<ProveedorCompras> getProveedorComprasById(ProveedorComprasId id) {
        return proveedorComprasRepository.findById(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProveedorCompras saveProveedorCompras(ProveedorCompras proveedorCompras) {
        return proveedorComprasRepository.save(proveedorCompras); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteProveedorCompras(ProveedorComprasId id) {
        proveedorComprasRepository.deleteById(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
