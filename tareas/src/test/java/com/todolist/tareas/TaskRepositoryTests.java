package com.todolist.tareas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskRepositoryTests {
    @Autowired
    private TaskRepository taskRepository;

    @Test
    void saveAndFindById() {
        Task task = new Task();
        setField(task, "title", "Repo test");
        setField(task, "description", "Prueba de persistencia");
        setField(task, "completed", false);

        Task saved = taskRepository.save(task);
        assertNotNull(saved, "Objeto guardado no debe ser nulo");
        assertNotNull(getId(saved), "ID generado no debe ser nulo");

        Optional<Task> found = taskRepository.findById(getId(saved));
        assertTrue(found.isPresent(), "Debería encontrarse la tarea por id");
        assertEquals("Repo test", getField(found.get(), "title"));
    }

    private static void setField(Object obj, String fieldName, Object value) {
        try {
            Field f = obj.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            f.set(obj, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("No se pudo acceder al campo '" + fieldName + "': " + e.getMessage());
        }
    }

    private static Long getId(Task task) {
        try {
            Field f = Task.class.getDeclaredField("id");
            f.setAccessible(true);
            return (Long) f.get(task);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("No se pudo leer el campo 'id': " + e.getMessage());
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T getField(Object obj, String fieldName) {
        try {
            Field f = obj.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            return (T) f.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("No se pudo leer el campo '" + fieldName + "': " + e.getMessage());
            return null;
        }
    }
}
