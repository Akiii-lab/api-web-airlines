package ProgramacionWeb.database.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Aeropuerto;
import ProgramacionWeb.database.entities.dto.AeropuertoDTO;

@Mapper
public interface AeropuertoMapper {

    AeropuertoMapper INSTANCE = Mappers.getMapper(AeropuertoMapper.class);

    // AEROPUERTO DTO -> AEROPUERTO
    @Mapping(source = "id_aeropuerto", target = "id")
    Aeropuerto aeropuertoDTOToAeropuerto(AeropuertoDTO aeropuertoDTO);

    // AEROPUERTO -> AEROPUERTO DTO
    @Mapping(source = "id", target = "id_aeropuerto")
    AeropuertoDTO aeropuertoToAeropuertoDTO(Aeropuerto aeropuerto);
}
