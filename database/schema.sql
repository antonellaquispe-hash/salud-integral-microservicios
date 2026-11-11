-- Cada servicio gestiona su propia base. Las referencias entre servicios son IDs y se validan por HTTP.
USE bd_paciente;
CREATE TABLE IF NOT EXISTS paciente(id_paciente BIGINT AUTO_INCREMENT PRIMARY KEY,dni VARCHAR(8) NOT NULL UNIQUE,nombres VARCHAR(100) NOT NULL,apellidos VARCHAR(100) NOT NULL,fecha_nacimiento DATE,sexo CHAR(1),telefono VARCHAR(15),direccion VARCHAR(200),correo VARCHAR(100),estado CHAR(1) DEFAULT 'A');

USE bd_medico;
CREATE TABLE IF NOT EXISTS especialidad(id_especialidad BIGINT AUTO_INCREMENT PRIMARY KEY,nombre VARCHAR(100) NOT NULL,descripcion VARCHAR(200),estado CHAR(1) DEFAULT 'A');
CREATE TABLE IF NOT EXISTS medico(id_medico BIGINT AUTO_INCREMENT PRIMARY KEY,cmp VARCHAR(20) NOT NULL UNIQUE,nombres VARCHAR(100) NOT NULL,apellidos VARCHAR(100) NOT NULL,telefono VARCHAR(15),correo VARCHAR(100),id_especialidad BIGINT NOT NULL,estado CHAR(1) DEFAULT 'A',CONSTRAINT fk_medico_especialidad FOREIGN KEY(id_especialidad) REFERENCES especialidad(id_especialidad));
CREATE TABLE IF NOT EXISTS horario_medico(id_horario BIGINT AUTO_INCREMENT PRIMARY KEY,id_medico BIGINT NOT NULL,dia_semana VARCHAR(15),hora_inicio TIME,hora_fin TIME,CONSTRAINT fk_horario_medico FOREIGN KEY(id_medico) REFERENCES medico(id_medico));

USE bd_cita;
CREATE TABLE IF NOT EXISTS cita(id_cita BIGINT AUTO_INCREMENT PRIMARY KEY,fecha DATE NOT NULL,hora TIME NOT NULL,id_paciente BIGINT NOT NULL,id_medico BIGINT NOT NULL,motivo VARCHAR(300),estado VARCHAR(20) DEFAULT 'PROGRAMADA');
CREATE TABLE IF NOT EXISTS atencion(id_atencion BIGINT AUTO_INCREMENT PRIMARY KEY,id_cita BIGINT NOT NULL UNIQUE,diagnostico TEXT,tratamiento TEXT,observaciones TEXT,fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,CONSTRAINT fk_atencion_cita FOREIGN KEY(id_cita) REFERENCES cita(id_cita));
