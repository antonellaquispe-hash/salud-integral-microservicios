package com.saludintegral.medico.model;
import jakarta.persistence.*; @Entity @Table(name="especialidad") public class Especialidad {@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_especialidad") public Long idEspecialidad; @Column(nullable=false,length=100) public String nombre; @Column(length=200) public String descripcion; @Column(length=1) public String estado="A";}
