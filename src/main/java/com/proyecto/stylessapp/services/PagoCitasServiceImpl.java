
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.PagoCitas;
import com.proyecto.stylessapp.model.PagoCitasId;
import com.proyecto.stylessapp.repository.PagoCitasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoCitasServiceImpl implements PagoCitasService{
    
    @Autowired
    private PagoCitasRepository pagoCitasRepository;

    @Override
    public PagoCitas savePagoCitas(PagoCitas pagoCitas) {
        return pagoCitasRepository.save(pagoCitas); 
    }

    @Override
    public Optional<PagoCitas> getPagoCitasById(PagoCitasId id) {
        return pagoCitasRepository.findById(id); 
    }

    @Override
    public List<PagoCitas> getAllPagosCitas() {
        return pagoCitasRepository.findAll(); 
    }

    @Override
    public PagoCitas updatePagoCitas(PagoCitas pagoCitas) {
        return pagoCitasRepository.save(pagoCitas); 
    }

    @Override
    public void deletePagoCitas(PagoCitasId id) {
         pagoCitasRepository.deleteById(id); 
    }
}
