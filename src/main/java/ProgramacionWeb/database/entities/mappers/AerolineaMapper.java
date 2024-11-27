package ProgramacionWeb.database.entities.mappers;


import java.util.ArrayList;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Aerolinea;
import ProgramacionWeb.database.entities.Vuelo;
import ProgramacionWeb.database.entities.dto.AerolineaDTO;
import ProgramacionWeb.database.entities.tosavedto.AerolineaToSDTO;

@Mapper 
public interface AerolineaMapper {

    AerolineaMapper INSTANCE = Mappers.getMapper(AerolineaMapper.class);

    default
    AerolineaDTO aerolineaToAerolineaDTO(Aerolinea aerolinea) {
        if(aerolinea == null){
            return null;
        }
        AerolineaDTO aerolineaDTO = new AerolineaDTO();
        aerolineaDTO.setId_aerolinea(aerolinea.getId());
        aerolineaDTO.setNombre(aerolinea.getNombre());
        aerolineaDTO.setCodigo_arolinea(aerolinea.getCodigo_arolinea());
        aerolineaDTO.setPais(aerolinea.getPais());
        if(aerolinea.getVuelos() != null){
            if(aerolineaDTO.getVuelos() == null) {
                aerolineaDTO.setVuelos(new ArrayList<>());
            }
            for(Vuelo vuelo : aerolinea.getVuelos())
                aerolineaDTO.getVuelos().add(VueloMapper.INSTANCE.vueloToVueloDTO(vuelo));
        }
        return aerolineaDTO;
    }

    //AerolineaToSDTO -> Aerolinea
    default
    Aerolinea aerolineaToSDTOToAerolinea(AerolineaToSDTO aerolineaToSave) {
        if(aerolineaToSave == null){
            return null;
        }
        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setNombre(aerolineaToSave.getNombre());
        aerolinea.setCodigo_arolinea(aerolineaToSave.getCodigo_arolinea());
        aerolinea.setPais(aerolineaToSave.getPais());
        aerolinea.setVuelos(new ArrayList<>());
        return aerolinea;
    }
}
