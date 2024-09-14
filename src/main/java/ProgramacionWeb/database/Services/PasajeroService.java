package ProgramacionWeb.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProgramacionWeb.database.entities.Pasajero;
import ProgramacionWeb.database.repositories.PasajeroRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class PasajeroService {

    @Autowired
    private PasajeroRepository pasajeroRepository;

    //get by id
    public Pasajero findById(long id) {
        return pasajeroRepository.findById(id);
    }

    //get all
    public Iterable<Pasajero> findAll() {
        return pasajeroRepository.findAll();
    }

    //save
    public void save(Pasajero pasajero) {
        pasajeroRepository.save(pasajero);
    }

    //delete    
    public void delete(Pasajero pasajero) {
        pasajeroRepository.delete(pasajero);
    }

    //delete by id
    public void deleteById(long id) {
        pasajeroRepository.deleteById(id);
    }
}
