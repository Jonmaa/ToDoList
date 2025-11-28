package com.todolist.tareas;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class TaskEntityTests {

    @Test
    void entityFieldsAccessorsViaReflection() {
        Task t = new Task();

        // Intentamos asignar campos por reflexión para evitar depender de nombres concretos de getters/setters.
        setField(t, "title", "Mi tarea");
        setField(t, "description", "Descripción de la tarea");
        setField(t, "completed", true);

        assertEquals("Mi tarea", getField(t, "title"));
        assertEquals("Descripción de la tarea", getField(t, "description"));
        assertEquals(Boolean.TRUE, getField(t, "completed"));
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
