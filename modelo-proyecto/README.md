# Proyecto base: Generación de códigos configurables

## Descripción
Este proyecto es una base para un sistema que genera códigos únicos para registros.
El número inicial del código es configurable a través de variables de entorno.

## Endpoints

- `POST /api/registros` → Genera un nuevo registro con un código único.

## Cómo correrlo con Docker

```bash
cp .env .env.local
docker-compose up --build
```
