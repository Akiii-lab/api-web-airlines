package ProgramacionWeb.database.entities.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class VueloDTO {

    private Long id_vuelo;
    private String origen;
    private String destino;
    private Date fecha_salida;
    private Time hora_salida;
    private float precio;
    private Time duracion;
    private int capacidad;
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
        "capacidad": 100
    }
 */