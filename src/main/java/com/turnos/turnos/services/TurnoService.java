package com.turnos.turnos.services;

import com.turnos.turnos.models.Turnos;
import com.turnos.turnos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.turnos.turnos.clients.PatientClient;
import com.turnos.turnos.dtos.PatientDto;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    private PatientClient patientClient;

    @Override
    public List<Turnos> getAllTurnos() {

        return turnoRepository.findAll();
    }

    @Override
    public void saveTurno(Turnos turno) {
        PatientDto paciente = patientClient.getPacienteById(turno.getIdPaciente());
        if (paciente == null) {
            throw new RuntimeException("Paciente con id " + turno.getIdPaciente() + " no encontrado");
        }
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
