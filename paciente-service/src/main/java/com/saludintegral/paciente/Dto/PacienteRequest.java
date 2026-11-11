package com.saludintegral.paciente.dto;
import jakarta.validation.constraints.*; import java.time.LocalDate;
public record PacienteRequest(@NotBlank @Pattern(regexp="[0-9]{8}") String dni,@NotBlank @Size(max=100) String nombres,@NotBlank @Size(max=100) String apellidos,LocalDate fechaNacimiento,@Pattern(regexp="[MF]") String sexo,@Size(max=15) String telefono,@Size(max=200) String direccion,@Email @Size(max=100) String correo,@Pattern(regexp="[AI]") String estado) {}
