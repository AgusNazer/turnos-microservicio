package com.turnos.turnos.controllers;

import com.turnos.turnos.models.Turnos;
import com.turnos.turnos.services.ITurnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turnos")
@Tag(name = "Turnos", description = "Gestión de turnos médicos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoService;

    @Operation(summary = "Crear un turno")
    @PostMapping
    public ResponseEntity<String> createTurno(@RequestBody Turnos turno) {
        turnoService.saveTurno(turno);
        return ResponseEntity.status(HttpStatus.CREATED).body("Turno creado exitosamente");
    }

    @Operation(summary = "Obtener todos los turnos")
    @GetMapping
    public ResponseEntity<List<Turnos>> getAllTurnos() {
        return ResponseEntity.ok(turnoService.getAllTurnos());
    }

    @Operation(summary = "Obtener un turno por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Turnos> getTurnoById(@PathVariable Long id) {
        Turnos turno = turnoService.findTurnoById(id);
        if (turno == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(turno);
    }

    @Operation(summary = "Eliminar un turno por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTurno(@PathVariable Long id) {
        Turnos turno = turnoService.findTurnoById(id);
        if (turno == null) return ResponseEntity.notFound().build();
        turnoService.deleteTurno(id);
        return ResponseEntity.ok("Turno eliminado exitosamente");
    }

    @Operation(summary = "Actualizar un turno por ID")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTurno(@PathVariable Long id, @RequestBody Turnos turno) {
        Turnos existingTurno = turnoService.findTurnoById(id);
        if (existingTurno == null) return ResponseEntity.notFound().build();
        existingTurno.setDate(turno.getDate());
        existingTurno.setIdPaciente(turno.getIdPaciente());
        existingTurno.setDescription(turno.getDescription());
        turnoService.saveTurno(existingTurno);
        return ResponseEntity.ok("Turno actualizado exitosamente");
    }
}
