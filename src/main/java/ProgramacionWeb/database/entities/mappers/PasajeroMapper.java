package ProgramacionWeb.database.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Pasajero;
import ProgramacionWeb.database.entities.dto.PasajeroDTO;

@Mapper
public interface PasajeroMapper {

    PasajeroMapper INSTANCE = Mappers.getMapper(PasajeroMapper.class);

    // PASAJERO DTO -> PASAJERO
    @Mapping(source = "id", target = "id_pasajero")
    Pasajero pasajeroDTOToPasajero(PasajeroDTO pasajeroDTO);

    // PASAJERO -> PASAJERO DTO
    @Mapping(source = "id_pasajero", target = "id")
    PasajeroDTO pasajeroToPasajeroDTO(Pasajero pasajero);
}
