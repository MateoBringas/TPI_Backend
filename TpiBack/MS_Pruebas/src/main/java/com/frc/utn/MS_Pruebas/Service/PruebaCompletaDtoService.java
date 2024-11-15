package com.frc.utn.MS_Pruebas.Service;

import com.frc.utn.MS_Pruebas.DTO.*;
import com.frc.utn.MS_Pruebas.Exceptions.LicenciaVencidaException;
import com.frc.utn.MS_Pruebas.Exceptions.RestriccionInteresadoException;
import com.frc.utn.MS_Pruebas.Exceptions.VehiculoEnUsoException;
import com.frc.utn.MS_Pruebas.Models.Prueba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    @Autowired
    private PosicionService posicionService;
    @Autowired
    private ZonaService zonaService;
    @Autowired
    private NotificacionService notificacionService;

    public PruebaCompletaDTO getPruebaCompletaById(Long id) {
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

    public List<PruebaCompletaDTO> getPruebasCompletas() {
        List<Prueba> pruebas = pruebaService.findAll();
        List<PruebaCompletaDTO> pruebaCompletaDTOS = new ArrayList<>();
        for (Prueba prueba : pruebas) {
            PruebaCompletaDTO pruebaCompletaDTO = getPruebaCompletaById(prueba.getId());
            pruebaCompletaDTOS.add(pruebaCompletaDTO);
        }
        return pruebaCompletaDTOS;
    }

    public PosicionDto getPosicion(Long id) {
        return posicionService.posicionById(id);
    }

    //controlar
    private boolean esDentroDelRadio(double lat1, double lon1, double lat2, double lon2, int radioKm) {
        double distancia = Math.sqrt(Math.pow(lat2 - lat1, 2) + Math.pow(lon2 - lon1, 2));
        return distancia <= radioKm;
    }

    private boolean estaEnZonaRestringida(List<ZonaRestringidasDto> zonasRestringidas, double lat, double lon) {
        for (ZonaRestringidasDto zona : zonasRestringidas) {
            double latNoroeste = zona.getNoroeste().getLat();
            double lonNoroeste = zona.getNoroeste().getLon();
            double latSureste = zona.getSureste().getLat();
            double lonSureste = zona.getSureste().getLon();

            // Verificar si la posición está dentro de los límites del cuadrante
            if (lat <= latNoroeste && lat >= latSureste && lon >= lonNoroeste && lon <= lonSureste) {
                return true;
            }
        }
        return false;
    }

    //1-A Crear Prueba con todas las validaciones
    public PruebaCompletaDTO createPruebaCompleta(Prueba prueba) {
        InteresadoDto interesadoDto = interesadoService.getInteresadoById(prueba.getIdInteresado());

        //Validar si el ciente esta restringido
        if (interesadoDto.getRestringido() == 1) {
            throw new RestriccionInteresadoException("El interesado está restringido y no puede realizar la prueba.");
        }

        //Validar que el interesado no tenga la licencia vencida
        if (interesadoDto.getFecha_vencimiento_licencia().isBefore(LocalDate.now())) {
            throw new LicenciaVencidaException("La licencia del interesado está vencida.");
        }
        ;

        // Verificar si el vehículo ya está en una prueba activa
        List<Prueba> pruebasActivas = pruebaService.findByPruebaActiva();
        for (Prueba p : pruebasActivas) {
            if (p.getIdVehiculo() == prueba.getIdVehiculo()) {
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
    public List<PruebaCompletaDTO> getPruebasActivas() {
        List<Prueba> pruebas = pruebaService.findAll();
        List<PruebaCompletaDTO> pruebaCompletaDTOS = new ArrayList<>();
        for (Prueba prueba : pruebas) {
            if (prueba.getFechaHoraFin() == null) {
                PruebaCompletaDTO pruebaCompletaDTO = getPruebaCompletaById(prueba.getId());
                pruebaCompletaDTOS.add(pruebaCompletaDTO);
            }
        }
        return pruebaCompletaDTOS;
    }

    //1-C Finalizar Prueba
    public PruebaCompletaDTO finalizarPrueba(Long id, String comentario) {
        Prueba prueba = pruebaService.findById(id);
        prueba.setFechaHoraFin(LocalDateTime.now());
        prueba.setComentarios(comentario);
        pruebaService.save(prueba);
        return getPruebaCompletaById(id);
    }

    //1-D Validar Posicion
    public String validarPosicion(Long id) {
        PosicionDto posicionDto = getPosicion(id);
        List<PruebaCompletaDTO> pruebasActivas = getPruebasActivas();
        AgenciaDto agenciaDto = zonaService.getAgenciaZonaRestringida();

        for (PruebaCompletaDTO prueba : pruebasActivas) {
            if (posicionDto.getVehiculo().getId().equals(prueba.getVehiculoDto().getId())) {
                // Verificar si el vehículo está fuera del radio permitido
                boolean fueraDeRadio = !esDentroDelRadio(
                        agenciaDto.getCoordenadasAgencia().getLat(),
                        agenciaDto.getCoordenadasAgencia().getLon(),
                        posicionDto.getLatitud(),
                        posicionDto.getLongitud(),
                        agenciaDto.getRadioAdmitidoKm()
                );

                // Verificar si el vehículo está dentro de una zona restringida
                boolean enZonaRestringida = estaEnZonaRestringida(
                        agenciaDto.getZonasRestringidas(),
                        posicionDto.getLatitud(),
                        posicionDto.getLongitud()
                );

                // Si el vehículo está fuera del radio o dentro de una zona peligrosa
                if (fueraDeRadio || enZonaRestringida) {
                    // Notificar al empleado que haga regresar el vehículo
                    NotificacionDto notificacionDto = new NotificacionDto(
                            "Limites excedidos - Regresar el vehículo de manera inmediata",
                            List.of(new TelefonoDestinatarioDto(prueba.getEmpleadoDto().getTelefonoContacto()))
                    );
                    notificacionService.enviarNotificacion(notificacionDto);

                    // Agregar al cliente en la lista de clientes restringidos
                    prueba.getInteresadoDto().setRestringido(1);
                    interesadoService.updateInteresado(prueba.getInteresadoDto());
                    // Finalizar Prueba
                    finalizarPrueba(prueba.getId(), "Limites excedidos");
                    return "Limites excedidos - Regresar el vehículo de manera inmediata";
                } else {
                    return "Vehiculo en posicion correcta :) .";

                }
            }
        }
        return "Vehículo no encontrado en las pruebas activas.";
    }
    //1-E
    public String getReportes(Long idVehiculo){
        String mensaje = "Reporte de Pruebas Realizadas:\n";
        int contadorPruebasIncidentes = 0;
        List<Prueba> pruebas = pruebaService.findAll();
        for (Prueba prueba : pruebas) {
            if(prueba.getIdVehiculo().equals(idVehiculo)) {
                PruebaCompletaDTO pruebaCompletaDTO = getPruebaCompletaById(prueba.getId());

                // Supongamos que PruebaCompletaDTO tiene métodos para obtener los detalles de la prueba
                mensaje += "Prueba ID: " + pruebaCompletaDTO.getId() + "\n";
                mensaje += "Vehiculo: " + pruebaCompletaDTO.getVehiculoDto() + "\n";
                mensaje += "Empleado: " + pruebaCompletaDTO.getEmpleadoDto() + "\n";
                mensaje += "Interesado: " + pruebaCompletaDTO.getInteresadoDto() + "\n";
                mensaje += "FechaInicio: " + pruebaCompletaDTO.getFechaHoraInicio() + "\n";
                mensaje += "FechaFin: " + pruebaCompletaDTO.getFechaHoraFin() + "\n";
                mensaje += "Descripción: " + pruebaCompletaDTO.getComentarios() + "\n";
                mensaje += "-----------------------------------\n";

            }
            // Contar incidentes, si aplicable
            if (Objects.equals(prueba.getComentarios(),"Limites excedidos")) {
                contadorPruebasIncidentes++;
            }
        }

        mensaje += "\nTotal de Incidentes: " + contadorPruebasIncidentes;
        return mensaje;
    }

}
