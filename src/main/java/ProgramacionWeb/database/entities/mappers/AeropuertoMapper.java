package ProgramacionWeb.database.entities.mappers;

import java.util.ArrayList;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Aeropuerto;
import ProgramacionWeb.database.entities.Vuelo;
import ProgramacionWeb.database.entities.dto.AeropuertoDTO;
import ProgramacionWeb.database.entities.dto.VueloDTO;
import ProgramacionWeb.database.entities.tosavedto.AeropuerToSDTO;

@Mapper
public interface AeropuertoMapper {

    AeropuertoMapper INSTANCE = Mappers.getMapper(AeropuertoMapper.class);

    // AEROPUERTO -> AEROPUERTO DTO
    default
    AeropuertoDTO aeropuertoToAeropuertoDTO(Aeropuerto aeropuerto) {
        if (aeropuerto == null) {
            return null;
        }
        AeropuertoDTO aeropuertoDTO = new AeropuertoDTO();
        aeropuertoDTO.setId_aeropuerto(aeropuerto.getId());
        aeropuertoDTO.setCiudad(aeropuerto.getCiudad());
        aeropuertoDTO.setPais(aeropuerto.getPais());
        aeropuertoDTO.setNombre(aeropuerto.getNombre());
        if(aeropuerto.getVuelosLlegadas() != null) {
            for (Vuelo vuelo : aeropuerto.getVuelosLlegadas()) {
                VueloDTO vueloDTO = VueloMapper.INSTANCE.vueloToVueloDTO(vuelo);
                aeropuertoDTO.getVueloLlegada().add(vueloDTO);
            }
        }else{
            aeropuertoDTO.setVueloLlegada(new ArrayList<>());
        }
        if(aeropuerto.getVuelosSalidas() != null) {
            for (Vuelo vuelo : aeropuerto.getVuelosSalidas()) {
                VueloDTO vueloDTO = VueloMapper.INSTANCE.vueloToVueloDTO(vuelo);
                aeropuertoDTO.getVueloSalida().add(vueloDTO);
            }
        }else{
            aeropuertoDTO.setVueloSalida(new ArrayList<>());
        }
        return aeropuertoDTO;
    }

    // AEROPUERTOTOSDTO -> AEROPUERTO
    default
    Aeropuerto aeropuertoToAeropuerto(AeropuerToSDTO aeropuertoDTO) {
        if (aeropuertoDTO == null) {
            return null;
        }
        Aeropuerto aeropuerto = new Aeropuerto();
        aeropuerto.setCiudad(aeropuertoDTO.getCiudad());
        aeropuerto.setPais(aeropuertoDTO.getPais());
        aeropuerto.setNombre(aeropuertoDTO.getNombre());
        aeropuerto.setVuelosSalidas(new ArrayList<>());
        aeropuerto.setVuelosLlegadas(new ArrayList<>());
        return aeropuerto;
    }
}
