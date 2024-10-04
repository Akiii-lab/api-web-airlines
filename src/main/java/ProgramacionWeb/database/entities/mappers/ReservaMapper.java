package ProgramacionWeb.database.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Reserva;
import ProgramacionWeb.database.entities.dto.ReservaDTO;

@Mapper
public interface ReservaMapper {

    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    // RESERVA DTO -> RESERVA
    @Mapping(source = "id", target = "id_reserva")
    ReservaDTO reservaToReservaDTO(Reserva reserva);

    // RESERVA -> RESERVA DTO
    @Mapping(source = "id_reserva", target = "id")
    Reserva reservaDTOToReserva(ReservaDTO reservaDTO);
}
