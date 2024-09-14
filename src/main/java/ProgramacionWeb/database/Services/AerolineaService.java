package ProgramacionWeb.database.Services;

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
    public Iterable<Aerolinea> findAll() {
        return aerolineaRepository.findAll();
    }

    //save
    public void save(Aerolinea aerolinea) {
        aerolineaRepository.save(aerolinea);
    }

    //delete
    public void delete(Aerolinea aerolinea) {
        aerolineaRepository.delete(aerolinea);
    }

    //delete by id
    public void deleteById(long id) {
        aerolineaRepository.deleteById(id);
    }
    
    
}
