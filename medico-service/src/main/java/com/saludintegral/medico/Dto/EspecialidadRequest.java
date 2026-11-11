package com.saludintegral.medico.dto;
import jakarta.validation.constraints.*; public record EspecialidadRequest(@NotBlank @Size(max=100) String nombre,@Size(max=200) String descripcion,@Pattern(regexp="[AI]") String estado){}
