package ProgramacionWeb.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ProgramacionWeb.database.entities.Aerolinea;

@RepositoryRestResource

public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {
    
}
