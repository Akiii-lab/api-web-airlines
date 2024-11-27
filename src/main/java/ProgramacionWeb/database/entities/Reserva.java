package ProgramacionWeb.database.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "reservas")

public class Reserva {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String fecha;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "id_cliente" )
    private Cliente cliente;

    @Column(nullable = false)
    private Integer num_pasajeros;

    @OneToMany(cascade = CascadeType.PERSIST)
    @Builder.Default
    private Set<Pasajero> pasajeros = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "rutas",
        joinColumns = @JoinColumn(name = "id_reserva"),
        inverseJoinColumns = @JoinColumn(name = "id_vuelo")
    )
    @Builder.Default
    private List<Vuelo> vuelos = new ArrayList<>();

    public void addVuelo(Vuelo vuelo) {
        this.vuelos.add(vuelo);
    } 

}
