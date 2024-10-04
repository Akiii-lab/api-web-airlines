package ProgramacionWeb.database.entities.dto;

import java.util.Set;

import lombok.Data;

@Data
public class ReservaDTO {

    private Long id_reserva;
    private String fecha;
    private ClienteDTO cliente;
    private int num_pasajeros;
    private Set<PasajeroDTO> pasajeros;
    private Set<VueloDTO> vuelos;

}
/*
  * json example:
  * {
  *      "id_reserva": 1,
  *      "fecha": "2022-01-01",
  *      "cliente": {
  *          "id_cliente": 1,
  *          "nombres": "John",
  *          "apellidos": "Doe",
  *          "dni": "12345678",
  *          "telefono": 123456789,
  *          "correo": "jdoe@doe",
  *          "direccion": "Calle 123",
  *          "reservas": [id_reserva1, id_reserva2]
  *      },
  *      "num_pasajeros": 2,
  *      "pasajeros": [
  *          {
  *              "id_pasajero": 1,
  *              "nombres": "John",
  *              "apellidos": "Doe",
  *              "telefono": 123456789,
  *              "asientos": [1, 2]
  *          },
  *          {
  *              "id_pasajero": 2,
  *              "nombres": "Jane",
  *              "apellidos": "Doe",
  *              "telefono": 123456789,
  *              "asientos": [3, 4]
  *          }
  *      ],
  *      "vuelos": [
  *          {
  *              "id_vuelo": 1,
  *              "origen": "Cordoba",
  *              "destino": "Buenos Aires",
  *              "fecha_salida": "2022-01-01",
  *              "hora_salida": "10:00:00",
  *              "precio": 100.0,
  *              "duracion": "01:00:00",
  *              "capacidad": 100
  *          }
  *      ]
  * }
  */