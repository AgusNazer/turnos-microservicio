package com.turnos.turnos.clients;

import com.turnos.turnos.dtos.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pacientes", url = "${pacientes.service.url}")
public interface PatientClient {

    @GetMapping("/api/patients/{id}")
    PatientDto getPacienteById(@PathVariable Long id);
}