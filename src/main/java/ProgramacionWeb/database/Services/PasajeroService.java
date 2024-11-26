package ProgramacionWeb.database.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProgramacionWeb.database.entities.Pasajero;
import ProgramacionWeb.database.entities.dto.PasajeroDTO;
import ProgramacionWeb.database.entities.mappers.PasajeroMapper;
import ProgramacionWeb.database.repositories.AerolineaRepository;
import ProgramacionWeb.database.repositories.PasajeroRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class PasajeroService {

    @Autowired
    private PasajeroRepository pasajeroRepository;

    @Autowired
    private AerolineaRepository aerolineaRepository;

    //get by id
    public PasajeroDTO findById(Long id) {
        if(id == null) {
            return null;            
        }

        Pasajero pasajero = pasajeroRepository.findById(id).get();
        return PasajeroMapper.INSTANCE.pasajeroToPasajeroDTO(pasajero);
    }

    //get all
    public List<PasajeroDTO> findAll() {
        List<PasajeroDTO> pasajeros = new ArrayList<>(); 
        for( Pasajero pasajero : pasajeroRepository.findAll()){
            pasajeros.add(PasajeroMapper.INSTANCE.pasajeroToPasajeroDTO(pasajero));
        }
        return pasajeros;
    }

    //save
    public PasajeroDTO save(PasajeroDTO pasajero) {
        if(pasajero == null) {
            return null;
        }
        Pasajero pasajeroSaved = pasajeroRepository.save(PasajeroMapper.INSTANCE.pasajeroDTOToPasajero(pasajero, aerolineaRepository));
        return PasajeroMapper.INSTANCE.pasajeroToPasajeroDTO(pasajeroSaved);
    }

    //delete by id
    public Boolean deleteById(Long id) {
        if(id == null) {
            return false;
        }
        pasajeroRepository.deleteById(id);
        return true;
    }
}
