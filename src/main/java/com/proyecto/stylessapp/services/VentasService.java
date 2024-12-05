
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Ventas;
import java.util.List;
import java.util.Optional;

public interface VentasService {
    Ventas saveVentas(Ventas ventas);
    Optional<Ventas> getVentasById(Long idVenta);
    List<Ventas> getAllVentas();
    Ventas updateVentas(Ventas ventas);
    void deleteVentas(Long idVenta);
}
