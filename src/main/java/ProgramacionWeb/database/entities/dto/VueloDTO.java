package ProgramacionWeb.database.entities.dto;


import java.sql.Date;
import java.sql.Time;

import java.util.List;

import lombok.Data;

@Data
public class VueloDTO {

    private Long id_vuelo;
    private String origen;
    private String destino;
    private Date fecha_salida;
    private Time hora_salida;
    private Float precio;
    private Time duracion;
    private Integer capacidad;
    private AerolineaDTO aerolinea;
    private AeropuertoDTO aeropuertoSalida;
    private AeropuertoDTO aeropuertoLlegada;
    private List<ReservaDTO> reservas;
}

/*
    json example:
    {
        "id_vuelo": 1,
        "origen": "Cordoba",
        "destino": "Buenos Aires",
        "fecha_salida": "2022-01-01",
        "hora_salida": "10:00:00",
        "precio": 100.0,
        "duracion": "01:00:00",
        "capacidad": 100,
        "aerolinea": {
            "id_aerolinea": 1,
            "nombre": "Aerolinea 1",
            "pais": "Argentina",
            "vuelos": []
        },
        "aeropuerto_salida": {
            "id_aeropuerto": 1,
            "nombre": "Aeropuerto de Cordoba",
            "ciudad": "Cordoba",
            "pais": "Argentina",
            "vuelos": []
        },
        "aeropuerto_llegada": {
            "id_aeropuerto": 2,
            "nombre": "Aeropuerto de Buenos Aires",
            "ciudad": "Buenos Aires",
            "pais": "Argentina",
            "vuelos": []
        }
    }
 */