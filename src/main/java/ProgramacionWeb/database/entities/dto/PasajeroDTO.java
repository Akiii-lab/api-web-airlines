package ProgramacionWeb.database.entities.dto;

import java.util.Set;

import lombok.Data;

@Data
public class PasajeroDTO {

    private Long id_pasajero;
    private String nombres;
    private String apellidos;
    private int telefono;
    private Set<Integer> asientos;
    private ReservaDTO reserva;
}

/*
 * json example:
 * {
 *      "id_pasajero": 1,
 *      "nombres": "John",
 *      "apellidos": "Doe",
 *      "telefono": 123456789,
 *      "asientos": [1, 2],
 *      "reserva": {
 *          "id_reserva": 1,
 *          "fecha": "2022-01-01",
 *          "cliente": {
 *              "id_cliente": 1,
 *              "nombres": "John",
 *              "apellidos": "Doe",
 *              "dni": "12345678",
 *              "telefono": 123456789,
 *              "correo": "jdoe@doe",
 *              "direccion": "Calle 123",
 *              "reservas": [id_reserva1, id_reserva2]
 *          },
 *          "num_pasajeros": 2,
 *          "pasajeros": [
 *              {
 *                  "id_pasajero": 1,
 *                  "nombres": "John",
 *                  "apellidos": "Doe",
 *                  "telefono": 123456789,
 *                  "asientos": [1, 2]
 *              },
 *              {
 *                  "id_pasajero": 2,
 *                  "nombres": "Jane",
 *                  "apellidos": "Doe",
 *                  "telefono": 123456789,
 *                  "asientos": [3, 4]
 *              }
 *          ],
 *          "vuelos": [id_vuelo1, id_vuelo2]
 *      }
 * }
 */