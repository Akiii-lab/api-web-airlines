package ProgramacionWeb.database.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProgramacionWeb.database.entities.Cliente;
import ProgramacionWeb.database.repositories.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //get by id
    public Optional<Cliente> findById(long id) {
        return clienteRepository.findById(id);
    }

    //get by email
    public Optional<Cliente> findByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    //get all
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    //save
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //delete by id
    public Boolean deleteById(long id) {
        if( clienteRepository.findById(id) == null ){
            return false;
        }
        clienteRepository.deleteById(id);
        return true;
    }
    
}
