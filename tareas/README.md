# tareas — Backend

Breve guía para ejecutar el backend (Spring Boot) y los tests JUnit desde Windows PowerShell.

**Requisitos**
- JDK 17+ instalado y disponible en `PATH`.
- No es necesario instalar Maven globalmente: se usa el wrapper (`mvnw.cmd`).

**Ejecutar la aplicación (desarrollo)**
Desde PowerShell, situarse en la carpeta `tareas` y ejecutar:

```powershell
.\mvnw.cmd spring-boot:run
```

La API arrancará por defecto en `http://localhost:8080`.

**Ejecutar los tests JUnit**
Para ejecutar todos los tests unitarios/integración desde PowerShell:

```powershell
.\mvnw.cmd test
```

O con salida de depuración si necesitas más información:

```powershell
.\mvnw.cmd clean test -e
```

Los tests de ejemplo se encuentran en `src/test/java/com/todolist/tareas/`.

**Notas rápidas**
- Si el IDE (VS Code) no detecta dependencias o muestra errores de imports, recarga el workspace Java: `Java: Clean the Java language server workspace` y luego `Developer: Reload Window`.
- Swagger UI (si está configurado) suele estar en `http://localhost:8080/swagger-ui.html`.

