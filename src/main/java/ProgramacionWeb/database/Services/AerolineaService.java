package ProgramacionWeb.database.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProgramacionWeb.database.entities.Aerolinea;
import ProgramacionWeb.database.repositories.AerolineaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class AerolineaService {

    @Autowired
    private AerolineaRepository aerolineaRepository;

    //get by id
    public Aerolinea findById(long id) {
        return aerolineaRepository.findById(id);
    }

    //get all
    public List<Aerolinea> findAll() {
        return aerolineaRepository.findAll();
    }

    //save
    public Aerolinea save(Aerolinea aerolinea) {
        return aerolineaRepository.save(aerolinea);
    }

    //delete by id
    public Boolean deleteById(long id) {
        
        if (aerolineaRepository.findById(id) == null) {
            return false;
        }
        aerolineaRepository.deleteById(id);
        return true;
    }
    
    
}
