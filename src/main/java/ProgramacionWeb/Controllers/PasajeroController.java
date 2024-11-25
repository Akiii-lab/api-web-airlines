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

import ProgramacionWeb.database.Services.PasajeroService;
import ProgramacionWeb.database.entities.dto.PasajeroDTO;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

@RequestMapping("api/v1/pasajero")
public class PasajeroController {

    @Autowired
    private PasajeroService pasajeroService;

    @GetMapping()
    public ResponseEntity<HashMap<String, Object>> findAll() {
        HashMap<String, Object> response = new HashMap<>();
        List<PasajeroDTO> pasajeros = pasajeroService.findAll();
        if (pasajeros.isEmpty()) {
            response.put("Error", "No se encontraron Pasajeros");
            return ResponseEntity.notFound().build();
        } else {
            for( PasajeroDTO pasajero : pasajeros) {
                response.put("Pasajeros", pasajero);
            }
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(@PathVariable long id) {
        HashMap<String, Object> response = new HashMap<>();
        PasajeroDTO pasajero = pasajeroService.findById(id);
        if (pasajero == null) {
            response.put("Error", "No se encontro el Pasajero con id: " + id);
            return ResponseEntity.notFound().build();
        } else {
            response.put("Pasajero", pasajero);
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<HashMap<String, Object>> save(@RequestBody PasajeroDTO pasajero) {
        HashMap<String, Object> response = new HashMap<>();
        PasajeroDTO pasajeroDTO = pasajeroService.save(pasajero);
        if (pasajeroDTO == null) {
            response.put("Error", "No se pudo registrar el Pasajero");
            return ResponseEntity.badRequest().build();
        } else {
            response.put("Pasajero", pasajeroDTO);
            return ResponseEntity.ok(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteById(@PathVariable Long id) {
        HashMap<String, Object> response = new HashMap<>();
        Boolean deleted = pasajeroService.deleteById(id);
        if (deleted) {
            response.put("Pasajero", "Se elimino el Pasajero con id: " + id);
            return ResponseEntity.ok(response);
        } else {
            response.put("Error", "No se pudo eliminar el Pasajero con id: " + id);
            return ResponseEntity.badRequest().build(); 
        }
    }

}
