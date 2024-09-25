package ProgramacionWeb.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProgramacionWeb.database.Services.ClienteService;
import ProgramacionWeb.database.entities.Cliente;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //get all
    @GetMapping()
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    //save
    @PostMapping()
    public ResponseEntity<Cliente> save(Cliente cliente) {
        return ResponseEntity.ok(clienteService.save(cliente));
    }

    //delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable long id) {
        return ResponseEntity.ok(clienteService.deleteById(id));
    }
}
