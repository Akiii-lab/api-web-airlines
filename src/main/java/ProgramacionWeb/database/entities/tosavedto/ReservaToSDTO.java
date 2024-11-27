package ProgramacionWeb.database.entities.tosavedto;

import java.util.List;
import lombok.Data;

@Data
public class ReservaToSDTO {
    private String fecha;
    private Integer num_pasajeros;
    private ClienteUToSDTO cliente;
    private List<VueloToSDTO> vuelos;
    private List<PasajeroToSDTO> pasajeros;
}

//json example:
/*
{
    "fecha": "2022-01-01",
    "num_pasajeros": 2,
    "cliente": {
        "nombres": "John",
        "apellidos": "Doe",
        "dni": "12345678",
        "telefono": 123456789,
        "correo": "jdoe@doe",
        "direccion": "Calle 123",
        "password": "password"
    },
    "vuelos": [
        {
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
                "codigo_arolinea": 1,
                "pais": "Argentina"
            },
            "aeropuerto_salida": {
                "id_aeropuerto": 1,
                "nombre": "Aeropuerto de Cordoba",
                "ciudad": "Cordoba",
                "pais": "Argentina"
            },
            "aeropuerto_llegada": {
                "id_aeropuerto": 2,
                "nombre": "Aeropuerto de Buenos Aires",
                "ciudad": "Buenos Aires",
                "pais": "Argentina"
            }
        }
    ],
    "pasajeros": [
        {
            "nombres": "John",
            "apellidos": "Doe",
            "telefono": 123456789,
            "asientos": [1]
        },
        {
            "nombres": "Jane",
            "apellidos": "Doe",
            "telefono": 123456789,
            "asientos": [2] 
        }
    ]
}
*/