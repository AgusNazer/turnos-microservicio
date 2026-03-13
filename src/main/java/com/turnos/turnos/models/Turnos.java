package com.turnos.turnos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "turnos")
public class Turnos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private Long idTurno;

    @Column(name = "id_paciente", nullable = false)
    private Long idPaciente;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate date;

    public Turnos() {
    }

    public Turnos(Long idTurno, Long idPaciente, String description, LocalDate date) {
        this.idTurno = idTurno;
        this.idPaciente = idPaciente;
        this.description = description;
        this.date = date;
    }

    public Long getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Long idTurno) {
        this.idTurno = idTurno;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
