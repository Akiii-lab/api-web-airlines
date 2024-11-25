package ProgramacionWeb.Controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProgramacionWeb.database.Services.ClienteService;
import ProgramacionWeb.database.entities.dto.ClienteDTO;
import ProgramacionWeb.security.jwt.JWTgeneretor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Slf4j
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTgeneretor tokengeneretor;

    @PostMapping("/cliente/registrar")
    public ResponseEntity<HashMap<String, Object>> save(@RequestBody ClienteDTO clienteDTO) {
        log.info("creating client");
        HashMap<String, Object> response = new HashMap<>();
        String password = passwordEncoder.encode(clienteDTO.getPassword());
        clienteDTO.setPassword(password);
        ClienteDTO cliente = clienteService.save(clienteDTO);
        if (cliente == null) {
            response.put("Error", "No se pudo registrar el Cliente");
            return ResponseEntity.internalServerError().build();
        } else {
            response.put("Cliente", cliente);
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/cliente/login")
    public ResponseEntity<HashMap<String, Object>> authenticateClient(@RequestBody HashMap<String, Object> authdata) {
        
        ClienteDTO existingClient = clienteService.findByEmail(authdata.get("correo").toString());
        
        if(existingClient == null || !passwordEncoder.matches(authdata.get("password").toString(), existingClient.getPassword())) {
            HashMap<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Error", "Credenciales incorrectas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
            existingClient.getCorreo(), 
            existingClient.getPassword());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokengeneretor.generateToken(authentication);

        HashMap<String, Object> response = new HashMap<>();
        response.put("token", jwt);
        return ResponseEntity.ok(response);
    }
    
    
}
