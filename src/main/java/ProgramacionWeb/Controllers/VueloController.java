package ProgramacionWeb.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProgramacionWeb.database.Services.VueloService;
import ProgramacionWeb.database.entities.Vuelo;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

@RequestMapping("api/v1/vuelo")
public class VueloController {
    @Autowired
    private VueloService vueloService;

    @GetMapping()
    public ResponseEntity<List<Vuelo>> findAll() {
        List<Vuelo> vuelos = vueloService.findAll();
        return ResponseEntity.ok(vuelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vuelo>> findById(@PathVariable long id) {
        return ResponseEntity.ok(vueloService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Vuelo> save(Vuelo vuelo) {
        return ResponseEntity.ok(vueloService.save(vuelo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable long id) {
        return ResponseEntity.ok(vueloService.deleteById(id));
    }

}
