package com.frc.utn.MS_Vehiculo.Services;


import com.frc.utn.MS_Vehiculo.Models.Modelo;
import com.frc.utn.MS_Vehiculo.Repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService implements BaseService<Modelo>{
    @Autowired
    private ModeloRepository modeloRepository;

    @Override
    public Modelo save(Modelo entity) throws Exception {
        try {
            return modeloRepository.save(entity);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Modelo> findAll() throws Exception {
        try{
            return modeloRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Modelo findById(Long id) throws Exception {
        try{
            Optional<Modelo> modeloOpcional = modeloRepository.findById(id);
            return modeloOpcional.orElseThrow(() -> new Exception("Modelo no encontrado con ID: " + id));

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            Modelo modeloOptional = modeloRepository.findById(id).orElseThrow(()-> new Exception("Modelo no encontrado con ID: " + id));
            modeloRepository.delete(modeloOptional);
            return true;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Modelo update(Long id, Modelo entity) throws Exception {
        try{
            Modelo modelo = modeloRepository.findById(id).orElseThrow(()-> new Exception("Modelo no encontrado con ID: " + id));
            modelo.setDescripcion(entity.getDescripcion());
            modelo.setId_marca(entity.getId_marca());
            return modeloRepository.save(modelo);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

