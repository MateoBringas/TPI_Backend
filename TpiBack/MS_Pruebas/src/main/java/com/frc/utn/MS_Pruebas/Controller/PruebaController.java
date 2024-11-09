package com.frc.utn.MS_Pruebas.Controller;

import com.frc.utn.MS_Pruebas.DTO.EmpleadoDto;
import com.frc.utn.MS_Pruebas.DTO.InteresadoDto;
import com.frc.utn.MS_Pruebas.DTO.PruebaCompletaDTO;
import com.frc.utn.MS_Pruebas.DTO.VehiculoDto;
import com.frc.utn.MS_Pruebas.Models.Prueba;
import com.frc.utn.MS_Pruebas.Service.EmpleadoService;
import com.frc.utn.MS_Pruebas.Service.InteresadoService;
import com.frc.utn.MS_Pruebas.Service.PruebaService;
import com.frc.utn.MS_Pruebas.Service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pruebas")
public class PruebaController {

    @Autowired
    private VehiculoService vehiculoService;
    @Autowired
    private InteresadoService interesadoService;
    @Autowired
    private PruebaService pruebaService;
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/{id}")
    public PruebaCompletaDTO getPruebaById(@PathVariable Long id){
        Prueba prueba = pruebaService.findById(id);
        VehiculoDto vehiculoDto = vehiculoService.getVehiculoById(prueba.getIdVehiculo());
        InteresadoDto interesadoDto = interesadoService.getInteresadoById(prueba.getIdInteresado());
        EmpleadoDto empleadoDto = empleadoService.getEmpleadoById(prueba.getIdEmpleado());

        PruebaCompletaDTO pruebaCompletaDTO = new PruebaCompletaDTO(
                prueba.getId(),
                vehiculoDto,
                empleadoDto,
                interesadoDto,
                prueba.getFechaHoraInicio(),
                prueba.getFechaHoraFin(),
                prueba.getComentarios()
        );
        return pruebaCompletaDTO;
    }

    @GetMapping
    public List<PruebaCompletaDTO> getAllPruebas(){
        List<Prueba> pruebas = pruebaService.findAll();
        List<PruebaCompletaDTO> pruebaCompletaDTOS = new ArrayList<>();
        for(Prueba prueba : pruebas){
            VehiculoDto vehiculoDto = vehiculoService.getVehiculoById(prueba.getIdVehiculo());
            InteresadoDto interesadoDto = interesadoService.getInteresadoById(prueba.getIdInteresado());
            EmpleadoDto empleadoDto = empleadoService.getEmpleadoById(prueba.getIdEmpleado());
            PruebaCompletaDTO pruebaCompletaDTO = new PruebaCompletaDTO(
                    prueba.getId(),
                    vehiculoDto,
                    empleadoDto,
                    interesadoDto,
                    prueba.getFechaHoraInicio(),
                    prueba.getFechaHoraFin(),
                    prueba.getComentarios()
            );
            pruebaCompletaDTOS.add(pruebaCompletaDTO);
        }
        return pruebaCompletaDTOS;
    }
}
