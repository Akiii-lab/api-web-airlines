package ProgramacionWeb.database.entities.mappers;

import java.util.ArrayList;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Aerolinea;
import ProgramacionWeb.database.entities.Reserva;
import ProgramacionWeb.database.entities.Vuelo;
import ProgramacionWeb.database.entities.dto.AerolineaDTO;
import ProgramacionWeb.database.entities.dto.AeropuertoDTO;
import ProgramacionWeb.database.entities.dto.ReservaDTO;
import ProgramacionWeb.database.entities.dto.VueloDTO;
import ProgramacionWeb.database.repositories.AerolineaRepository;

@Mapper
public interface VueloMapper {

    VueloMapper INSTANCE = Mappers.getMapper(VueloMapper.class);

    // VUELO -> VUELO DTO
    default VueloDTO vueloToVueloDTO(Vuelo vuelo) {
        if (vuelo == null) {
            return null;
        }

        VueloDTO vueloDto = new VueloDTO();
        vueloDto.setId_vuelo(vuelo.getId());
        vueloDto.setOrigen(vuelo.getOrigen());
        vueloDto.setDestino(vuelo.getDestino());
        vueloDto.setFecha_salida(vuelo.getFecha_salida());
        vueloDto.setHora_salida(vuelo.getHora_salida());
        vueloDto.setPrecio(vuelo.getPrecio());
        vueloDto.setDuracion(vuelo.getDuracion());
        vueloDto.setCapacidad(vuelo.getCapacidad());
        if (vuelo.getAerolinea() != null) {
            AerolineaDTO aerolineaDTO = new AerolineaDTO();
            aerolineaDTO.setId_aerolinea(vuelo.getAerolinea().getId());
            aerolineaDTO.setNombre(vuelo.getAerolinea().getNombre());
            aerolineaDTO.setCodigo_arolinea(vuelo.getAerolinea().getCodigo_arolinea());
            aerolineaDTO.setPais(vuelo.getAerolinea().getPais());
            vueloDto.setAerolinea(aerolineaDTO);
        } else {
            vueloDto.setAerolinea(null);
        }

        if (vuelo.getAeropuertoSalida() != null) {
            AeropuertoDTO aeropuertoDTO = new AeropuertoDTO();
            aeropuertoDTO.setId_aeropuerto(vuelo.getAeropuertoSalida().getId());
            aeropuertoDTO.setNombre(vuelo.getAeropuertoSalida().getNombre());
            aeropuertoDTO.setCiudad(vuelo.getAeropuertoSalida().getCiudad());
            aeropuertoDTO.setPais(vuelo.getAeropuertoSalida().getPais());
            vueloDto.setAeropuertoSalida(aeropuertoDTO);
        } else {
            vueloDto.setAeropuertoSalida(null);
        }
        if (vuelo.getAeropuertoLlegada() != null) {
            AeropuertoDTO aeropuertoDTO = new AeropuertoDTO();
            aeropuertoDTO.setId_aeropuerto(vuelo.getAeropuertoLlegada().getId());
            aeropuertoDTO.setNombre(vuelo.getAeropuertoLlegada().getNombre());
            aeropuertoDTO.setCiudad(vuelo.getAeropuertoLlegada().getCiudad());
            aeropuertoDTO.setPais(vuelo.getAeropuertoLlegada().getPais());
            vueloDto.setAeropuertoLlegada(aeropuertoDTO);
        } else {
            vueloDto.setAeropuertoLlegada(null);
        }
        if (vuelo.getReservas() != null && !vuelo.getReservas().isEmpty()) {
            if (vueloDto.getReservas() == null) {
                vueloDto.setReservas(new ArrayList<>());
            }
            for (Reserva reserva : vuelo.getReservas()) {
                ReservaDTO reservaDTO = new ReservaDTO();
                reservaDTO.setId_reserva(reserva.getId());
                reservaDTO.setFecha(reserva.getFecha());
                reservaDTO.setNum_pasajeros(reserva.getNum_pasajeros());
                vueloDto.getReservas().add(reservaDTO);
            }
        } else {
            vueloDto.setReservas(new ArrayList<>());
        }
        return vueloDto;
    }

    // VUELO DTO -> VUELO
    default Vuelo vueloDTOToVuelo(VueloDTO vueloDto, AerolineaRepository repository) {
        if (vueloDto == null) {
            return null;
        }

        Vuelo vuelo = new Vuelo();
        vuelo.setId(vueloDto.getId_vuelo());
        vuelo.setOrigen(vueloDto.getOrigen());
        vuelo.setDestino(vueloDto.getDestino());
        vuelo.setFecha_salida(vueloDto.getFecha_salida());
        vuelo.setHora_salida(vueloDto.getHora_salida());
        vuelo.setPrecio(vueloDto.getPrecio());
        vuelo.setDuracion(vueloDto.getDuracion());
        vuelo.setCapacidad(vueloDto.getCapacidad());
        if (vueloDto.getAerolinea() != null) {
            Aerolinea temp = AerolineaMapper.INSTANCE.aerolineaDTOToAerolinea(vueloDto.getAerolinea(), repository);
            // verfy existence
            if (temp.getId() == null) {
                temp = repository.save(temp);
            }
            vuelo.setAerolinea(temp);
        } else {
            vuelo.setAerolinea(null);
        }
        if (vueloDto.getAeropuertoSalida() != null) {
            vuelo.setAeropuertoSalida(
                    AeropuertoMapper.INSTANCE.aeropuertoDTOToAeropuerto(vueloDto.getAeropuertoSalida(), repository));
        } else {
            vuelo.setAeropuertoSalida(null);
        }
        if (vueloDto.getAeropuertoLlegada() != null) {
            vuelo.setAeropuertoLlegada(
                    AeropuertoMapper.INSTANCE.aeropuertoDTOToAeropuerto(vueloDto.getAeropuertoLlegada(), repository));
        } else {
            vuelo.setAeropuertoLlegada(null);
        }
        if (vueloDto.getReservas() != null && !vueloDto.getReservas().isEmpty()) {
            if (vuelo.getReservas() == null) {
                vuelo.setReservas(new ArrayList<>());
            }
            for (ReservaDTO reserva : vueloDto.getReservas()) {
                vuelo.getReservas().add(ReservaMapper.INSTANCE.reservaDTOToReserva(reserva, repository));
            }
        } else {
            vuelo.setReservas(new ArrayList<>());
        }
        return vuelo;
    }
}
