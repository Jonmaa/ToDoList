# ToDoList — Proyecto completo (Backend + Frontend)

Proyecto sencillo de lista de tareas con una API REST en Spring Boot (tareas) y una interfaz en React + Tailwind (todo-ui).

## Resumen
- Backend: API REST con CRUD de tareas, base en memoria H2 y documentación Swagger. Implementación principal en [`com.todolist.tareas`](tareas/src/main/java/com/todolist/tareas).
  - Entidad: [`com.todolist.tareas.Task`](tareas/src/main/java/com/todolist/tareas/Task.java)
  - Controlador: [`com.todolist.tareas.TaskController`](tareas/src/main/java/com/todolist/tareas/TaskController.java)
  - Servicio: [`com.todolist.tareas.TaskService`](tareas/src/main/java/com/todolist/tareas/TaskService.java)
  - Repositorio: [`com.todolist.tareas.TaskRepository`](tareas/src/main/java/com/todolist/tareas/TaskRepository.java)
  - Swagger/OpenAPI: [`com.todolist.tareas.SwaggerConfig`](tareas/src/main/java/com/todolist/tareas/SwaggerConfig.java)
  - Entrypoint: [`com.todolist.tareas.TareasApplication`](tareas/src/main/java/com/todolist/tareas/TareasApplication.java)

- Frontend: SPA React creada con Create React App y Tailwind CSS.
  - App: [`App`](todo-ui/src/App.js)
  - Componentes: [`TaskForm`](todo-ui/src/components/TaskForm.js), [`TaskList`](todo-ui/src/components/TaskList.js), [`TaskItem`](todo-ui/src/components/TaskItem.js)
  - Servicios API: [`getTasks`](todo-ui/src/services/api.js), [`createTask`](todo-ui/src/services/api.js), [`updateTask`](todo-ui/src/services/api.js), [`deleteTask`](todo-ui/src/services/api.js)

## Ejecutar en desarrollo

1. Backend (Spring Boot)
   - Ir a la carpeta `tareas` y ejecutar (Windows PowerShell):
     ```
     mvnw.cmd spring-boot:run
     ```
   - La API estará en: http://localhost:8080
   - Swagger UI: http://localhost:8080/swagger-ui.html

2. Frontend (React)
   - Ir a la carpeta `todo-ui`
   - Instalar dependencias y ejecutar:
     ```
     npm install
     npm start
     ```
   - La UI estará en: http://localhost:3000
   - El frontend consume la API en `http://localhost:8080/tasks` (configurado en [`todo-ui/src/services/api.js`](todo-ui/src/services/api.js)).

## Endpoints principales
- GET /tasks — Obtener todas las tareas
- GET /tasks/{id} — Obtener tarea por id
- POST /tasks — Crear tarea (JSON: title, description)
- PUT /tasks/{id} — Actualizar tarea (title, description, completed)
- DELETE /tasks/{id} — Eliminar tarea

(implementados en [`com.todolist.tareas.TaskController`](tareas/src/main/java/com/todolist/tareas/TaskController.java))

## Estructura relevante y archivos (enlaces)
- Configuración VS Code:
  - [.vscode/settings.json](.vscode/settings.json)

- Backend (tareas):
  - Java sources:
    - [`com.todolist.tareas.Task`](tareas/src/main/java/com/todolist/tareas/Task.java)
    - [`com.todolist.tareas.TaskController`](tareas/src/main/java/com/todolist/tareas/TaskController.java)
    - [`com.todolist.tareas.TaskService`](tareas/src/main/java/com/todolist/tareas/TaskService.java)
    - [`com.todolist.tareas.TaskRepository`](tareas/src/main/java/com/todolist/tareas/TaskRepository.java)
    - [`com.todolist.tareas.SwaggerConfig`](tareas/src/main/java/com/todolist/tareas/SwaggerConfig.java)
    - [`com.todolist.tareas.TareasApplication`](tareas/src/main/java/com/todolist/tareas/TareasApplication.java)
  - Tests:
    - [tareas/src/test/java/com/todolist/tareas/TareasApplicationTests.java](tareas/src/test/java/com/todolist/tareas/TareasApplicationTests.java)

- Frontend (todo-ui):
  - [todo-ui/tailwind.config.js](todo-ui/tailwind.config.js)
  - Public:
    - [todo-ui/public/index.html](todo-ui/public/index.html)
    - [todo-ui/public/manifest.json](todo-ui/public/manifest.json)
    - [todo-ui/public/robots.txt](todo-ui/public/robots.txt)
  - Src:
    - [todo-ui/src/App.js](todo-ui/src/App.js) — [`App`](todo-ui/src/App.js)
    - [todo-ui/src/App.css](todo-ui/src/App.css)
    - [todo-ui/src/App.test.js](todo-ui/src/App.test.js)
    - [todo-ui/src/index.css](todo-ui/src/index.css)
    - [todo-ui/src/index.js](todo-ui/src/index.js)
    - [todo-ui/src/reportWebVitals.js](todo-ui/src/reportWebVitals.js)
    - [todo-ui/src/setupTests.js](todo-ui/src/setupTests.js)
    - Servicios:
      - [`getTasks`](todo-ui/src/services/api.js), [`createTask`](todo-ui/src/services/api.js), [`updateTask`](todo-ui/src/services/api.js), [`deleteTask`](todo-ui/src/services/api.js) — [todo-ui/src/services/api.js](todo-ui/src/services/api.js)
    - Componentes:
      - [`TaskForm`](todo-ui/src/components/TaskForm.js) — [todo-ui/src/components/TaskForm.js](todo-ui/src/components/TaskForm.js)
      - [`TaskList`](todo-ui/src/components/TaskList.js) — [todo-ui/src/components/TaskList.js](todo-ui/src/components/TaskList.js)
      - [`TaskItem`](todo-ui/src/components/TaskItem.js) — [todo-ui/src/components/TaskItem.js](todo-ui/src/components/TaskItem.js)

## Notas rápidas
- La base de datos H2 se reinicia en cada arranque del backend (datos en memoria).
- El frontend asume la API en http://localhost:8080; cambiar en [`todo-ui/src/services/api.js`](todo-ui/src/services/api.js) si es necesario.
- Swagger/OpenAPI está configurado por [`com.todolist.tareas.SwaggerConfig`](tareas/src/main/java/com/todolist/tareas/SwaggerConfig.java).

## Tests
- Backend: pruebas básicas en [tareas/src/test/java/com/todolist/tareas/TareasApplicationTests.java](tareas/src/test/java/com/todolist/tareas/TareasApplicationTests.java)
- Frontend: test de ejemplo en [todo-ui/src/App.test.js](todo-ui/src/App.test.js)

---

Para detalles de cada archivo, abrir los enlaces arriba listados.

## Tecnologías usadas

A continuación una explicación concisa y técnica de las tecnologías empleadas en el proyecto y su rol concreto.

Backend (tareas)
- Spring Boot
  - Rol: Framework principal para construir la API REST (controladores, servicios, configuración).
  - Uso: aplicación localizada en tareas/src/main/java/com/todolist/tareas.
- Spring Data JPA
  - Rol: Abstracción para la persistencia mediante repositorios y consultas CRUD automáticas.
  - Uso: TaskRepository para operaciones de acceso a datos.
- H2 (in-memory)
  - Rol: Base de datos en memoria para desarrollo y pruebas, sin configuración externa.
  - Uso: configurada en application.properties; los datos se pierden al reiniciar.
- Maven (mvnw / mvnw.cmd)
  - Rol: Gestión de dependencias y ejecución del proyecto Java. Se incluyen wrappers para reproducibilidad.
  - Uso: mvnw.cmd spring-boot:run en Windows.
- OpenAPI / Swagger
  - Rol: Documentación interactiva de la API y prueba manual de endpoints.
  - Uso: configuración en SwaggerConfig; UI en /swagger-ui.html.
- Java y JUnit
  - Rol: Lenguaje de implementación y framework de pruebas (tests unitarios/integración).

Frontend (todo-ui)
- React (Create React App)
  - Rol: Single Page Application para la interfaz de usuario y manejo de estado/componentes.
  - Uso: componentes en todo-ui/src/components y punto de entrada en todo-ui/src/App.js.
- Tailwind CSS + PostCSS
  - Rol: Sistema de utilidades para estilado rápido y consistente.
  - Uso: configuración en tailwind.config.js y estilos en src/index.css / App.css.
- Fetch (o axios)
  - Rol: Realizar llamadas HTTP (GET/POST/PUT/DELETE) al backend desde todo-ui/src/services/api.js.
- npm / Node.js
  - Rol: Gestión de paquetes y scripts (npm install, npm start).

Herramientas y flujo de desarrollo
- VS Code
  - Rol: Editor recomendado; contiene ajustes en .vscode si aplican.
- Git
  - Rol: Control de versiones del código en c:\git\toDoList.
- Scripts habituales
  - Backend (Windows): desde la carpeta tareas -> mvnw.cmd spring-boot:run
  - Frontend: desde la carpeta todo-ui -> npm install && npm start

Motivación de las elecciones
- Desarrollo rápido y reproducible: Spring Boot + H2 y CRA + Tailwind permiten levantar un entorno completo sin infra externa.
- Separación de responsabilidades: backend expone API REST; frontend consume la API y gestiona la UI.
- Documentación y pruebas: Swagger facilita pruebas manuales; JUnit/Jest permiten cobertura básica de regresión.
