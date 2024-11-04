package com.frc.utn.MS_Interesados.Service;

import com.frc.utn.MS_Interesados.Repository.InteresadoRepository;
import com.frc.utn.MS_Interesados.models.Interesado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InteresadoService implements BaseService<Interesado> {
    @Autowired
    private InteresadoRepository interesadoRepository;

    @Override
    public Interesado save(Interesado entity) throws Exception {
        try {
            return interesadoRepository.save(entity);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Interesado> findAll() throws Exception {
        try{
            return interesadoRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Interesado findById(Long id) throws Exception {
        try {
            Optional<Interesado> interesado = interesadoRepository.findById(id);
            return interesado.orElseThrow(()-> new Exception(id+" no encontrado"));
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Interesado update(Long id, Interesado entity) throws Exception {
        try{
            Interesado interesado = interesadoRepository.findById(id).orElseThrow(()-> new Exception("interesado no encontrado con id: " + id));
            interesado.setTipo_documento(entity.getTipo_documento());
            interesado.setDocumento(entity.getDocumento());
            interesado.setNombre(entity.getNombre());
            interesado.setApellido(entity.getApellido());
            interesado.setRestringido(entity.getRestringido());
            interesado.setNro_licencia(entity.getNro_licencia());
            interesado.setFecha_vencimiento_licencia(entity.getFecha_vencimiento_licencia());
            return interesadoRepository.save(interesado);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            Interesado interesadoOptional = interesadoRepository.findById(id).orElseThrow(()-> new Exception("Interesado no encontrado con id: " + id));
            interesadoRepository.delete(interesadoOptional);
            return true;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
