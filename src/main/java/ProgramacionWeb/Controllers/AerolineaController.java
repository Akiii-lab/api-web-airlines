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

import ProgramacionWeb.database.Services.AerolineaService;
import ProgramacionWeb.database.entities.Aerolinea;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/aerolineas")

public class AerolineaController {
    @Autowired
    private AerolineaService service;

    @GetMapping()
    //get all
    public ResponseEntity<List<Aerolinea>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    
    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<Aerolinea> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    //save
    @PostMapping()
    public ResponseEntity<Aerolinea> save(Aerolinea aerolinea) {
        return ResponseEntity.ok(service.save(aerolinea));
    }

    //delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable long id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}
