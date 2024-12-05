package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Ventas;
import com.proyecto.stylessapp.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentasServiceImpl implements VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    @Override
    public Ventas saveVentas(Ventas ventas) {
        return ventasRepository.save(ventas);
    }

    @Override
    public Optional<Ventas> getVentasById(Long idVenta) {
        return ventasRepository.findById(idVenta);
    }

    @Override
    public List<Ventas> getAllVentas() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas updateVentas(Ventas ventas) {
        if (ventas.getIdVenta() == null || !ventasRepository.existsById(ventas.getIdVenta())) {
            throw new RuntimeException("Venta no encontrada");
        }
        return ventasRepository.save(ventas);
    }

    @Override
    public void deleteVentas(Long idVenta) {
        if (!ventasRepository.existsById(idVenta)) {
            throw new RuntimeException("Venta no encontrada");
        }
        ventasRepository.deleteById(idVenta);
    }
}
