package ProgramacionWeb.database.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Pasajero;
import ProgramacionWeb.database.entities.Reserva;
import ProgramacionWeb.database.entities.Vuelo;
import ProgramacionWeb.database.entities.dto.PasajeroDTO;
import ProgramacionWeb.database.entities.dto.ReservaDTO;
import ProgramacionWeb.database.entities.dto.VueloDTO;


@Mapper
public interface ReservaMapper {

    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    // RESERVA DTO -> RESERVA
    @Mapping(source = "id", target = "id_reserva")
        default
        ReservaDTO reservaToReservaDTO(Reserva reserva){
            if(reserva == null){
                return null;
            }
            ReservaDTO reservaDTO = new ReservaDTO();
            reservaDTO.setId_reserva(reserva.getId());
            reservaDTO.setFecha(reserva.getFecha());
            reservaDTO.setNum_pasajeros(reserva.getNum_pasajeros());
            for(Pasajero pasajero : reserva.getPasajeros()){
                reservaDTO.getPasajeros().add(PasajeroMapper.INSTANCE.pasajeroToPasajeroDTO(pasajero));
            }
            for(Vuelo vuelo : reserva.getVuelos()){
                reservaDTO.getVuelos().add(VueloMapper.INSTANCE.vueloToVueloDTO(vuelo));
            }
            reservaDTO.setCliente(ClienteMapper.INSTANCE.clienteToClienteDTO(reserva.getCliente()));
            
            return reservaDTO;
        }

    // RESERVA -> RESERVA DTO
    @Mapping(source = "id_reserva", target = "id")
        default
        Reserva reservaDTOToReserva(ReservaDTO reservaDTO){
            if(reservaDTO == null){
                return null;
            }
    
            Reserva reserva = new Reserva();
            reserva.setId(reservaDTO.getId_reserva());
            reserva.setFecha(reservaDTO.getFecha());
            reserva.setNum_pasajeros(reservaDTO.getNum_pasajeros());
            for(PasajeroDTO pasajeroDTO : reservaDTO.getPasajeros()){
                reserva.getPasajeros().add(PasajeroMapper.INSTANCE.pasajeroDTOToPasajero(pasajeroDTO));
            }
            for(VueloDTO vueloDTO : reservaDTO.getVuelos()){
                reserva.getVuelos().add(VueloMapper.INSTANCE.vueloDTOToVuelo(vueloDTO));
            }
            reserva.setCliente(ClienteMapper.INSTANCE.clienteDTOToCliente(reservaDTO.getCliente()));
            return reserva;
        }
}
