package ProgramacionWeb.database.entities.tosavedto;

import java.util.Set;

import ProgramacionWeb.database.entities.dto.ReservaDTO;
import lombok.Data;

@Data
public class PasajeroToSDTO {
    private String nombres;
    private String apellidos;
    private Long telefono;
    private Set<Integer> asientos;
    private ReservaDTO reserva;
}


//json example:
/*
 * {
 *      "nombres": "John",
 *      "apellidos": "Doe",
 *      "telefono": 123456789,
 *      "asientos": [
 *          1,
 *          2],
 *      "reserva": [
 *          {
 *              "id_reserva": 1,
 *              "fecha": "2022-01-01",
 *              "num_pasajeros": 2
 *          }
 *      ]
 * }
 */