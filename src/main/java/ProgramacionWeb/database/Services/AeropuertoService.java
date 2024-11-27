package ProgramacionWeb.database.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProgramacionWeb.database.entities.Aeropuerto;
import ProgramacionWeb.database.entities.dto.AeropuertoDTO;
import ProgramacionWeb.database.entities.mappers.AeropuertoMapper;
import ProgramacionWeb.database.entities.tosavedto.AeropuerToSDTO;
import ProgramacionWeb.database.repositories.AeropuertoRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class AeropuertoService{

    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    //get by id
    public AeropuertoDTO findById(Long id) {
        if(id == null){
            return null;
        }
        Aeropuerto aeropuerto = aeropuertoRepository.findById(id).get();
        return AeropuertoMapper.INSTANCE.aeropuertoToAeropuertoDTO(aeropuerto);
    }

    //get all
    public List<AeropuertoDTO> findAll() {
        List<AeropuertoDTO> aeropuertosDTO = new ArrayList<>();
        for(Aeropuerto aeropuerto : aeropuertoRepository.findAll()) {
            aeropuertosDTO.add(AeropuertoMapper.INSTANCE.aeropuertoToAeropuertoDTO(aeropuerto));
        }
        return aeropuertosDTO;
    }

    //save
    public AeropuertoDTO save(AeropuerToSDTO aeropuerto) {
        if(aeropuerto == null){
            return null;
        }
        Aeropuerto savedAeropuerto = aeropuertoRepository.save(AeropuertoMapper.INSTANCE.aeropuertoToAeropuerto(aeropuerto));
        return AeropuertoMapper.INSTANCE.aeropuertoToAeropuertoDTO(savedAeropuerto);
    }


    //delete by id
    public Boolean deleteById(Long id) {
        if( id == null){
            return false;
        }
        aeropuertoRepository.deleteById(id);
        return true;
    }

    //conver to dto
    public AeropuertoDTO convertToDTO(Aeropuerto aeropuerto) {
        return AeropuertoMapper.INSTANCE.aeropuertoToAeropuertoDTO(aeropuerto);
    }

    //conver SaveDTO to entity
    public Aeropuerto convertToEntity(AeropuerToSDTO aeropuertoDTO) {
        return AeropuertoMapper.INSTANCE.aeropuertoToAeropuerto(aeropuertoDTO);
    }
}
