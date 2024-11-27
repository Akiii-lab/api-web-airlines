package ProgramacionWeb.database.entities.mappers;

import java.util.ArrayList;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Aerolinea;
import ProgramacionWeb.database.entities.Aeropuerto;
import ProgramacionWeb.database.entities.Cliente;
import ProgramacionWeb.database.entities.Pasajero;
import ProgramacionWeb.database.entities.Reserva;
import ProgramacionWeb.database.entities.Vuelo;
import ProgramacionWeb.database.entities.dto.AerolineaDTO;
import ProgramacionWeb.database.entities.dto.AeropuertoDTO;
import ProgramacionWeb.database.entities.dto.ClienteDTO;
import ProgramacionWeb.database.entities.dto.PasajeroDTO;
import ProgramacionWeb.database.entities.dto.ReservaDTO;
import ProgramacionWeb.database.entities.dto.VueloDTO;
import ProgramacionWeb.database.entities.tosavedto.ClienteUToSDTO;
import ProgramacionWeb.database.entities.tosavedto.PasajeroToSDTO;
import ProgramacionWeb.database.entities.tosavedto.ReservaToSDTO;
import ProgramacionWeb.database.entities.tosavedto.VueloToSDTO;


@Mapper
public interface ReservaMapper {

    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    // RESERVA -> RESERVA DTO
    default
    ReservaDTO reservaToReservaDTO(Reserva reserva) {
        if (reserva == null) {
            return null;
        }
        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setId_reserva(reserva.getId());
        reservaDTO.setFecha(reserva.getFecha());
        if(reserva.getCliente() != null) {
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setId_cliente(reserva.getCliente().getId());
            clienteDTO.setNombres(reserva.getCliente().getNombres());
            clienteDTO.setApellidos(reserva.getCliente().getApellidos());
            reservaDTO.setCliente(clienteDTO);
        }
        reservaDTO.setNum_pasajeros(reserva.getNum_pasajeros());
        if(reserva.getPasajeros() != null) {
            for (Pasajero pasajero : reserva.getPasajeros()) {
                PasajeroDTO pasajeroDTO = new PasajeroDTO();
                pasajeroDTO.setId_pasajero(pasajero.getId());
                pasajeroDTO.setNombres(pasajero.getNombres());
                pasajeroDTO.setApellidos(pasajero.getApellidos());
                pasajeroDTO.setTelefono(pasajero.getTelefono());
                pasajeroDTO.setAsientos(pasajero.getAsientos());
                reservaDTO.getPasajeros().add(pasajeroDTO);
            }
        }
        if(reserva.getVuelos() != null) {
            for( Vuelo vuelo :reserva.getVuelos()){
                VueloDTO vueloDTO = new VueloDTO();
                vueloDTO.setId_vuelo(vuelo.getId());
                vueloDTO.setOrigen(vuelo.getOrigen());
                vueloDTO.setDestino(vuelo.getDestino());
                vueloDTO.setFecha_salida(vuelo.getFecha_salida());
                vueloDTO.setHora_salida(vuelo.getHora_salida());
                vueloDTO.setPrecio(vuelo.getPrecio());
                vueloDTO.setDuracion(vuelo.getDuracion());
                vueloDTO.setCapacidad(vuelo.getCapacidad());
                if(vuelo.getAerolinea() != null) {
                    AerolineaDTO aerolineaDTO = new AerolineaDTO();
                    aerolineaDTO.setId_aerolinea(vuelo.getAerolinea().getId());
                    aerolineaDTO.setNombre(vuelo.getAerolinea().getNombre());
                    aerolineaDTO.setCodigo_arolinea(vuelo.getAerolinea().getCodigo_arolinea());
                    aerolineaDTO.setPais(vuelo.getAerolinea().getPais());
                    vueloDTO.setAerolinea(aerolineaDTO);
                }else{
                    vueloDTO.setAerolinea(null);
                }
                if(vuelo.getAeropuertoSalida() != null) {
                    AeropuertoDTO aeropuertoDTO = new AeropuertoDTO();
                    aeropuertoDTO.setId_aeropuerto(vuelo.getAeropuertoSalida().getId());
                    aeropuertoDTO.setNombre(vuelo.getAeropuertoSalida().getNombre());
                    aeropuertoDTO.setCiudad(vuelo.getAeropuertoSalida().getCiudad());
                    aeropuertoDTO.setPais(vuelo.getAeropuertoSalida().getPais());
                    vueloDTO.setAeropuertoSalida(aeropuertoDTO);
                }else{
                    vueloDTO.setAeropuertoSalida(null);
                }
                if(vuelo.getAeropuertoLlegada() != null) {
                    AeropuertoDTO aeropuertoDTO = new AeropuertoDTO();    
                    aeropuertoDTO.setId_aeropuerto(vuelo.getAeropuertoLlegada().getId());
                    aeropuertoDTO.setNombre(vuelo.getAeropuertoLlegada().getNombre());
                    aeropuertoDTO.setCiudad(vuelo.getAeropuertoLlegada().getCiudad());
                    aeropuertoDTO.setPais(vuelo.getAeropuertoLlegada().getPais());    
                    vueloDTO.setAeropuertoLlegada(aeropuertoDTO);
                }else{
                    vueloDTO.setAeropuertoLlegada(null);
                }
                reservaDTO.getVuelos().add(vueloDTO);
            }
        }
        return reservaDTO;
    }

    //RESERVATOSDTO -> RESERVA
    default
    Reserva reservaToReserva(ReservaToSDTO reservaToSave) {
        if(reservaToSave == null) {
            return null;
        }
        Reserva reserva = new Reserva();
        reserva.setFecha(reservaToSave.getFecha());
        reserva.setNum_pasajeros(reservaToSave.getNum_pasajeros());
        if(reservaToSave.getCliente() != null) {
            ClienteUToSDTO clienteDTO = reservaToSave.getCliente();
            Cliente cliente = new Cliente();
            cliente.setNombres(clienteDTO.getNombres());
            cliente.setApellidos(clienteDTO.getApellidos());
            cliente.setDni(clienteDTO.getDni());
            cliente.setTelefono(clienteDTO.getTelefono());
            cliente.setCorreo(clienteDTO.getCorreo());
            cliente.setRole("user");
            cliente.setDireccion(clienteDTO.getDireccion());
            cliente.setPassword(clienteDTO.getPassword());
            reserva.setCliente(cliente);
        }
        System.out.println("vuelos: " + reservaToSave.getVuelos());
        if(reservaToSave.getVuelos() != null) {
            for(VueloToSDTO vueloDTO : reservaToSave.getVuelos()) {
                Vuelo vuelo = new Vuelo();
                vuelo.setOrigen(vueloDTO.getOrigen());
                vuelo.setDestino(vueloDTO.getDestino());
                vuelo.setFecha_salida(vueloDTO.getFecha_salida());
                vuelo.setHora_salida(vueloDTO.getHora_salida());
                vuelo.setPrecio(vueloDTO.getPrecio());
                vuelo.setDuracion(vueloDTO.getDuracion());
                vuelo.setCapacidad(vueloDTO.getCapacidad());
                if(vueloDTO.getAerolinea() != null) {
                    Aerolinea aerolinea = new Aerolinea();
                    aerolinea.setNombre(vueloDTO.getAerolinea().getNombre());
                    aerolinea.setCodigo_arolinea(vueloDTO.getAerolinea().getCodigo_arolinea());
                    aerolinea.setPais(vueloDTO.getAerolinea().getPais());
                    vuelo.setAerolinea(aerolinea);
                }else{
                    vuelo.setAerolinea(null);
                }
                if(vueloDTO.getAeropuerto_salida() != null) {
                    Aeropuerto aeropuerto = new Aeropuerto();
                    aeropuerto.setNombre(vueloDTO.getAeropuerto_salida().getNombre());
                    aeropuerto.setCiudad(vueloDTO.getAeropuerto_salida().getCiudad());
                    aeropuerto.setPais(vueloDTO.getAeropuerto_salida().getPais());
                    vuelo.setAeropuertoSalida(aeropuerto);
                }else{
                    vuelo.setAeropuertoSalida(null);
                }
                if(vueloDTO.getAeropuerto_llegada() != null) {
                    Aeropuerto aeropuerto = new Aeropuerto();
                    aeropuerto.setNombre(vueloDTO.getAeropuerto_llegada().getNombre());
                    aeropuerto.setCiudad(vueloDTO.getAeropuerto_llegada().getCiudad());
                    aeropuerto.setPais(vueloDTO.getAeropuerto_llegada().getPais());
                    vuelo.setAeropuertoLlegada(aeropuerto);
                }else{
                    vuelo.setAeropuertoLlegada(null);
                }
                reserva.getVuelos().add(vuelo);
            }
        }else{
            reserva.setVuelos(new ArrayList<>());
        }
        if(reservaToSave.getPasajeros() != null) {
            for(PasajeroToSDTO pasajeroDTO : reservaToSave.getPasajeros()) {
                Pasajero pasajero = new Pasajero();
                pasajero.setNombres(pasajeroDTO.getNombres());
                pasajero.setApellidos(pasajeroDTO.getApellidos());
                pasajero.setTelefono(pasajeroDTO.getTelefono());
                pasajero.setAsientos(pasajeroDTO.getAsientos());
                reserva.getPasajeros().add(pasajero);
            }
        }else{
            reserva.setPasajeros(null);
        }
        return reserva;
    }
}
