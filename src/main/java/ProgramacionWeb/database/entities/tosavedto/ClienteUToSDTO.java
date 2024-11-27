package ProgramacionWeb.database.entities.tosavedto;

import lombok.Data;

@Data
public class ClienteUToSDTO {
    private String nombres;
    private String apellidos;
    private Integer dni;
    private Integer telefono;
    private String correo;
    private String direccion;
    private String password;
}

//json example:
/*
 * {
 *      "nombres": "John",
 *      "apellidos": "Doe",
 *      "dni": "12345678",
 *      "telefono": 123456789,
 *      "correo": "jdoe@doe",
 *      "direccion": "Calle 123",
 *      "password": "password"
 * }
 */
