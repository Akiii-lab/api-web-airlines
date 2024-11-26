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

import ProgramacionWeb.database.Services.AeropuertoService;
import ProgramacionWeb.database.entities.dto.AeropuertoDTO;
import ProgramacionWeb.database.entities.mappers.AeropuertoMapper;
import ProgramacionWeb.database.repositories.AerolineaRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/aeropuerto")
public class AeropuertoController {

    @Autowired
    private AeropuertoService aeropuertoService;

    @Autowired
    private AerolineaRepository aerolineaRepository;
    
    //get all
    @GetMapping()
    public ResponseEntity<HashMap<String, Object>> findAll() {
        HashMap <String, Object> response = new HashMap<>();
        List<AeropuertoDTO> aeropuertos = aeropuertoService.findAll();
        if(aeropuertos.isEmpty()) {
            response.put("Error", "No se encontraron Aeropuertos");
            return ResponseEntity.notFound().build();
        }else{
            for(AeropuertoDTO aeropuerto : aeropuertos) {
                response.put("Aeropuertos", aeropuerto);
            }
            return ResponseEntity.ok(response);
        }
    }

    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(@PathVariable Long id) {
        HashMap <String, Object> response = new HashMap<>();
        AeropuertoDTO aeropuerto = aeropuertoService.findById(id);
        if(aeropuerto == null) {
            response.put("Error", "No se encontro el Aeropuerto con id: " + id);
            return ResponseEntity.notFound().build();
        }else{
            response.put("Aeropuerto", aeropuerto);
            return ResponseEntity.ok(response);
        }
    }

    //save
    @PostMapping("/registrar")
    public ResponseEntity<HashMap<String, Object>> save(@RequestBody AeropuertoDTO aeropuerto) {
        HashMap <String, Object> response = new HashMap<>();
        AeropuertoDTO aeropuertoDTO = aeropuertoService.save(AeropuertoMapper.INSTANCE.aeropuertoDTOToAeropuerto(aeropuerto, aerolineaRepository));
        if(aeropuertoDTO == null) {
            response.put("Error", "No se pudo guardar el Aeropuerto");
            return ResponseEntity.badRequest().build();
        }else{
            response.put("Aeropuerto", aeropuertoDTO);
            return ResponseEntity.ok(response);
        }
    }

    //delete by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteById(@PathVariable Long id) {
        HashMap <String, Object> response = new HashMap<>();
        Boolean deleted = aeropuertoService.deleteById(id);
        if(deleted) {
            response.put("Aeropuerto", "Se elimino el Aeropuerto con id: " + id);
            return ResponseEntity.ok(response);
        }else{
            response.put("Error", "No se pudo eliminar el Aeropuerto con id: " + id);
            return ResponseEntity.badRequest().build();
        }
    }
}
