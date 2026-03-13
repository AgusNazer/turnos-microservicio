package com.turnos.turnos.repository;

import com.turnos.turnos.models.Turnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turnos, Long> {

}
