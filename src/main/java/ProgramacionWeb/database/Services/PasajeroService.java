package ProgramacionWeb.database.Services;

import java.util.List;
import java.util.Optional;

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
    public Optional<Pasajero> findById(long id) {
        return pasajeroRepository.findById(id);
    }

    //get all
    public List<Pasajero> findAll() {
        return pasajeroRepository.findAll();
    }

    //save
    public Pasajero save(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }

    //delete by id
    public Boolean deleteById(long id) {
        if (pasajeroRepository.findById(id) == null) {
            return false;
        }
        pasajeroRepository.deleteById(id);
        return true;
    }
}
