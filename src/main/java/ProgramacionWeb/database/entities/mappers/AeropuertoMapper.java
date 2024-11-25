package ProgramacionWeb.database.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Aeropuerto;
import ProgramacionWeb.database.entities.Vuelo;
import ProgramacionWeb.database.entities.dto.AeropuertoDTO;
import ProgramacionWeb.database.entities.dto.VueloDTO;

@Mapper
public interface AeropuertoMapper {

    AeropuertoMapper INSTANCE = Mappers.getMapper(AeropuertoMapper.class);

    // AEROPUERTO DTO -> AEROPUERTO
    @Mapping(source = "id_aeropuerto", target = "id")
    default
    Aeropuerto aeropuertoDTOToAeropuerto(AeropuertoDTO aeropuertoDTO){
        if(aeropuertoDTO == null){
            return null;                
        }

        Aeropuerto aeropuerto = new Aeropuerto();
        aeropuerto.setId(aeropuertoDTO.getId_aeropuerto());
        aeropuerto.setNombre(aeropuertoDTO.getNombre());
        aeropuerto.setCiudad(aeropuertoDTO.getCiudad());
        aeropuerto.setPais(aeropuertoDTO.getPais());
        for(VueloDTO vueloDTO : aeropuertoDTO.getVueloLlegada()){
            aeropuerto.getVuelosLlegadas().add(VueloMapper.INSTANCE.vueloDTOToVuelo(vueloDTO));
        }
        for(VueloDTO vueloDTO : aeropuertoDTO.getVueloSalida()){
            aeropuerto.getVuelosSalidas().add(VueloMapper.INSTANCE.vueloDTOToVuelo(vueloDTO));
        }

        return aeropuerto;
    }

    // AEROPUERTO -> AEROPUERTO DTO
    @Mapping(source = "id", target = "id_aeropuerto")
    default
    AeropuertoDTO aeropuertoToAeropuertoDTO(Aeropuerto aeropuerto){
        if(aeropuerto == null){
            return null;                
        }

        AeropuertoDTO aeropuertoDTO = new AeropuertoDTO();
        aeropuertoDTO.setId_aeropuerto(aeropuerto.getId());
        aeropuertoDTO.setNombre(aeropuerto.getNombre());
        aeropuertoDTO.setCiudad(aeropuerto.getCiudad());
        aeropuertoDTO.setPais(aeropuerto.getPais());
        for(Vuelo vuelo : aeropuerto.getVuelosLlegadas()){
            aeropuertoDTO.getVueloLlegada().add(VueloMapper.INSTANCE.vueloToVueloDTO(vuelo));
        }
        for(Vuelo vuelo : aeropuerto.getVuelosSalidas()){
            aeropuertoDTO.getVueloSalida().add(VueloMapper.INSTANCE.vueloToVueloDTO(vuelo));
        }

        return aeropuertoDTO;
    }
}
