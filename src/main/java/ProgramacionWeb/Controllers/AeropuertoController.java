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

import ProgramacionWeb.database.Services.AeropuertoService;
import ProgramacionWeb.database.entities.Aeropuerto;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/aeropuerto")
public class AeropuertoController {

    @Autowired
    private AeropuertoService aeropuertoService;
    
    //get all
    @GetMapping()
    public ResponseEntity<List<Aeropuerto>> findAll() {
        return ResponseEntity.ok(aeropuertoService.findAll());
    }

    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<Aeropuerto> findById(@PathVariable long id) {
        return ResponseEntity.ok(aeropuertoService.findById(id));
    }

    //save
    @PostMapping()
    public ResponseEntity<Aeropuerto> save(Aeropuerto aeropuerto) {
        return ResponseEntity.ok(aeropuertoService.save(aeropuerto));
    }

    //delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable long id) {
        return ResponseEntity.ok(aeropuertoService.deleteById(id));
    }
}
