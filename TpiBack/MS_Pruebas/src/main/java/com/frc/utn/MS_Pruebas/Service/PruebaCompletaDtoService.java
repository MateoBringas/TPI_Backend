package com.frc.utn.MS_Pruebas.Service;

import com.frc.utn.MS_Pruebas.DTO.*;
import com.frc.utn.MS_Pruebas.Exceptions.RestriccionInteresadoException;
import com.frc.utn.MS_Pruebas.Exceptions.VehiculoEnUsoException;
import com.frc.utn.MS_Pruebas.Models.Prueba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PruebaCompletaDtoService {

    @Autowired
    private VehiculoService vehiculoService;
    @Autowired
    private InteresadoService interesadoService;
    @Autowired
    private PruebaService pruebaService;
    @Autowired
    private EmpleadoService empleadoService;

    public PruebaCompletaDTO getPruebaCompletaById(Long id){
        Prueba prueba = pruebaService.findById(id);
        VehiculoDto vehiculoDto = vehiculoService.getVehiculoById(prueba.getIdVehiculo());
        InteresadoDto interesadoDto = interesadoService.getInteresadoById(prueba.getIdInteresado());
        EmpleadoDto empleadoDto = empleadoService.getEmpleadoById(prueba.getIdEmpleado());

        return new PruebaCompletaDTO(
                prueba.getId(),
                vehiculoDto,
                empleadoDto,
                interesadoDto,
                prueba.getFechaHoraInicio(),
                prueba.getFechaHoraFin(),
                prueba.getComentarios()
        );
    }

    public List<PruebaCompletaDTO> getPruebasCompletas(){
        List<Prueba> pruebas = pruebaService.findAll();
        List<PruebaCompletaDTO> pruebaCompletaDTOS = new ArrayList<>();
        for (Prueba prueba: pruebas){
            PruebaCompletaDTO pruebaCompletaDTO = getPruebaCompletaById(prueba.getId());
            pruebaCompletaDTOS.add(pruebaCompletaDTO);
        }
        return pruebaCompletaDTOS;
    }

    //1-A Crear Prueba con todas las validaciones
    public PruebaCompletaDTO createPruebaCompleta(Prueba prueba){
        InteresadoDto interesadoDto = interesadoService.getInteresadoById(prueba.getIdInteresado());

        //Validar si el ciente esta restringido
        if(interesadoDto.getRestringido() == 1){
            throw new RestriccionInteresadoException("El interesado está restringido y no puede realizar la prueba.");
        }

        //Validar que el interesado no tenga la licencia vencida
        if (interesadoDto.getFecha_vencimiento_licencia().isBefore(LocalDate.now())){
            throw new RestriccionInteresadoException("La licencia del interesado está vencida.");
        };

        VehiculoDto vehiculoDto = vehiculoService.getVehiculoById(prueba.getIdVehiculo());

        // Verificar si el vehículo ya está en una prueba activa
        List<Prueba> pruebasActivas = pruebaService.findByPruebaActiva();
        for (Prueba p : pruebasActivas){
            if(p.getIdVehiculo() == prueba.getIdVehiculo()){
                throw new VehiculoEnUsoException("El vehículo ya está en uso en otra prueba activa.");
            }
        }
        prueba.setFechaHoraInicio(LocalDateTime.now());
        prueba.setFechaHoraFin(null);
        prueba.setComentarios(null);
        pruebaService.save(prueba);
        return getPruebaCompletaById(prueba.getId());
    }
    //1-B Listar Pruebas Activas
    public List<PruebaCompletaDTO> getPruebasActivas(){
        List<Prueba> pruebas = pruebaService.findAll();
        List<PruebaCompletaDTO> pruebaCompletaDTOS = new ArrayList<>();
        for (Prueba prueba: pruebas){
            if (prueba.getFechaHoraFin() == null){
                PruebaCompletaDTO pruebaCompletaDTO = getPruebaCompletaById(prueba.getId());
                pruebaCompletaDTOS.add(pruebaCompletaDTO);
            }
        }
        return pruebaCompletaDTOS;
    }
    //1-C Finalizar Prueba
    public PruebaCompletaDTO finalizarPrueba(Long id, String comentario){
        Prueba prueba = pruebaService.findById(id);
        prueba.setFechaHoraFin(LocalDateTime.now());
        prueba.setComentarios(comentario);
        pruebaService.save(prueba);
        return getPruebaCompletaById(id);
    }
}
