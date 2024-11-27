package ProgramacionWeb.database.entities.mappers;

import java.util.ArrayList;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

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
@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    //Cliente -> Cliente DTO
    default
    ClienteDTO clienteToClienteDTO(Cliente cliente) {
        if(cliente == null) {
            return null;
        }
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId_cliente(cliente.getId());
        clienteDTO.setNombres(cliente.getNombres());
        clienteDTO.setApellidos(cliente.getApellidos());
        clienteDTO.setDni(cliente.getDni());
        clienteDTO.setTelefono(cliente.getTelefono());
        clienteDTO.setCorreo(cliente.getCorreo());
        clienteDTO.setDireccion(cliente.getDireccion());
        clienteDTO.setRole(cliente.getRole());
        clienteDTO.setPassword(cliente.getPassword());
        if(cliente.getReservas() != null) {
            for(Reserva reserva : cliente.getReservas()) {
                ReservaDTO reservaDTO = new ReservaDTO();
                reservaDTO.setId_reserva(reserva.getId());
                reservaDTO.setFecha(reserva.getFecha());
                reservaDTO.setNum_pasajeros(reserva.getNum_pasajeros());
                if(reserva.getPasajeros() != null) {
                    for(Pasajero pasajero : reserva.getPasajeros()) {
                        PasajeroDTO pasajeroDTO = new PasajeroDTO();
                        pasajeroDTO.setId_pasajero(pasajero.getId());
                        pasajeroDTO.setNombres(pasajero.getNombres());
                        pasajeroDTO.setApellidos(pasajero.getApellidos());
                        pasajeroDTO.setTelefono(pasajero.getTelefono());
                        pasajeroDTO.setAsientos(pasajero.getAsientos());
                        reservaDTO.getPasajeros().add(pasajeroDTO);
                    }
                }else{
                    reservaDTO.setPasajeros(null);
                }
                if(reserva.getVuelos() != null) {
                    for(Vuelo vuelo : reserva.getVuelos()) {
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
                }else{
                    reservaDTO.setVuelos(new ArrayList<>());
                }
                clienteDTO.getReservas().add(reservaDTO);
            }
        }else{
            clienteDTO.setReservas(new ArrayList<>());
        }
        return clienteDTO;
    }

    //ClienteToSDTO -> Cliente
    default
    Cliente clienteToCliente(ClienteUToSDTO clienteToSave) {
        if(clienteToSave == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setNombres(clienteToSave.getNombres());
        cliente.setApellidos(clienteToSave.getApellidos());
        cliente.setTelefono(clienteToSave.getTelefono());
        cliente.setDni(clienteToSave.getDni());
        cliente.setDireccion(clienteToSave.getDireccion());
        cliente.setCorreo(clienteToSave.getCorreo());
        cliente.setPassword(clienteToSave.getPassword());
        cliente.setRole("user");
        cliente.setReservas(new ArrayList<>());
        return cliente;
    }
}
