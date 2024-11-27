package ProgramacionWeb.database.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProgramacionWeb.database.entities.Vuelo;
import ProgramacionWeb.database.entities.dto.VueloDTO;
import ProgramacionWeb.database.entities.mappers.VueloMapper;
import ProgramacionWeb.database.entities.tosavedto.VueloToSDTO;
import ProgramacionWeb.database.repositories.VueloRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class VueloService {

    @Autowired
    private VueloRepository vueloRepository;

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
    public VueloDTO save(VueloToSDTO vuelo) { 
        if(vuelo == null) {
            return null;
        }
        Vuelo vuelotoSave = VueloMapper.INSTANCE.VueloToSDTOToVuelo(vuelo);
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

    //convert to dto
    public VueloDTO convertToDTO(Vuelo vuelo) {
        if(vuelo == null) {
            return null;
        }
        return VueloMapper.INSTANCE.vueloToVueloDTO(vuelo);
    }

    //convert to entity
    public Vuelo convertToEntity(VueloToSDTO vuelo) {
        if(vuelo == null) {
            return null;
        }
        return VueloMapper.INSTANCE.VueloToSDTOToVuelo(vuelo);
    }
}
