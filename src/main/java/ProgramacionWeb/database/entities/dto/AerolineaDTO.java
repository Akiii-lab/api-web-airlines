package ProgramacionWeb.database.entities.dto;

import java.util.List;


import lombok.Data;

@Data
public class AerolineaDTO {
    private Long id_aerolinea;
    private String nombre;
    private int codigo_arolinea;
    private String pais;
    private List<VueloDTO> vuelos;
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