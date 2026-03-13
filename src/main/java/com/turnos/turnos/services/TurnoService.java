package com.turnos.turnos.services;

import com.turnos.turnos.models.Turnos;
import com.turnos.turnos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Override
    public List<Turnos> getAllTurnos() {
        return turnoRepository.findAll();
    }

    @Override
    public void saveTurno(Turnos turno) {
        turnoRepository.save(turno);
    }

    @Override
    public void deleteTurno(Long idTurno) {
        turnoRepository.deleteById(idTurno);
    }

    @Override
    public Turnos findTurnoById(Long idTurno) {
        return turnoRepository.findById(idTurno).orElse(null);
    }
}
