package ProgramacionWeb.database.Services;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

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
    public Optional<Reserva> findById(long id) {
        return reservaRepository.findById(id);
    }

    //get all
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    //save
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    //delete by id
    public Boolean deleteById(long id) {
        if (reservaRepository.findById(id) == null) {
            return false;
        }
        reservaRepository.deleteById(id);
        return true;
    }

    //find by id cliente
    public List<Reserva> findByClienteId(Long id) {
        return reservaRepository.findByClienteId(id);
    }
}
