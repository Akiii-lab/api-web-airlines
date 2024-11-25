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
@Table(name = "aeropuertos")

public class Aeropuerto {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String ciudad;
    
    @Column(nullable = false)
    private String pais;

    @OneToMany (mappedBy = "aeropuertoSalida")
    private List<Vuelo> vuelosSalidas;

    @OneToMany (mappedBy = "aeropuertoLlegada")
    private List<Vuelo> vuelosLlegadas;
}
