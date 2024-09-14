package ProgramacionWeb.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ProgramacionWeb.database.entities.Vuelo;

@RepositoryRestResource

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
    
    @Query("SELECT v FROM Vuelo v WHERE v.id = ?1")
    Vuelo findById(long id);
}
