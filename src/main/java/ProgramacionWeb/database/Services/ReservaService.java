package ProgramacionWeb.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProgramacionWeb.database.entities.Reserva;
import ProgramacionWeb.database.repositories.ReservaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class ReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    //get by id
    public Reserva findById(long id) {
        return reservaRepository.findById(id);
    }

    //get all
    public Iterable<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    //save
    public void save(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    //delete
    public void delete(Reserva reserva) {
        reservaRepository.delete(reserva);
    }

    //delete by id
    public void deleteById(long id) {
        reservaRepository.deleteById(id);
    }
}
