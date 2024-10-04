package ProgramacionWeb.database.entities.dto;

import java.util.Set;

import lombok.Data;

@Data
public class AreolineaDTO {
    private Long id_aerolinea;
    private String nombre;
    private String pais;
    private int codigo_arolinea;
    private Set<VueloDTO> vuelos;

}

/* 
    json example:
    {
        "id_aerolinea": 1,
        "nombre": "Volaris",
        "codigo_arolinea": 1,
        "pais": "Alemania",
        "vuelos": []
    }
*/