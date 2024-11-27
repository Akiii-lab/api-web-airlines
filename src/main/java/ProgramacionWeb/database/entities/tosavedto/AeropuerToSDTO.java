package ProgramacionWeb.database.entities.tosavedto;


import lombok.Data;

@Data
public class AeropuerToSDTO {
    private String nombre;
    private String ciudad;
    private String pais;
}


//json example:
/*
 * {
 *      "nombre": "Aeropuerto de Cordoba",
 *      "ciudad": "Cordoba",
 *      "pais": "Argentina"
 * }
 */
