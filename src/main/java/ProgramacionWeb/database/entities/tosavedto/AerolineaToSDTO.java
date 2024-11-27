package ProgramacionWeb.database.entities.tosavedto;

import lombok.Data;

@Data
public class AerolineaToSDTO {
    private String nombre;
    private Integer codigo_arolinea;
    private String pais;
}

//json example:
/*
 * {
 *      "nombre": "Volaris",
 *      "codigo_arolinea": 1,
 *      "pais": "Alemania"
 * }
 */
