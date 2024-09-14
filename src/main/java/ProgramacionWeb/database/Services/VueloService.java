package ProgramacionWeb.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProgramacionWeb.database.entities.Vuelo;
import ProgramacionWeb.database.repositories.VueloRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    //get by id
    public Vuelo findById(long id) {
        return vueloRepository.findById(id);
    }

    //get all
    public Iterable<Vuelo> findAll() {
        return vueloRepository.findAll();
    }

    //save
    public void save(Vuelo vuelo) { 
        vueloRepository.save(vuelo);
    }

    //delete
    public void delete(Vuelo vuelo) {
        vueloRepository.delete(vuelo);
    }

    //delete by id
    public void deleteById(long id) {
        vueloRepository.deleteById(id);
    }
}
