package com.saludintegral.paciente.repository;
import org.springframework.data.jpa.repository.JpaRepository; import com.saludintegral.paciente.model.Paciente; public interface PacienteRepository extends JpaRepository<Paciente,Long>{boolean existsByDni(String dni);}
