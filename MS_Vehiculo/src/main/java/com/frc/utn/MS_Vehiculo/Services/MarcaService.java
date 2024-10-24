package com.frc.utn.MS_Vehiculo.Services;


import com.frc.utn.MS_Vehiculo.Models.Marca;
import com.frc.utn.MS_Vehiculo.Repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService implements BaseService<Marca>{
    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public Marca save(Marca entity) throws Exception {
        try {
            return marcaRepository.save(entity);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Marca> findAll() throws Exception {
        try{
            return marcaRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Marca findById(Long id) throws Exception {
        try{
            Optional<Marca> marcaOpcional = marcaRepository.findById(id);
            return marcaOpcional.orElseThrow(() -> new Exception("Marca no encontrada con ID: " + id));

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            Marca marcaOptional = marcaRepository.findById(id).orElseThrow(()-> new Exception("Marca no encontrada con ID: " + id));
            marcaRepository.delete(marcaOptional);
            return true;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Marca update(Long id, Marca entity) throws Exception {
        try{
            Marca marca = marcaRepository.findById(id).orElseThrow(()-> new Exception("Marca no encontrada con ID: " + id));
            marca.setNombre(entity.getNombre());
            return marcaRepository.save(marca);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
