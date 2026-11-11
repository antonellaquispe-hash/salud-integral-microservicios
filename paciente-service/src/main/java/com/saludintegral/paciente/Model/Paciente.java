package com.saludintegral.paciente.model;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="paciente",uniqueConstraints=@UniqueConstraint(columnNames="dni"))
public class Paciente { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_paciente") public Long idPaciente; @Column(nullable=false,unique=true,length=8) public String dni; @Column(nullable=false,length=100) public String nombres,apellidos; public LocalDate fechaNacimiento; public String sexo,telefono,direccion,correo; @Column(length=1) public String estado="A"; }
