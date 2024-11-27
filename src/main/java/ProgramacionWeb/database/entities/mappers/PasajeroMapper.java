package ProgramacionWeb.database.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Pasajero;
import ProgramacionWeb.database.entities.Reserva;
import ProgramacionWeb.database.entities.dto.PasajeroDTO;
import ProgramacionWeb.database.entities.dto.ReservaDTO;
import ProgramacionWeb.database.entities.tosavedto.PasajeroToSDTO;

@Mapper
public interface PasajeroMapper {

    PasajeroMapper INSTANCE = Mappers.getMapper(PasajeroMapper.class);

    // PASAJERO - > PASAJERO DTO
    default
    PasajeroDTO pasajeroToPasajeroDTO(Pasajero pasajero){
        if(pasajero == null){
            return null;
        }
        PasajeroDTO pasajeroDTO = new PasajeroDTO();
        pasajeroDTO.setId_pasajero(pasajero.getId());
        pasajeroDTO.setNombres(pasajero.getNombres());
        pasajeroDTO.setApellidos(pasajero.getApellidos());
        pasajeroDTO.setTelefono(pasajero.getTelefono());
        pasajeroDTO.setAsientos(pasajero.getAsientos());
        pasajeroDTO.setReserva(ReservaMapper.INSTANCE.reservaToReservaDTO(pasajero.getReserva()));
        return pasajeroDTO;
    }

    // PASAJEROTOSDTO -> PASAJERO
    default
    Pasajero pasajeroDTOToPasajero(PasajeroToSDTO pasajeroToSave){
        if(pasajeroToSave == null){
            return null;
        }
        Pasajero pasajero = new Pasajero();
        pasajero.setNombres(pasajeroToSave.getNombres());
        pasajero.setApellidos(pasajeroToSave.getApellidos());
        pasajero.setTelefono(pasajeroToSave.getTelefono());
        pasajero.setAsientos(pasajeroToSave.getAsientos());
        ReservaDTO reservaToSave = pasajeroToSave.getReserva();
        Reserva reserva = new Reserva();
        reserva.setId(reservaToSave.getId_reserva());
        reserva.setFecha(reservaToSave.getFecha());
        reserva.setNum_pasajeros(reservaToSave.getNum_pasajeros());
        pasajero.setReserva(reserva);
        return pasajero;
    }
}
