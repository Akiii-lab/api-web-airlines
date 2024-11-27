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

import ProgramacionWeb.database.Services.ReservaService;
import ProgramacionWeb.database.entities.dto.ReservaDTO;
import ProgramacionWeb.database.entities.tosavedto.ReservaToSDTO;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j

@RequestMapping("api/v1/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping()
    public ResponseEntity<HashMap<String, Object>> findAll() {
        HashMap<String, Object> response = new HashMap<>();
        List<ReservaDTO> reservas = reservaService.findAll();
        if (reservas.isEmpty()) {
            response.put("Error", "No se encontraron Reservas");
            return ResponseEntity.notFound().build();
        } else {
            for(ReservaDTO reserva : reservas) {
                response.put("Reservas", reserva);
            }
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(@PathVariable Long id) {
        HashMap<String, Object> response = new HashMap<>();
        ReservaDTO reserva = reservaService.findById(id);
        if (reserva== null) {
            response.put("Error", "No se encontro la Reserva con id: " + id);
            return ResponseEntity.notFound().build();
        } else {
            response.put("Reserva", reserva);
            return ResponseEntity.ok(response);
        }
    }
    
    @PostMapping()
    public ResponseEntity<HashMap<String, Object>> save(@RequestBody ReservaToSDTO reserva) {
        HashMap<String, Object> response = new HashMap<>();
        log.info("creating reserva"+ reserva);
        ReservaDTO reservaDTO = reservaService.save(reserva);
        if (reservaDTO == null) {
            response.put("Error", "No se pudo registrar la Reserva");
            return ResponseEntity.badRequest().build();
        } else {
            response.put("Reserva", reservaDTO);
            return ResponseEntity.ok(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteById(@PathVariable Long id) {
        HashMap<String, Object> response = new HashMap<>();
        Boolean deleted = reservaService.deleteById(id);
        if (deleted) {
            response.put("Reserva", "Se elimino la Reserva con id: " + id);
            return ResponseEntity.ok(response);
        } else {
            response.put("Error", "No se pudo eliminar la Reserva con id: " + id);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/reservas/{id}")
    public ResponseEntity<HashMap<String, Object>> getReservas(@PathVariable("id") Long id) {
        HashMap<String, Object> response = new HashMap<>();
        List<ReservaDTO> reservas = reservaService.findByClienteId(id);
        if (reservas.isEmpty()) {
            response.put("Error", "No se encontraron Reservas");
            return ResponseEntity.notFound().build();
        } else {
            for(ReservaDTO reserva : reservas) {
                response.put("Reservas", reserva);
            }
            return ResponseEntity.ok(response);
        }
    }
    
}
