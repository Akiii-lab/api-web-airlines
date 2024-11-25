package ProgramacionWeb.database.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProgramacionWeb.database.entities.Aerolinea;
import ProgramacionWeb.database.entities.dto.AerolineaDTO;
import ProgramacionWeb.database.entities.mappers.AerolineaMapper;
import ProgramacionWeb.database.repositories.AerolineaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class AerolineaService {

    @Autowired
    private AerolineaRepository aerolineaRepository;

    //get by id
    public AerolineaDTO findById(Long id) {
        if(id == null){
            return null;
        }

        Aerolinea aerolinea = aerolineaRepository.findById(id).get();
        return AerolineaMapper.INSTANCE.aerolineaToAerolineaDTO(aerolinea);
    }

    //get all
    public List<AerolineaDTO> findAll() {
        List<AerolineaDTO> aerolineas = new ArrayList<>();
        for (Aerolinea aerolinea : aerolineaRepository.findAll()) {
            aerolineas.add(AerolineaMapper.INSTANCE.aerolineaToAerolineaDTO(aerolinea));
        }
        return aerolineas;
    }

    //save
    public AerolineaDTO save(AerolineaDTO aerolinea) {
        if(aerolinea == null){
            return null;
        }

        Aerolinea savedAerolinea = aerolineaRepository.save(AerolineaMapper.INSTANCE.aerolineaDTOToAerolinea(aerolinea));

        return AerolineaMapper.INSTANCE.aerolineaToAerolineaDTO(savedAerolinea);
    }

    //delete by id
    public Boolean deleteById(Long id) {
        
        if (id == null) {
            return false;
        }
        aerolineaRepository.deleteById(id);
        return true;
    }
    
    
}
