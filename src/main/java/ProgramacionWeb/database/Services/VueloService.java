package ProgramacionWeb.database.Services;

import java.util.List;

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
    public List<Vuelo> findAll() {
        return vueloRepository.findAll();
    }

    //save
    public Vuelo save(Vuelo vuelo) { 
        return vueloRepository.save(vuelo);
    }


    //delete by id
    public Boolean deleteById(long id) {
        if(vueloRepository.findById(id) == null){
            return false;
        }
        vueloRepository.deleteById(id);
        return true;
    }
}
