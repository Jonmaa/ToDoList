# API de Gestión de Tareas

API REST para gestionar tareas construida con **Spring Boot**, con **CRUD completo** y documentación interactiva mediante **Swagger/OpenAPI**.

---

## 🛠 Tecnologías usadas

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 Database (base de datos en memoria)
- Springdoc OpenAPI (Swagger UI)
- Maven

---

## 🚀 Cómo correr la aplicación

1. Clona el repositorio:

```bash
git clone <URL_DEL_REPO>
cd toDoList/tareas
```

2. Ejecuta la aplicación (Windows PowerShell):

```powershell
mvnw.cmd spring-boot:run
```

La API estará disponible en:

```
http://localhost:8080
```

La documentación Swagger estará en:

```
http://localhost:8080/swagger-ui.html
```

---

## 📋 Endpoints disponibles

| Método | URL | Descripción |
|--------|-----|-------------|
| GET | `/tasks` | Obtener todas las tareas |
| GET | `/tasks/{id}` | Obtener una tarea por ID |
| POST | `/tasks` | Crear una nueva tarea |
| PUT | `/tasks/{id}` | Actualizar una tarea existente |
| DELETE | `/tasks/{id}` | Eliminar una tarea por ID |

---

## 📌 Ejemplo de JSON para crear tarea

```json
{
  "title": "Estudiar Spring Boot",
  "description": "Terminar la API de tareas"
}
```

El `id` se genera automáticamente y no debe enviarse al crear la tarea.

---

## 🔧 Ejemplo de JSON para actualizar tarea

```json
{
  "title": "Estudiar Spring Boot",
  "description": "Actualizar la descripción",
  "completed": true
}
```

---

## 💡 Notas

- La base de datos H2 se reinicia cada vez que se reinicia la aplicación.
- Swagger UI permite probar todos los endpoints directamente desde el navegador.
- El campo `id` es solo de lectura y no debe enviarse en POST.

---

## 📂 Estructura del proyecto

```
src/
 └── main/
      ├── java/com/todolist/tareas
      │    ├── Task.java
      │    ├── TaskRepository.java
      │    ├── TaskService.java
      │    ├── TaskController.java
      │    └── SwaggerConfig.java
      └── resources/
           └── application.properties
```
