package ProgramacionWeb.database.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Pasajero;
import ProgramacionWeb.database.entities.dto.PasajeroDTO;
import ProgramacionWeb.database.repositories.AerolineaRepository;

@Mapper
public interface PasajeroMapper {

    PasajeroMapper INSTANCE = Mappers.getMapper(PasajeroMapper.class);

    // PASAJERO DTO -> PASAJERO
    @Mapping(source = "id_pasajero", target = "id")
    default
    Pasajero pasajeroDTOToPasajero(PasajeroDTO pasajeroDTO, AerolineaRepository repository){
        if(pasajeroDTO == null){
            return null;
        }

        Pasajero pasajero = new Pasajero();
        pasajero.setId(pasajeroDTO.getId_pasajero());
        pasajero.setNombres(pasajeroDTO.getNombres());
        pasajero.setApellidos(pasajeroDTO.getApellidos());
        pasajero.setTelefono(pasajeroDTO.getTelefono());
        pasajero.setAsientos(pasajeroDTO.getAsientos());
        pasajero.setReserva(ReservaMapper.INSTANCE.reservaDTOToReserva(pasajeroDTO.getReserva(), repository));
        return pasajero;
    }

    // PASAJERO -> PASAJERO DTO
    @Mapping(source = "id", target = "id_pasajero")
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
}
