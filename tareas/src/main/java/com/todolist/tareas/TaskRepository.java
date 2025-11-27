package com.todolist.tareas;

import org.springframework.data.jpa.repository.JpaRepository;

// Extiende JpaRepository para proporcionar operaciones CRUD para la entidad Task

public interface TaskRepository extends JpaRepository<Task, Long> {

}