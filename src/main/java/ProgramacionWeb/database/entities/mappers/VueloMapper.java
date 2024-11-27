package ProgramacionWeb.database.entities.mappers;

import java.util.ArrayList;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Aerolinea;
import ProgramacionWeb.database.entities.Aeropuerto;
import ProgramacionWeb.database.entities.Reserva;
import ProgramacionWeb.database.entities.Vuelo;
import ProgramacionWeb.database.entities.dto.AerolineaDTO;
import ProgramacionWeb.database.entities.dto.AeropuertoDTO;
import ProgramacionWeb.database.entities.dto.ReservaDTO;
import ProgramacionWeb.database.entities.dto.VueloDTO;
import ProgramacionWeb.database.entities.tosavedto.VueloToSDTO;

@Mapper
public interface VueloMapper {

    VueloMapper INSTANCE = Mappers.getMapper(VueloMapper.class);

    // VUELO -> VUELODTO  (para recuperar datos de la base de datos)
    default VueloDTO vueloToVueloDTO(Vuelo vuelo) {
        if (vuelo == null) {
            return null;
        }
        VueloDTO vueloDTO = new VueloDTO();
        vueloDTO.setId_vuelo(vuelo.getId());
        vueloDTO.setOrigen(vuelo.getOrigen());
        vueloDTO.setDestino(vuelo.getDestino());
        vueloDTO.setFecha_salida(vuelo.getFecha_salida());
        vueloDTO.setHora_salida(vuelo.getHora_salida());
        vueloDTO.setPrecio(vuelo.getPrecio());
        vueloDTO.setDuracion(vuelo.getDuracion());
        vueloDTO.setCapacidad(vuelo.getCapacidad());
        if(vuelo.getAerolinea() != null) {
            AerolineaDTO aerolineaDTO = new AerolineaDTO();
            aerolineaDTO.setId_aerolinea(vuelo.getAerolinea().getId());
            aerolineaDTO.setNombre(vuelo.getAerolinea().getNombre());
            aerolineaDTO.setCodigo_arolinea(vuelo.getAerolinea().getCodigo_arolinea());
            aerolineaDTO.setPais(vuelo.getAerolinea().getPais());
            vueloDTO.setAerolinea(aerolineaDTO);
        }else{
            vueloDTO.setAerolinea(null);
        }
        if(vuelo.getAeropuertoSalida() != null) {
            AeropuertoDTO aeropuertoDTO = new AeropuertoDTO();
            aeropuertoDTO.setId_aeropuerto(vuelo.getAeropuertoSalida().getId());
            aeropuertoDTO.setNombre(vuelo.getAeropuertoSalida().getNombre());
            aeropuertoDTO.setCiudad(vuelo.getAeropuertoSalida().getCiudad());
            aeropuertoDTO.setPais(vuelo.getAeropuertoSalida().getPais());
            vueloDTO.setAeropuertoSalida(aeropuertoDTO);
        }else{
            vueloDTO.setAeropuertoSalida(null);
        }
        if(vuelo.getAeropuertoLlegada() != null) {
            AeropuertoDTO aeropuertoDTO = new AeropuertoDTO();
            aeropuertoDTO.setId_aeropuerto(vuelo.getAeropuertoLlegada().getId());
            aeropuertoDTO.setNombre(vuelo.getAeropuertoLlegada().getNombre());
            aeropuertoDTO.setCiudad(vuelo.getAeropuertoLlegada().getCiudad());
            aeropuertoDTO.setPais(vuelo.getAeropuertoLlegada().getPais());
            vueloDTO.setAeropuertoLlegada(aeropuertoDTO);
        }else{
            vueloDTO.setAeropuertoLlegada(null);
        }
        if(vuelo.getReservas() != null) {
            for (Reserva reserva : vuelo.getReservas()) {
                ReservaDTO reservaDTO = new ReservaDTO();
                reservaDTO.setId_reserva(reserva.getId());
                reservaDTO.setFecha(reserva.getFecha());
                reservaDTO.setNum_pasajeros(reserva.getNum_pasajeros());
                vueloDTO.getReservas().add(reservaDTO);
            }
        }else{
            vueloDTO.setReservas(new ArrayList<>());
        }
        return vueloDTO;
    }

    //VueloToSDTO -> Vuelo
    default
    public Vuelo VueloToSDTOToVuelo(VueloToSDTO vueloToSave){
        if(vueloToSave == null){
            return null;
        }
        Vuelo vuelo = new Vuelo();
        vuelo.setOrigen(vueloToSave.getOrigen());
        vuelo.setDestino(vueloToSave.getDestino());
        vuelo.setFecha_salida(vueloToSave.getFecha_salida());
        vuelo.setHora_salida(vueloToSave.getHora_salida());
        vuelo.setPrecio(vueloToSave.getPrecio());
        vuelo.setDuracion(vueloToSave.getDuracion());
        vuelo.setCapacidad(vueloToSave.getCapacidad());
        if(vueloToSave.getAerolinea() != null) {
            Aerolinea aerolinea = new Aerolinea();
            aerolinea.setNombre(vueloToSave.getAerolinea().getNombre());
            aerolinea.setCodigo_arolinea(vueloToSave.getAerolinea().getCodigo_arolinea());
            aerolinea.setPais(vueloToSave.getAerolinea().getPais());
            vuelo.setAerolinea(aerolinea);
        }else{
            vuelo.setAerolinea(null);
        }
        if(vueloToSave.getAeropuerto_salida() != null) {
            Aeropuerto aeropuerto = new Aeropuerto();
            aeropuerto.setNombre(vueloToSave.getAeropuerto_salida().getNombre());
            aeropuerto.setCiudad(vueloToSave.getAeropuerto_salida().getCiudad());
            aeropuerto.setPais(vueloToSave.getAeropuerto_salida().getPais());
            vuelo.setAeropuertoSalida(aeropuerto);
        }else{
            vuelo.setAeropuertoSalida(null);
        }
        if(vueloToSave.getAeropuerto_salida() != null) {
            Aeropuerto aeropuerto = new Aeropuerto();
            aeropuerto.setNombre(vueloToSave.getAeropuerto_salida().getNombre());
            aeropuerto.setCiudad(vueloToSave.getAeropuerto_salida().getCiudad());
            aeropuerto.setPais(vueloToSave.getAeropuerto_salida().getPais());
            vuelo.setAeropuertoLlegada(aeropuerto);
        }else{
            vuelo.setAeropuertoLlegada(null);
        }
        return vuelo;
    }
}
