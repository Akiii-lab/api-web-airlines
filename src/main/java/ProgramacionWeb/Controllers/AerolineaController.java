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

import ProgramacionWeb.database.Services.AerolineaService;
import ProgramacionWeb.database.entities.dto.AerolineaDTO;
import ProgramacionWeb.database.entities.tosavedto.AerolineaToSDTO;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/aerolineas")

public class AerolineaController {
    @Autowired
    private AerolineaService service;

    @GetMapping()
    //get all
    public ResponseEntity<HashMap<String, Object>> findAll() {
        HashMap <String, Object> response = new HashMap<>();
        List<AerolineaDTO> aerolineas = service.findAll();
        if(aerolineas.isEmpty()) {
            response.put("Error", "No se encontraron Aerolineas");
            return ResponseEntity.notFound().build();
        }else{
            for(AerolineaDTO aerolinea : aerolineas) {
                response.put("Aerolineas", aerolinea);
            }
            return ResponseEntity.ok(response);
        }
    }
    
    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(@PathVariable Long id) {
        HashMap <String, Object> response = new HashMap<>();
        AerolineaDTO aerolineaDTO = service.findById(id);
        if(aerolineaDTO == null) {
            response.put("Error", "No se encontro la Aerolinea con id: " + id);
            return ResponseEntity.notFound().build();
        }else{
            response.put("Aerolinea", aerolineaDTO);
            return ResponseEntity.ok(response);
        }
    }

    //save
    @PostMapping()
    public ResponseEntity<HashMap<String, Object>> save(@RequestBody AerolineaToSDTO aerolineaDTO) {
        HashMap <String, Object> response = new HashMap<>();
        if(aerolineaDTO == null) {
            response.put("Error", "No se pudo registrar la Aerolinea");
            return ResponseEntity.badRequest().build();
        }else{
            AerolineaDTO aerolineadto = service.save(aerolineaDTO);
            response.put("Aerolinea", aerolineadto);
            return ResponseEntity.ok(response);
        }
    }

    //delete by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteById(@PathVariable Long id) {
        Boolean deleted = service.deleteById(id);
        HashMap <String, Object> response = new HashMap<>();
        if(deleted) {
            response.put("Aerolinea", "Se elimino la Aerolinea con id: " + id);
            return ResponseEntity.ok(response);
        }else{
            response.put("Error", "No se pudo eliminar la Aerolinea con id: " + id);
            return ResponseEntity.badRequest().build();
        }
    }
}
