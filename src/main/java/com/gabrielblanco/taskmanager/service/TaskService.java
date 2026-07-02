package com.gabrielblanco.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gabrielblanco.taskmanager.model.Task;
import com.gabrielblanco.taskmanager.repository.TaskRepository;

@Service // declaramos la clase como servicio
public class TaskService {
    // primera variable sin modificacion instanciando a la clas TaskRepository
    private final TaskRepository taskRepository;

    // constructor parametrizado con parametro de entrada a la clase del Repository
    //inyeccion de dependencias
    public TaskService (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // una lista de tipo Task llamada getAllTasks q retorna todas las entidades de la Lista
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    // para crear la tarea creamos de tipo Task un metodo llamado createTask
    // que reciba de entrada un atributo de la clase Task
    // y devuelva de la clase TaskRepository con el metodo .save() la tarea q reciba
    // la guarde , todo esto es gracias a Spring
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    /* esta es para marcar si esta completada la tarea , de tipo task igual
    y con un atributo de entrada con el id de tipo long
    luego instanciamos la clase task con taskRepository para buscar por Id , y si no
    ahi mismo soltar una excepcion de tipo runtime para decir que no se encontro 
    usando el metodo .orElseThrow , si se encuentra usar el nombre de la clase instanciada creada
    al objeto y marcarla como completada con el setter de la clase Task y de estado true
    devolvemos con taskrepository y el metodo save para guardar si la excepcion es falsa  */
    public Task completeTask(Long id) {
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        task.setCompleted(true);
        return taskRepository.save(task);
    }

    // a diferencia este metodo que del de crear la tarea este no rtorna nada
    // solo aplica cambios , tambien recibe un tipo de dato unico de id de tipo long
    // y usa el metodo .deleteById(variable) para eliminarlo , todo gracias a spring
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());
        return taskRepository.save(task);
    }
}
