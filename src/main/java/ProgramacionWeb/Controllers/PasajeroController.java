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

import ProgramacionWeb.database.Services.PasajeroService;
import ProgramacionWeb.database.entities.Pasajero;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

@RequestMapping("api/v1/pasajero")
public class PasajeroController {

    @Autowired
    private PasajeroService pasajeroService;

    @GetMapping()
    public ResponseEntity<List<Pasajero>> findAll() {
        List<Pasajero> pasajeros = pasajeroService.findAll();
        return ResponseEntity.ok(pasajeros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pasajero> findById(@PathVariable long id) {
        return ResponseEntity.ok(pasajeroService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Pasajero> save(Pasajero pasajero) {
        return ResponseEntity.ok(pasajeroService.save(pasajero));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable long id) {
        return ResponseEntity.ok(pasajeroService.deleteById(id));
    }

}
