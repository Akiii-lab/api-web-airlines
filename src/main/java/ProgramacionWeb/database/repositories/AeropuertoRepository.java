package ProgramacionWeb.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ProgramacionWeb.database.entities.Aeropuerto;

@RepositoryRestResource

public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {

    @Query("SELECT a FROM Aeropuerto a WHERE a.id = ?1")
    Aeropuerto findById(long id);
}
