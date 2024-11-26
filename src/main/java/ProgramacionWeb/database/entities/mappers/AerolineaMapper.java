package ProgramacionWeb.database.entities.mappers;


import java.util.ArrayList;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Aerolinea;
import ProgramacionWeb.database.entities.Vuelo;
import ProgramacionWeb.database.entities.dto.AerolineaDTO;
import ProgramacionWeb.database.entities.dto.VueloDTO;
import ProgramacionWeb.database.repositories.AerolineaRepository;

@Mapper 
public interface AerolineaMapper {

    AerolineaMapper INSTANCE = Mappers.getMapper(AerolineaMapper.class);

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
        if(aerolinea.getVuelos() != null && !aerolinea.getVuelos().isEmpty()){
            if(aerolineaDTO.getVuelos() == null) {
                aerolineaDTO.setVuelos(new ArrayList<>());
            }
            for(Vuelo vuelo : aerolinea.getVuelos()){
                aerolineaDTO.getVuelos().add(VueloMapper.INSTANCE.vueloToVueloDTO(vuelo));
            }
        }else{
            aerolineaDTO.setVuelos(new ArrayList<>());
        }
        return aerolineaDTO;
    }
    
    default
    Aerolinea aerolineaDTOToAerolinea(AerolineaDTO aerolineaDTO, AerolineaRepository repository){
        if(aerolineaDTO == null){
            return null;
        }

        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setId(aerolineaDTO.getId_aerolinea());
        aerolinea.setNombre(aerolineaDTO.getNombre());
        aerolinea.setCodigo_arolinea(aerolineaDTO.getCodigo_arolinea());
        aerolinea.setPais(aerolineaDTO.getPais());
        if(aerolinea.getVuelos() != null){
            if(aerolineaDTO.getVuelos() == null) {
                aerolineaDTO.setVuelos(new ArrayList<>());
            }
            for(VueloDTO vueloDTO : aerolineaDTO.getVuelos()){
                aerolinea.getVuelos().add(VueloMapper.INSTANCE.vueloDTOToVuelo(vueloDTO, repository));
            }
        }
        else{
            aerolinea.setVuelos(new ArrayList<>());
        }
        return aerolinea;
    }
}
