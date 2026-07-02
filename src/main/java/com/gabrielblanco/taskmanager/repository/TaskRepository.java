package com.gabrielblanco.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielblanco.taskmanager.model.Task;

@Repository // esta interfaz maneja el acceso a datos 
public interface TaskRepository extends JpaRepository<Task, Long> {
    /**extendemos  JpaRepository donde
     *      Task -> llama a la clase Task que apunta a la tabla tasks
     *      Long -> el tipo de dato declarado como primario para usar 
     * 
     *      todo lo que hace esta interfaz automaticamente esta documentado en
     *      BITACORA.md Día 2
     */
}
