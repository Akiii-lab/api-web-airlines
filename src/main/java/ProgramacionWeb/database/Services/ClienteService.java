package ProgramacionWeb.database.Services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProgramacionWeb.database.entities.Cliente;
import ProgramacionWeb.database.entities.dto.ClienteDTO;
import ProgramacionWeb.database.entities.mappers.ClienteMapper;
import ProgramacionWeb.database.entities.tosavedto.ClienteUToSDTO;
import ProgramacionWeb.database.repositories.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //get by id
    public ClienteDTO findById(Long id) {
        if(id == null) {
            return null;
        }
        Cliente cliente = clienteRepository.findById(id).get();
        return ClienteMapper.INSTANCE.clienteToClienteDTO(cliente);
    }

    //get by email
    public ClienteDTO findByEmail(String email) {
        if(email == null) {
            return null;
        }
        Cliente cliente = clienteRepository.findByEmail(email).get();
        return ClienteMapper.INSTANCE.clienteToClienteDTO(cliente);
    }

    //get all
    public List<ClienteDTO> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        if(clientes.isEmpty()) {
            return null;
        }
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        for(Cliente cliente : clientes) {
            clientesDTO.add(ClienteMapper.INSTANCE.clienteToClienteDTO(cliente));
        }
        return clientesDTO;
    }

    //save
    public ClienteDTO save(ClienteUToSDTO cliente) {
        if(cliente == null) {
            return null;
        }
        Cliente clienteSaved = clienteRepository.save(ClienteMapper.INSTANCE.clienteToCliente(cliente));
        return ClienteMapper.INSTANCE.clienteToClienteDTO(clienteSaved);
    }

    //delete by id
    public Boolean deleteById(Long id) {
        if(id == null) {
            return false;
        }
        clienteRepository.deleteById(id);
        return true;
    }
    
    //convert to dto
    public ClienteDTO convertToDTO(Cliente cliente) {
        if(cliente == null) {
            return null;
        }
        return ClienteMapper.INSTANCE.clienteToClienteDTO(cliente);
    }

    //convert to entity
    public Cliente convertToEntity(ClienteUToSDTO clienteDTO) {
        if(clienteDTO == null) {
            return null;
        }
        return ClienteMapper.INSTANCE.clienteToCliente(clienteDTO);
    }
}
