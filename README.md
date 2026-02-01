# 📅 Sistema de Gestión de Citas (Backend API)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Spring Boot](https://img.shields.io/badge/spring_boot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

> **API RESTful robusta** diseñada para gestionar el flujo completo de agendamiento de citas, control de clientes y catálogo de servicios. Desarrollada con las mejores prácticas de arquitectura limpia y validaciones avanzadas.

---

## 🚀 Características Principales

Este proyecto no es solo un CRUD, incluye lógica de negocio real y protección de datos:

* 🏗️ **Arquitectura en Capas:** Controladores, Servicios, Repositorios y DTOs bien separados.
* 🛡️ **Validaciones Avanzadas (`@Valid`):**
    * **Regex:** Nombres y teléfonos validados con expresiones regulares.
    * **Lógica de Fechas:** Validación personalizada para asegurar que la *Fecha Fin* nunca sea antes de la *Fecha Inicio*.
    * **Formatos:** Fechas limpias (`yyyy-MM-dd HH:mm`) sin la "T" ISO estándar.
* 🚦 **Manejo Global de Errores:**
    * Respuestas JSON amigables para errores 404 (Not Found) y 400 (Bad Request).
    * Captura de excepciones generales (500) para evitar trazas de error en el cliente.
* 💰 **Validación de Negocio:** Precios positivos y control de IDs.

---

## 🛠️ Tecnologías y Herramientas

* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3.x
* **Base de Datos:** H2 (Memoria) / MySQL
* **Gestión de Dependencias:** Maven
* **Validación:** Jakarta Validation (Hibernate Validator)
* **Utilidades:** Jackson (para formato de JSON)

---

## 🔌 Endpoints de la API

### 1. 👤 Clientes (`/api/clientes`)
| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `POST` | `/` | Crear un nuevo cliente (Valida email único y formato). |
| `GET` | `/{id}` | Obtener detalle de un cliente. |

### 2. 💼 Servicios (`/api/servicios`)
| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `POST` | `/` | Registrar un nuevo servicio (Valida precio > 0). |
| `GET` | `/` | Listar todos los servicios disponibles. |

### 3. 📅 Citas (`/api/citas`)
| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `POST` | `/` | Agendar cita (Valida disponibilidad y coherencia de fechas). |
| `GET` | `/{id}` | Consultar información de una cita. |

---

## 📝 Ejemplos de Uso (JSON)

### ➤ Crear una Cita (POST)
El sistema acepta un formato de fecha simplificado y humano.

```json
{
  "clienteId": 1,
  "servicioId": 2,
  "profesional": "Dr. House",
  "fechaHoraInicio": "2026-02-20 15:30",
  "fechaHoraFin": "2026-02-20 16:30",
  "estado": true
}
