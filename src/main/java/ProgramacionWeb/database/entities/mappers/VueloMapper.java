package ProgramacionWeb.database.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Vuelo;
import ProgramacionWeb.database.entities.dto.VueloDTO;

@Mapper
public interface VueloMapper {

    VueloMapper INSTANCE = Mappers.getMapper(VueloMapper.class);

    // VUELO DTO -> VUELO
    @Mapping(source = "id_vuelo", target = "id")
    Vuelo vueloDTOToVuelo(VueloDTO vueloDTO);

    // VUELO -> VUELO DTO
    @Mapping(source = "id", target = "id_vuelo")
    VueloDTO vueloToVueloDTO(Vuelo vuelo);

}
