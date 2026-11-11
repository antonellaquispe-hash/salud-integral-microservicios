# Salud Integral: microservicios de citas

Solución de la actividad final del laboratorio adjunto: Pacientes (8081), Médicos (8082) y Citas (8083), cada uno con MySQL propio. Citas comprueba por HTTP que el paciente y el médico existen antes de registrar. No hay claves foráneas entre bases de servicios.

## Requisitos e inicio
JDK 25, Maven 3.6.3+, Docker Desktop. El documento pide Spring Boot 4.1.0; se fija Spring Boot 4.1.2 estable y compatible con Java 25.

Desde esta carpeta:

    docker compose up -d
    mvn -f paciente-service/pom.xml spring-boot:run
    mvn -f medico-service/pom.xml spring-boot:run
    mvn -f cita-service/pom.xml spring-boot:run

Ejecute cada Maven en una terminal. El perfil dev es el predeterminado; prod se activa con -Dspring-boot.run.profiles=prod y variables DB_URL, DB_USER, DB_PASSWORD, PORT, PACIENTE_URL, MEDICO_URL. Salud: /actuator/health.

## API
Pacientes: CRUD en /api/pacientes. Requiere DNI de 8 dígitos, nombres y apellidos.
Médicos: CRUD en /api/medicos; especialidades: GET y POST en /api/especialidades; horarios: CRUD básico en /api/horarios. CMP y especialidad son obligatorios.
Citas: POST/GET /api/citas, GET /api/citas/{id}, PATCH /api/citas/{id}/estado, DELETE /api/citas/{id} (cancelación lógica). Estados: PROGRAMADA, CONFIRMADA, ATENDIDA, CANCELADA.

Errores HTTP: 400 validación, 404 inexistente, 409 duplicado/integridad, 503 dependencia remota fuera de servicio, 500 inesperado. DTOs validados y errores JSON.

## Prueba rápida
1. POST /api/especialidades { "nombre":"Medicina general" }
2. POST /api/medicos { "cmp":"CMP-12345","nombres":"Ana","apellidos":"Torres","idEspecialidad":1 }
3. POST /api/pacientes { "dni":"12345678","nombres":"Juan","apellidos":"Pérez" }
4. POST /api/citas { "fecha":"2026-12-01","hora":"09:30:00","idPaciente":1,"idMedico":1,"motivo":"Control" }

Postman: importar postman/Salud-Integral.postman_collection.json.

## Conclusiones
1. Servicios autónomos dividen responsabilidades y permiten despliegues independientes.
2. Cada servicio es dueño de sus datos; los identificadores y HTTP reducen el acoplamiento entre bases.
3. La verificación remota de paciente y médico protege el flujo de citas y hace explícita la dependencia.
4. DTO y validación uniforme hacen claros los contratos y permiten responder correctamente ante errores.
5. Puertos, perfiles y bases separados permiten adaptar la configuración a desarrollo y producción.

La estructura de cada aplicación separa Controller, Model, Dto, Exception, Repository y Services.
