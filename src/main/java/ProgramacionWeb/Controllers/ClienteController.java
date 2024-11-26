package ProgramacionWeb.Controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProgramacionWeb.database.Services.ClienteService;
import ProgramacionWeb.database.entities.dto.ClienteDTO;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j

@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //get all
    @GetMapping()
    public ResponseEntity<HashMap<String, Object>> findAll() {
        HashMap<String, Object> response = new HashMap<>();
        List<ClienteDTO> clientes = clienteService.findAll();
        if(clientes.isEmpty()) {
            response.put("Error", "No se encontraron Clientes");
            return ResponseEntity.notFound().build();
        }else{
            for(ClienteDTO cliente : clientes) {
                response.put("Clientes", cliente);
            }
            return ResponseEntity.ok(response);
        }
    }

    //get by id
    @GetMapping("/id/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(@PathVariable Long id) {
        HashMap <String, Object> response = new HashMap<>();
        ClienteDTO cliente = clienteService.findById(id);
        if(cliente == null) {
            response.put("Error", "No se encontro el Cliente con id: " + id);
            return ResponseEntity.notFound().build();
        }else{
            response.put("Cliente", cliente);
            return ResponseEntity.ok(response);
        }
    }

    //delete by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteById(@PathVariable Long id) {
        HashMap <String, Object> response = new HashMap<>();
        Boolean deleted = clienteService.deleteById(id);
        if(deleted) {
            response.put("Cliente", "Se elimino el Cliente con id: " + id);
            return ResponseEntity.ok(response);
        }else{
            response.put("Error", "No se pudo eliminar el Cliente con id: " + id);
            return ResponseEntity.badRequest().build();
        }
    }

    //get by email
    @GetMapping("/email/{email}")
    public ResponseEntity<HashMap<String, Object>> findByEmail(@PathVariable String email) {
        HashMap <String, Object> response = new HashMap<>();
        ClienteDTO cliente = clienteService.findByEmail(email);
        if(cliente == null) {
            response.put("Error", "No se encontro el Cliente con email: " + email);
            return ResponseEntity.notFound().build();
        }else{
            response.put("Cliente", cliente);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/itself")
    public ResponseEntity<HashMap<String, Object>> getifself() {
        Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        HashMap<String, Object> response = new HashMap<>();
        ClienteDTO cliente = clienteService.findByEmail(auth.getName());
        if(cliente == null) {
            response.put("Error", "No se encontro el Cliente con email: " + auth.getName());
            return ResponseEntity.notFound().build();
        }else{
            response.put("Cliente", cliente);
            return ResponseEntity.ok(response);
        }
    }
    
}
