package ProgramacionWeb.database.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Cliente;
import ProgramacionWeb.database.entities.dto.ClienteDTO;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    // CLIENTE DTO -> CLIENTE
    @Mapping(source = "id_cliente", target = "id")
    Cliente clienteDTOToCliente(ClienteDTO clienteDTO);

    // CLIENTE -> CLIENTE DTO
    @Mapping(source = "id", target = "id_cliente") 
    ClienteDTO clienteToClienteDTO(Cliente cliente);
}
