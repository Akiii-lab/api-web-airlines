package ProgramacionWeb.database.entities.mappers;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Aerolinea;
import ProgramacionWeb.database.entities.Vuelo;
import ProgramacionWeb.database.entities.dto.AerolineaDTO;
import ProgramacionWeb.database.entities.dto.VueloDTO;

@Mapper 
public interface AerolineaMapper {

    AerolineaMapper INSTANCE = Mappers.getMapper(AerolineaMapper.class);

    @Mapping(source = "id", target = "id_aerolinea")
    default
    AerolineaDTO aerolineaToAerolineaDTO(Aerolinea aerolinea){
        if(aerolinea == null){
            return null;
        }

        AerolineaDTO aerolineaDTO = new AerolineaDTO();
        aerolineaDTO.setId_aerolinea(aerolinea.getId());
        aerolineaDTO.setNombre(aerolinea.getNombre());
        aerolineaDTO.setCodigo_arolinea(aerolinea.getCodigo_arolinea());
        aerolineaDTO.setPais(aerolinea.getPais());
        if(aerolinea.getVuelos() != null){
            for(Vuelo vuelo : aerolinea.getVuelos()){
                aerolineaDTO.getVuelos().add(VueloMapper.INSTANCE.vueloToVueloDTO(vuelo));
            }
        }else{
            aerolineaDTO.setVuelos(List.of());
        }
        return aerolineaDTO;
    }
    
    @Mapping(source = "id_aerolinea", target = "id")
    default
    Aerolinea aerolineaDTOToAerolinea(AerolineaDTO aerolineaDTO){
        if(aerolineaDTO == null){
            return null;
        }

        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setId(aerolineaDTO.getId_aerolinea());
        aerolinea.setNombre(aerolineaDTO.getNombre());
        aerolinea.setCodigo_arolinea(aerolineaDTO.getCodigo_arolinea());
        aerolinea.setPais(aerolineaDTO.getPais());
        if(aerolinea.getVuelos() != null){
            for(VueloDTO vueloDTO : aerolineaDTO.getVuelos()){
                aerolinea.getVuelos().add(VueloMapper.INSTANCE.vueloDTOToVuelo(vueloDTO));
            }
        }
        else{
            aerolinea.setVuelos(List.of());
        }
        return aerolinea;
    }
}
