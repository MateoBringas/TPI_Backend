package com.frc.utn.MS_Posiciones.Service;

import com.frc.utn.MS_Posiciones.Models.Posicion;
import com.frc.utn.MS_Posiciones.Repository.PosicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosicionService {
    @Autowired
    private PosicionRepository posicionRepository;

    public Posicion getPosicion(Long id){
        Optional<Posicion> posicion = posicionRepository.findById(id);
        return posicion.get();
    }

    public List<Posicion> getPosiciones(){
        return posicionRepository.findAll();
    }
}
