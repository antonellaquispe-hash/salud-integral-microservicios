package com.saludintegral.cita.dto;
import jakarta.validation.constraints.*;import java.time.*;public record CitaRequest(@NotNull @FutureOrPresent LocalDate fecha,@NotNull LocalTime hora,@NotNull @Positive Long idPaciente,@NotNull @Positive Long idMedico,@Size(max=300) String motivo){}
