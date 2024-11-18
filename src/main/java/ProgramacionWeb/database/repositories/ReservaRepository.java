package ProgramacionWeb.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ProgramacionWeb.database.entities.Reserva;

@RepositoryRestResource

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    // find by id cliente
    @Query("SELECT r FROM Reserva r WHERE r.cliente.id = ?1")
    public List<Reserva> findByClienteId(Long id);


}
