package ProgramacionWeb.database.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProgramacionWeb.database.entities.Aeropuerto;
import ProgramacionWeb.database.repositories.AeropuertoRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class AeropuertoService{

    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    //get by id
    public Aeropuerto findById(long id) {
        return aeropuertoRepository.findById(id);
    }

    //get all
    public List<Aeropuerto> findAll() {
        return aeropuertoRepository.findAll();
    }

    //save
    public Aeropuerto save(Aeropuerto aeropuerto) {
        return aeropuertoRepository.save(aeropuerto);
    }


    //delete by id
    public Boolean deleteById(long id) {
        if( aeropuertoRepository.findById(id) == null){
            return false;
        }
        aeropuertoRepository.deleteById(id);
        return true;
    }
}
