package ProgramacionWeb.database.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")

public class Cliente {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private int dni;

    @Column(nullable = false)
    private int telefono;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String direccion;

    @OneToMany
    private List<Long> id_reservasf; 

}
