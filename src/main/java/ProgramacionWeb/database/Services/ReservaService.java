package ProgramacionWeb.database.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProgramacionWeb.database.entities.Reserva;
import ProgramacionWeb.database.entities.dto.ReservaDTO;
import ProgramacionWeb.database.entities.mappers.ReservaMapper;
import ProgramacionWeb.database.entities.tosavedto.ReservaToSDTO;
import ProgramacionWeb.database.repositories.ReservaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class ReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    // get by id
    public ReservaDTO findById(Long id) {
        if (id == null) {
            return null;
        }
        Reserva reserva = reservaRepository.findById(id).get();
        return ReservaMapper.INSTANCE.reservaToReservaDTO(reserva);
    }

    // get all
    public List<ReservaDTO> findAll() {
        List<Reserva> reservas = reservaRepository.findAll();
        if (reservas.isEmpty()) {
            return null;
        }
        List<ReservaDTO> reservasDTO = new ArrayList<>();
        for (Reserva reserva : reservas) {
            reservasDTO.add(ReservaMapper.INSTANCE.reservaToReservaDTO(reserva));
        }
        return reservasDTO;
    }

    // save
    public ReservaDTO save(ReservaToSDTO reserva) {
        if (reserva == null) {
            return null;
        }
        Reserva reservaSaved = reservaRepository
                .save(ReservaMapper.INSTANCE.reservaToReserva(reserva));
        return ReservaMapper.INSTANCE.reservaToReservaDTO(reservaSaved);
    }

    // delete by id
    public Boolean deleteById(Long id) {
        if (id == null) {
            return false;
        }
        reservaRepository.deleteById(id);
        return true;
    }

    // find by id cliente
    public List<ReservaDTO> findByClienteId(Long id) {
        List<Reserva> reservas = reservaRepository.findByClienteId(id);
        List<ReservaDTO> reservasDTO = new ArrayList<>();
        for (Reserva reserva : reservas) {
            reservasDTO.add(ReservaMapper.INSTANCE.reservaToReservaDTO(reserva));
        }
        return reservasDTO;
    }

    //convert to dto
    public ReservaDTO convertToDTO(Reserva reserva) {
        if (reserva == null) {
            return null;
        }
        return ReservaMapper.INSTANCE.reservaToReservaDTO(reserva);
    }

    //convert to entity
    public Reserva convertToEntity(ReservaToSDTO reserva) {
        if (reserva == null) {
            return null;
        }
        return ReservaMapper.INSTANCE.reservaToReserva(reserva);
    }
}
