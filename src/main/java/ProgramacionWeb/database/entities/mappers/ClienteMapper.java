package ProgramacionWeb.database.entities.mappers;

import java.util.ArrayList;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ProgramacionWeb.database.entities.Cliente;
import ProgramacionWeb.database.entities.Reserva;
import ProgramacionWeb.database.entities.dto.ClienteDTO;
import ProgramacionWeb.database.entities.dto.ReservaDTO;
import ProgramacionWeb.database.repositories.AerolineaRepository;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    // CLIENTE DTO -> CLIENTE
    @Mapping(source = "id_cliente", target = "id")
    default Cliente clienteDTOToCliente(ClienteDTO clienteDTO, AerolineaRepository repository) {
        if (clienteDTO == null)
            return null;

        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId_cliente());
        cliente.setNombres(clienteDTO.getNombres());
        cliente.setApellidos(clienteDTO.getApellidos());
        cliente.setDni(clienteDTO.getDni());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setCorreo(clienteDTO.getCorreo());
        cliente.setPassword(clienteDTO.getPassword());
        cliente.setRole(clienteDTO.getRole());
        if (clienteDTO.getReservas() != null) {
            for (ReservaDTO reservaDTO : clienteDTO.getReservas()) {
                cliente.getReservas().add(ReservaMapper.INSTANCE.reservaDTOToReserva(reservaDTO, repository));
            }
        } else {
            cliente.setReservas(new ArrayList<>());
        }
        return cliente;
    }

    // CLIENTE -> CLIENTE DTO
    @Mapping(source = "id", target = "id_cliente")
    default ClienteDTO clienteToClienteDTO(Cliente cliente) {
        if (cliente == null)
            return null;

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId_cliente(cliente.getId());
        clienteDTO.setNombres(cliente.getNombres());
        clienteDTO.setApellidos(cliente.getApellidos());
        clienteDTO.setDni(cliente.getDni());
        clienteDTO.setDireccion(cliente.getDireccion());
        clienteDTO.setTelefono(cliente.getTelefono());
        clienteDTO.setCorreo(cliente.getCorreo());
        clienteDTO.setPassword(cliente.getPassword());
        clienteDTO.setRole(cliente.getRole());
        if (cliente.getReservas() != null) {
            for (Reserva reserva : cliente.getReservas()) {
                clienteDTO.getReservas().add(ReservaMapper.INSTANCE.reservaToReservaDTO(reserva));
            }
        } else {
            clienteDTO.setReservas(new ArrayList<>());
        }
        return clienteDTO;
    }
}
