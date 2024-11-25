package ProgramacionWeb.database.entities.dto;

import java.util.List;


import lombok.Data;

@Data
public class AeropuertoDTO {

    private Long id_aeropuerto;
    private String nombre;
    private String ciudad;
    private String pais;
    private List<VueloDTO> vueloLlegada;
    private List<VueloDTO> vueloSalida;
}

/*
 * json example:
 * {
 *      "id_aeropuerto": 1,
 *      "nombre": "Aeropuerto de Cordoba",
 *      "ciudad": "Cordoba",
 *      "pais": "Argentina",
 *      "vuelos": []
 * }
 */