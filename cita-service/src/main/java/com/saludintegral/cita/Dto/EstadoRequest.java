package com.saludintegral.cita.dto;
import jakarta.validation.constraints.*;import com.saludintegral.cita.model.EstadoCita;public record EstadoRequest(@NotNull EstadoCita estado){}
