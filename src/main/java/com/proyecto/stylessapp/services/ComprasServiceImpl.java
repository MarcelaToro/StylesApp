
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Compras;
import com.proyecto.stylessapp.repository.ComprasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComprasServiceImpl implements ComprasService {

    @Autowired
    private ComprasRepository comprasRepository;

    @Override
    public List<Compras> getAllCompras() {
        return comprasRepository.findAll();
    }

    @Override
    public Optional<Compras> getComprasById(Long id) {
        return comprasRepository.findById(id);
    }

    @Override
    public Compras saveCompras(Compras compras) {
        return comprasRepository.save(compras);
    }

    @Override
    public void deleteCompras(Long id) {
        comprasRepository.deleteById(id);
    }
}
