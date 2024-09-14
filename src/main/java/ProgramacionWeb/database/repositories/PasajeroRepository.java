package ProgramacionWeb.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ProgramacionWeb.database.entities.Pasajero;

@RepositoryRestResource

public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {

    @Query("SELECT p FROM Pasajero p WHERE p.id = ?1")
    Pasajero findById(long id);
}
