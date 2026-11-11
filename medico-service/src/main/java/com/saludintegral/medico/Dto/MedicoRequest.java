package com.saludintegral.medico.dto;
import jakarta.validation.constraints.*; public record MedicoRequest(@NotBlank String cmp,@NotBlank @Size(max=100) String nombres,@NotBlank @Size(max=100) String apellidos,String telefono,@Email String correo,@NotNull @Positive Long idEspecialidad,@Pattern(regexp="[AI]") String estado){}
