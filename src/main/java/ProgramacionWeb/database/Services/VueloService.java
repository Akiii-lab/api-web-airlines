package ProgramacionWeb.database.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProgramacionWeb.database.entities.Vuelo;
import ProgramacionWeb.database.entities.dto.VueloDTO;
import ProgramacionWeb.database.entities.mappers.VueloMapper;
import ProgramacionWeb.database.repositories.AerolineaRepository;
import ProgramacionWeb.database.repositories.VueloRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    private AerolineaRepository aerolineaRepository;

    //get by id
    public VueloDTO findById(Long id) {
        if(id == null) {
            return null;
        }
        Vuelo vuelo = vueloRepository.findById(id).get();
        return VueloMapper.INSTANCE.vueloToVueloDTO(vuelo);
    }

    //get all
    public List<VueloDTO> findAll() {
        List<Vuelo> vuelos = vueloRepository.findAll();
        return vuelos.stream().map(vuelo -> VueloMapper.INSTANCE.vueloToVueloDTO(vuelo)).toList();
    }

    //save
    public VueloDTO save(VueloDTO vuelo) { 
        if(vuelo == null) {
            return null;
        }
        Vuelo vuelotoSave = VueloMapper.INSTANCE.vueloDTOToVuelo(vuelo, aerolineaRepository);
        if(vuelotoSave == null) {
            return null;
        }
        Vuelo vueloSaved = vueloRepository.save(vuelotoSave);
        VueloDTO vueloDto = VueloMapper.INSTANCE.vueloToVueloDTO(vueloSaved);
        return vueloDto;
    }


    //delete by id
    public Boolean deleteById(Long id) {
        if(id == null) {
            return false;
        }
        vueloRepository.deleteById(id);
        return true;
    }
}
