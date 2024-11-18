package ProgramacionWeb.database.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Cliente;
import ProgramacionWeb.database.entities.Pasajero;
import ProgramacionWeb.database.entities.Reserva;
import ProgramacionWeb.database.entities.Vuelo;
import ProgramacionWeb.database.entities.dto.PasajeroDTO;
import ProgramacionWeb.database.entities.dto.ReservaDTO;
import ProgramacionWeb.database.entities.dto.VueloDTO;
import ProgramacionWeb.database.repositories.ClienteRepository;
import ProgramacionWeb.database.repositories.PasajeroRepository;
import ProgramacionWeb.database.repositories.ReservaRepository;
import ProgramacionWeb.database.repositories.VueloRepository;

@Mapper
public interface ReservaMapper {

    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    // RESERVA DTO -> RESERVA
    @Mapping(source = "id", target = "id_reserva")
        default
        ReservaDTO reservaToReservaDTO(Reserva reserva){
            if(reserva == null){
                return null;
            }
            ReservaDTO reservaDTO = new ReservaDTO();
            reservaDTO.setId_reserva(reserva.getId());
            reservaDTO.setFecha(reserva.getFecha());
            reservaDTO.setNum_pasajeros(reserva.getNum_pasajeros());
            for(Pasajero pasajero : reserva.getPasajeros()){
                reservaDTO.getPasajeros().add(PasajeroMapper.INSTANCE.pasajeroToPasajeroDTO(pasajero));
            }
            for(Vuelo vuelo : reserva.getVuelos()){
                reservaDTO.getVuelos().add(VueloMapper.INSTANCE.vueloToVueloDTO(vuelo));
            }
            reservaDTO.setCliente(ClienteMapper.INSTANCE.clienteToClienteDTO(reserva.getCliente()));
            
            return reservaDTO;
        }

    // RESERVA -> RESERVA DTO
    @Mapping(source = "id_reserva", target = "id")
        default
        Reserva reservaDTOToReserva(ReservaDTO reservaDTO, ClienteRepository ClienteRepository, PasajeroRepository PasajeroRepository, VueloRepository VueloRepository){
            if(reservaDTO == null){
                return null;
            }
    
            Reserva reserva = new Reserva();
            reserva.setId(reservaDTO.getId_reserva());
            reserva.setFecha(reservaDTO.getFecha());
            long id_cliente = reservaDTO.getCliente().getId_cliente();
            reserva.setCliente(ClienteRepository.findById(id_cliente).orElseThrow(
                () -> new IllegalArgumentException("Not found any client with id: " + id_cliente)
            ));
            reserva.setNum_pasajeros(reservaDTO.getNum_pasajeros());
            long id_pasajero;
            for(PasajeroDTO pasajeroDTO : reservaDTO.getPasajeros()){
                id_pasajero = pasajeroDTO.getId_pasajero();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Not found any passenger with id: ");
                stringBuilder.append(id_pasajero);
                reserva.getPasajeros().add(PasajeroRepository.findById(id_pasajero).orElseThrow(
                    () -> new IllegalArgumentException(stringBuilder.toString())
                ));
            }
            long id_vuelo;
            for(VueloDTO vueloDTO : reservaDTO.getVuelos()){
                id_vuelo = vueloDTO.getId_vuelo();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Not found any flight with id: ");
                stringBuilder.append(id_vuelo);
                reserva.getVuelos().add(VueloRepository.findById(id_vuelo).orElseThrow(
                    () -> new IllegalArgumentException(stringBuilder.toString())
                ));
            }
            
            return reserva;
        }
}
