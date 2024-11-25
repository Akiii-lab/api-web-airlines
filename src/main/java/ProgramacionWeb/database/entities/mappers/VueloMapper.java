package ProgramacionWeb.database.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import ProgramacionWeb.database.entities.Vuelo;
import ProgramacionWeb.database.entities.dto.VueloDTO;

@Mapper
public interface VueloMapper {

    VueloMapper INSTANCE = Mappers.getMapper(VueloMapper.class);

    // VUELO  -> VUELO DTO
    @Mapping(source = "id_vuelo", target = "id")
    default
    VueloDTO vueloToVueloDTO(Vuelo vuelo){
        if(vuelo == null){
            return null;
        }

        VueloDTO vueloDto = new VueloDTO();
        vueloDto.setId_vuelo(vuelo.getId());
        vueloDto.setOrigen(vuelo.getOrigen());
        vueloDto.setDestino(vuelo.getDestino());
        vueloDto.setFecha_salida(vuelo.getFecha_salida());
        vueloDto.setHora_salida(vuelo.getHora_salida());
        vueloDto.setPrecio(vuelo.getPrecio());
        vueloDto.setCapacidad(vuelo.getCapacidad());
        vueloDto.setAerolinea(AerolineaMapper.INSTANCE.aerolineaToAerolineaDTO(vuelo.getAerolinea()));
        vueloDto.setAeropuertoSalida(AeropuertoMapper.INSTANCE.aeropuertoToAeropuertoDTO(vuelo.getAeropuertoSalida()));
        vueloDto.setAeropuertoLlegada(AeropuertoMapper.INSTANCE.aeropuertoToAeropuertoDTO(vuelo.getAeropuertoLlegada()));

        return vueloDto;
    }

    // VUELO DTO -> VUELO 
    @Mapping(source = "id", target = "id_vuelo")
        default
        Vuelo vueloDTOToVuelo(VueloDTO vueloDto){
            if(vueloDto == null){
                return null;                
            }
    
            Vuelo vuelo = new Vuelo();
            vuelo.setId(vueloDto.getId_vuelo());
            vuelo.setOrigen(vueloDto.getOrigen());
            vuelo.setDestino(vueloDto.getDestino());
            vuelo.setFecha_salida(vueloDto.getFecha_salida());
            vuelo.setHora_salida(vueloDto.getHora_salida());
            vuelo.setPrecio(vueloDto.getPrecio());
            vuelo.setDuracion(vueloDto.getDuracion());
            vuelo.setCapacidad(vueloDto.getCapacidad());
            vuelo.setAerolinea(AerolineaMapper.INSTANCE.aerolineaDTOToAerolinea(vueloDto.getAerolinea()));
            vuelo.setAeropuertoSalida(AeropuertoMapper.INSTANCE.aeropuertoDTOToAeropuerto(vueloDto.getAeropuertoSalida()));
            vuelo.setAeropuertoLlegada(AeropuertoMapper.INSTANCE.aeropuertoDTOToAeropuerto(vueloDto.getAeropuertoLlegada()));

            return vuelo;
    }
}
