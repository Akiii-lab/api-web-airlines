package ProgramacionWeb.database.entities;

import java.util.List;
import java.util.Set;

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

    @OneToMany
    private Set<Pasajero> pasajeros;
    
    @Column(nullable = false)
    private String fecha;

    @Column(nullable = false)
    private int num_pasajeros;

    @ManyToOne
    @JoinColumn (name = "id_cliente")
    private Cliente cliente;
    
    @ManyToMany
    @JoinTable(
        name = "rutas",
        joinColumns = @JoinColumn(name = "id_reserva"),
        inverseJoinColumns = @JoinColumn(name = "id_vuelo")
    )
    
    private List<Vuelo> vuelos;

    public void addVuelo(Vuelo vuelo) {
        this.vuelos.add(vuelo);
    }

}
