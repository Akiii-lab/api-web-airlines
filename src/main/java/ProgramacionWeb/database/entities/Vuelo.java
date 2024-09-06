package ProgramacionWeb.database.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "vuelos")


public class Vuelo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false)
    private String fecha_salida;

    @Column(nullable = false)
    private float hora_salida;

    @Column(nullable = false)
    private float precio;

    @Column(nullable = false)
    private int duracion;

    @Column(nullable = false)
    private int capacidad;

    @ManyToOne
    @JoinColumn (name = "id_aerolinea")
    private Aerolinea aerolinea;

    @ManyToMany (mappedBy = "vuelos")
    private Set<Reserva> reservas;
}
