package ProgramacionWeb.database.entities.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Aerolinea;
import ProgramacionWeb.database.entities.dto.AerolineaDTO;

@Mapper 
public interface AerolineaMapper {

    AerolineaMapper INSTANCE = Mappers.getMapper(AerolineaMapper.class);

    @Mapping(source = "id", target = "id_aerolinea")
    public AerolineaDTO aerolineaToAerolineaDTO(Aerolinea aerolinea);
    
    @Mapping(source = "id_aerolinea", target = "id")
    public Aerolinea aerolineaDTOToAerolinea(AerolineaDTO aerolineaDTO);
}
