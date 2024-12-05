
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Inventario;
import com.proyecto.stylessapp.repository.InventarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioServiceImpl implements InventarioService{
    
    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public Inventario saveInventario(Inventario inventario) {
        return inventarioRepository.save(inventario); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Inventario> getInventarioById(String nombre) {
        return inventarioRepository.findById(nombre); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Inventario> getAllInventarios() {
        return inventarioRepository.findAll(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Inventario updateInventario(Inventario inventario) {
        return inventarioRepository.save(inventario); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteInventario(String nombre) {
        inventarioRepository.deleteById(nombre); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
