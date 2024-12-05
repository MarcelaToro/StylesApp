
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.EmpleadoVentas;
import com.proyecto.stylessapp.model.EmpleadoVentasPK;
import com.proyecto.stylessapp.repository.EmpleadoVentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoVentasServiceImpl implements EmpleadoVentasService {

    @Autowired
    private EmpleadoVentasRepository empleadoVentasRepository;

    @Override
    public EmpleadoVentas saveEmpleadoVentas(EmpleadoVentas empleadoVentas) {
        return empleadoVentasRepository.save(empleadoVentas);
    }

    @Override
    public Optional<EmpleadoVentas> getEmpleadoVentasById(EmpleadoVentasPK id) {
        return empleadoVentasRepository.findById(id);
    }

    @Override
    public List<EmpleadoVentas> getAllEmpleadoVentas() {
        return empleadoVentasRepository.findAll();
    }

    @Override
    public EmpleadoVentas updateEmpleadoVentas(EmpleadoVentas empleadoVentas) {
        return empleadoVentasRepository.save(empleadoVentas);
    }

    @Override
    public void deleteEmpleadoVentas(EmpleadoVentasPK id) {
        empleadoVentasRepository.deleteById(id);
    }
}
