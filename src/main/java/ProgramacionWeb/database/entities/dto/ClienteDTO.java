package ProgramacionWeb.database.entities.dto;

import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class ClienteDTO {

    private Long id_cliente;
    private String nombres;
    private String apellidos;
    private int dni;
    private int telefono;
    private String correo;
    private String direccion;
    private List<Long> id_reservasf;
}

/*
 * json example:
 * {
 *      "id_cliente": 1,
 *      "nombres": "John",
 *      "apellidos": "Doe",
 *      "dni": "12345678",
 *      "telefono": 123456789,
 *      "correo": "jdoe@doe",
 *      "direccion": "Calle 123",
 *      "reservas": [id_reserva1, id_reserva2]
 * }
 */