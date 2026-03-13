# Turnos API

API REST para gestion de turnos medicos con Spring Boot + MySQL.

## Checklist de esta guia
- [x] Prerrequisitos
- [x] Como levantar la app con Docker Compose
- [x] URLs principales (Swagger y API)
- [x] Endpoints disponibles

## Stack
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL 8.4
- Docker / Docker Compose

## Prerrequisitos
Tener instalado:
- Docker
- Docker Compose (plugin `docker compose`)

## Como correr la app
Desde la raiz del proyecto (`turnos`):

```bash
docker compose up --build
```

Esto levanta:
- `db-turnos` (MySQL) en el puerto `3307`
- `turnos-api` en el puerto `8081`

## URLs importantes
- Swagger UI: http://localhost:8081/swagger-ui/index.html
- URL base API: http://localhost:8081/api/turnos

## Endpoints de la API
Base: `http://localhost:8081/api/turnos`

- `GET /` -> lista todos los turnos
- `GET /{id}` -> obtiene un turno por ID
- `POST /` -> crea un turno
- `PUT /{id}` -> actualiza un turno
- `DELETE /{id}` -> elimina un turno

Ejemplo de body para crear/actualizar:

```json
{
  "IdPaciente": 1,
  "description": "Control clinico",
  "date": "2026-03-13"
}
```

## Variables de entorno (opcionales)
Si queres sobreescribir valores por defecto de `docker-compose.yml`:

- `MYSQL_DATABASE` (default: `turnos`)
- `MYSQL_USER` (default: `agus`)
- `MYSQL_PASSWORD` (default: `admin`)
- `MYSQL_ROOT_PASSWORD` (default: `rootadmin`)

Ejemplo:

```bash
MYSQL_USER=miusuario MYSQL_PASSWORD=miclave docker compose up --build
```

## Detener servicios
```bash
docker compose down
```

Para borrar volumen de MySQL tambien:

```bash
docker compose down -v
```

