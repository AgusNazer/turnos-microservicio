package com.turnos.turnos.services;

import com.turnos.turnos.models.Turnos;

import java.util.List;

public interface ITurnoService {
    List<Turnos> getAllTurnos();
    void saveTurno(Turnos turno);
    void deleteTurno(Long idTurno);
    Turnos findTurnoById(Long idTurno);
}
