package ProgramacionWeb.database.Services;

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
    public Cliente findById(long id) {
        return clienteRepository.findById(id);
    }

    //get all
    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    //save
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    //delete
    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    //delete by id
    public void deleteById(long id) {
        clienteRepository.deleteById(id);
    }
    
}
