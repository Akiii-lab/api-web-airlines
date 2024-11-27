package ProgramacionWeb.database.entities.dto;

import java.util.Set;

import lombok.Data;

@Data
public class PasajeroDTO {

    private Long id_pasajero;
    private String nombres;
    private String apellidos;
    private Long telefono;
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
 *      "asientos": [],
 *      "reserva": []
 *      
 * }
 */