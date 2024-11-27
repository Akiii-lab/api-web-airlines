package ProgramacionWeb.database.entities.tosavedto;

import java.sql.Date;
import java.sql.Time;


import lombok.Data;

@Data
public class VueloToSDTO {
    private String origen;
    private String destino;
    private Date fecha_salida;
    private Time hora_salida;
    private Float precio;
    private Time duracion;
    private Integer capacidad;
    private AerolineaToSDTO aerolinea;
    private AeropuerToSDTO aeropuerto_salida;
    private AeropuerToSDTO aeropuerto_llegada;
}

//json example:
/*
 * {
 *      "origen": "Cordoba",
 *      "destino": "Buenos Aires",
 *      "fecha_salida": "2022-01-01",
 *      "hora_salida": "10:00:00",
 *      "precio": 100.0,
 *      "duracion": "01:00:00",
 *      "capacidad": 100,
 *      "aerolinea": {
 *          "nombre": "Aerolinea 1",
 *          "codigo_arolinea": 1,
 *          "pais": "Argentina"
 *      },
 *      "aeropuerto_salida": {
 *          "nombre": "Aeropuerto de Cordoba",
 *          "ciudad": "Cordoba",
 *          "pais": "Argentina"
 *      },
 *      "aeropuerto_llegada": {
 *          "nombre": "Aeropuerto de Buenos Aires",
 *          "ciudad": "Buenos Aires",
 *          "pais": "Argentina"
 *      }
 *  }
 */
