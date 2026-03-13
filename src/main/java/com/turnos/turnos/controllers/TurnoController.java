package com.turnos.turnos.controllers;

import com.turnos.turnos.dtos.TurnoRequestDto;
import com.turnos.turnos.dtos.TurnoResponseDto;
import com.turnos.turnos.models.Turnos;
import com.turnos.turnos.services.ITurnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/turnos")
@Tag(name = "Turnos", description = "Gestión de turnos médicos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoService;

    @Operation(summary = "Crear un turno")
    @PostMapping
    public ResponseEntity<String> createTurno(@RequestBody TurnoRequestDto turnoRequestDto) {
        Turnos turno = new Turnos();
        turno.setIdPaciente(turnoRequestDto.getIdPaciente());
        turno.setDescription(turnoRequestDto.getDescription());
        turno.setDate(turnoRequestDto.getDate());
        turnoService.saveTurno(turno);
        return ResponseEntity.status(HttpStatus.CREATED).body("Turno creado exitosamente");
    }

    @Operation(summary = "Obtener todos los turnos")
    @GetMapping
    public ResponseEntity<List<TurnoResponseDto>> getAllTurnos() {
        List<TurnoResponseDto> turnos = turnoService.getAllTurnos()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(turnos);
    }

    @Operation(summary = "Obtener un turno por ID")
    @GetMapping("/{id}")
    public ResponseEntity<TurnoResponseDto> getTurnoById(@PathVariable Long id) {
        Turnos turno = turnoService.findTurnoById(id);
        if (turno == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(toResponseDto(turno));
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
    public ResponseEntity<String> updateTurno(@PathVariable Long id, @RequestBody TurnoRequestDto turnoRequestDto) {
        Turnos existingTurno = turnoService.findTurnoById(id);
        if (existingTurno == null) return ResponseEntity.notFound().build();
        existingTurno.setDate(turnoRequestDto.getDate());
        existingTurno.setIdPaciente(turnoRequestDto.getIdPaciente());
        existingTurno.setDescription(turnoRequestDto.getDescription());
        turnoService.saveTurno(existingTurno);
        return ResponseEntity.ok("Turno actualizado exitosamente");
    }

    private TurnoResponseDto toResponseDto(Turnos turno) {
        TurnoResponseDto responseDto = new TurnoResponseDto();
        responseDto.setIdTurno(turno.getIdTurno());
        responseDto.setIdPaciente(turno.getIdPaciente());
        responseDto.setDescription(turno.getDescription());
        responseDto.setDate(turno.getDate());
        return responseDto;
    }
}
