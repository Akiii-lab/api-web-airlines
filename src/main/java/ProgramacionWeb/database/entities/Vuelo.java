package ProgramacionWeb.database.entities;


import java.sql.Date;
import java.sql.Time;
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
    private Date fecha_salida;

    @Column(nullable = false)
    private Time hora_salida;

    @Column(nullable = false)
    private float precio;

    @Column(nullable = false)
    private Time duracion;

    @Column(nullable = false)
    private int capacidad;

    @ManyToOne
    @JoinColumn (name = "id_aerolinea")
    private Aerolinea aerolinea;

    @ManyToOne
    @JoinColumn (name = "id_aeropuerto")
    private Aeropuerto aeropuerto;

    @ManyToMany (mappedBy = "vuelos")
    private Set<Reserva> reservas; 
}
