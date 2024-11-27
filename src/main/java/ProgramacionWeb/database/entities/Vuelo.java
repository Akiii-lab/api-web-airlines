package ProgramacionWeb.database.entities;



import java.sql.Date;
import java.sql.Time;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    private Float precio;

    @Column(nullable = false)
    private Time duracion;

    @Column(nullable = false)
    private Integer capacidad;

    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "aerolinea")
    private Aerolinea aerolinea; 

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "aeropuertoSalida")
    private Aeropuerto aeropuertoSalida; 

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "aeropuertoLlegada")
    private Aeropuerto aeropuertoLlegada; 

    @ManyToMany(mappedBy = "vuelos", fetch = FetchType.EAGER)
    private List<Reserva> reservas;
}
