
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.ProductoCompras;
import com.proyecto.stylessapp.model.ProductoComprasId;
import com.proyecto.stylessapp.repository.ProductoComprasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoComprasServiceImpl implements ProductoComprasService {
    
    @Autowired
    private ProductoComprasRepository productoComprasRepository;

    @Override
    public List<ProductoCompras> getAllProductoCompras() {
        return productoComprasRepository.findAll(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<ProductoCompras> getProductoComprasById(ProductoComprasId id) {
        return productoComprasRepository.findById(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductoCompras saveProductoCompras(ProductoCompras productoCompras) {
        return productoComprasRepository.save(productoCompras); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteProductoCompras(ProductoComprasId id) {
        productoComprasRepository.deleteById(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
