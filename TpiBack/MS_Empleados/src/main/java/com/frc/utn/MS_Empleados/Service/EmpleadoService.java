package com.frc.utn.MS_Empleados.Service;

import com.frc.utn.MS_Empleados.Models.Empleado;
import com.frc.utn.MS_Empleados.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements BaseService<Empleado>{
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Empleado save(Empleado entity) throws Exception {
        try {
            return empleadoRepository.save(entity);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Empleado> findAll() throws Exception {
        try{
            return empleadoRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Empleado findById(Long legajo) throws Exception {
        try{
            Optional<Empleado> empleadoOpcional = empleadoRepository.findById(legajo);
            return empleadoOpcional.orElseThrow(() -> new Exception("Empleado no encontrado con legajo: " + legajo));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long legajo) throws Exception {
        try {
            Empleado empleadoOptional = empleadoRepository.findById(legajo).orElseThrow(()-> new Exception("Empleado no encontrado con legajo: " + legajo));
            empleadoRepository.delete(empleadoOptional);
            return true;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Empleado update(Long legajo, Empleado entity) throws Exception {
        try{
            Empleado empleado = empleadoRepository.findById(legajo).orElseThrow(()-> new Exception("Empleado no encontrado con legajo: " + legajo));
            empleado.setNombre(entity.getNombre());
            empleado.setApellido(entity.getApellido());
            empleado.setTelefonoContacto(entity.getTelefonoContacto());
            return empleadoRepository.save(empleado);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

