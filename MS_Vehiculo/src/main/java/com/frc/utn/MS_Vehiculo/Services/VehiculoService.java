package com.frc.utn.MS_Vehiculo.Services;


import com.frc.utn.MS_Vehiculo.Models.Vehiculo;
import com.frc.utn.MS_Vehiculo.Repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService implements BaseService<Vehiculo>{
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo save(Vehiculo entity) throws Exception {
        try {
            return vehiculoRepository.save(entity);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Vehiculo> findAll() throws Exception {
        try {
            return vehiculoRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Vehiculo findById(Long id) throws Exception {
        try {
            Optional<Vehiculo> vehiculoOpcional = vehiculoRepository.findById(id);
            return vehiculoOpcional.orElseThrow(() -> new Exception("vehiculo no encontrado con ID: " + id));
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            Vehiculo vehiculoOptional = vehiculoRepository.findById(id).orElseThrow(()-> new Exception("vehiculo no encontrado con ID: " + id));
            vehiculoRepository.delete(vehiculoOptional);
            return true;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Vehiculo update(Long id, Vehiculo entity) throws Exception {
        try{
            Vehiculo vehiculo = vehiculoRepository.findById(id).orElseThrow(()-> new Exception("Marca no encontrada con ID: " + id));
            vehiculo.setPatente(entity.getPatente());
            return vehiculoRepository.save(vehiculo);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

