package com.frc.utn.MS_Pruebas.Service;

import com.frc.utn.MS_Pruebas.Models.Prueba;
import com.frc.utn.MS_Pruebas.Repository.PruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PruebaService implements BaseService<Prueba> {

    @Autowired
    private PruebaRepository pruebaRepository;

    @Override
    public Prueba save(Prueba prueba){
        return pruebaRepository.save(prueba);
    }

    @Override
    public Prueba update(Prueba prueba, Long id) {
        Prueba pruebaAModificar = pruebaRepository.findById(id).orElse(null);
        if (pruebaAModificar != null){
            pruebaAModificar.setIdVehiculo(prueba.getIdVehiculo());
            pruebaAModificar.setIdInteresado(prueba.getIdInteresado());
            pruebaAModificar.setIdEmpleado(prueba.getIdEmpleado());
            pruebaAModificar.setFechaHoraInicio(prueba.getFechaHoraInicio());
            pruebaAModificar.setFechaHoraFin(prueba.getFechaHoraFin());
            pruebaAModificar.setComentarios(prueba.getComentarios());

            return pruebaRepository.save(pruebaAModificar);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        pruebaRepository.deleteById(id);
    }

    @Override
    public Prueba findById(Long id) {
        return pruebaRepository.findById(id).orElse(null);
    }


    public List<Prueba> findAll(){
        return pruebaRepository.findAll();
    }

    public List<Prueba> findByPruebaActiva(){
        List<Prueba> pruebas = pruebaRepository.findAll();
        List<Prueba> pruebaActiva = new ArrayList<Prueba>();
        for (Prueba prueba : pruebas){
            if (prueba.getFechaHoraFin() == null){
                pruebaActiva.add(prueba);
            }
        }
        return pruebaActiva;
    }

}
