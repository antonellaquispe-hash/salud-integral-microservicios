package com.saludintegral.medico.dto;
import jakarta.validation.constraints.*;import java.time.LocalTime;public record HorarioRequest(@NotNull @Positive Long idMedico,@NotBlank String diaSemana,@NotNull LocalTime horaInicio,@NotNull LocalTime horaFin){}
