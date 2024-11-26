package ProgramacionWeb.Controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProgramacionWeb.database.Services.VueloService;
import ProgramacionWeb.database.entities.dto.VueloDTO;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

@RequestMapping("api/v1/vuelo")
public class VueloController {
    @Autowired
    private VueloService vueloService;

    @GetMapping()
    public ResponseEntity<HashMap<String, Object>> findAll() {
        HashMap<String, Object> response = new HashMap<>();
        List<VueloDTO> vuelos = vueloService.findAll();
        if (vuelos.isEmpty()) {
            response.put("Error", "No se encontraron Vuelos");
            return ResponseEntity.notFound().build();
        } else {
            response.put("Vuelos", vuelos);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(@PathVariable Long id) {
        HashMap<String, Object> response = new HashMap<>();
        VueloDTO vuelo = vueloService.findById(id);
        if (vuelo==null) {
            response.put("Error", "No se encontro el Vuelo con id: " + id);
            return ResponseEntity.notFound().build();
        } else {
            response.put("Vuelo", vuelo);
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<HashMap<String, Object>> save(@RequestBody VueloDTO vuelo) {
        HashMap<String, Object> response = new HashMap<>();
        VueloDTO vueloDTO = vueloService.save(vuelo);
        if (vueloDTO == null) {
            response.put("Error", "No se pudo registrar el Vuelo");
            return ResponseEntity.badRequest().build();
        } else {
            response.put("Vuelo", vueloDTO);
            return ResponseEntity.ok(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteById(@PathVariable Long id) {
        HashMap<String, Object> response = new HashMap<>();
        Boolean deleted = vueloService.deleteById(id);
        if (deleted) {
            response.put("Vuelo", "Se elimino el Vuelo con id: " + id);
            return ResponseEntity.ok(response);
        } else {
            response.put("Error", "No se pudo eliminar el Vuelo con id: " + id);
            return ResponseEntity.badRequest().build();
        }
    }

}
