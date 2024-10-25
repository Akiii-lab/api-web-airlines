package ProgramacionWeb.database.entities.dto;

import java.util.List;


import lombok.Data;

@Data
public class AerolineaDTO {
    private Long id_aerolinea;
    private String nombre;
    private String pais;
    private int codigo_arolinea;
    private List<Long> vuelos;

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