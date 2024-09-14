package ProgramacionWeb.database.Services;

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
    public Iterable<Aeropuerto> findAll() {
        return aeropuertoRepository.findAll();
    }

    //save
    public void save(Aeropuerto aeropuerto) {
        aeropuertoRepository.save(aeropuerto);
    }

    //delete
    public void delete(Aeropuerto aeropuerto) { 
        aeropuertoRepository.delete(aeropuerto);
    }

    //delete by id
    public void deleteById(long id) {
        aeropuertoRepository.deleteById(id);
    }
}
