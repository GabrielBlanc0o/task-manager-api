# Bitácora de Aprendizaje — Task Manager API

## 01 Julio 2026 — Día 1

- Creé mi primer proyecto Spring Boot con Spring Initializr
- Dependencias: Spring Web, Spring Data JPA, PostgreSQL Driver
- Spring Web → recibe peticiones HTTP
- Spring Data JPA → conecta Java con la base de datos
- PostgreSQL Driver → puente entre Spring y PostgreSQL
- `@SpringBootApplication` → punto de entrada de la app
- `SpringApplication.run()` → levanta el servidor en puerto 8080

Creamos 3 carpetas en nuestra ruta del proyecto en taskmanager.

model/ -> Aqui almacenamos la estructura de nuestro proyecto, atributos necesarios para rellenar campos o ser mas tarde utilizaremos , NADA de logica.

service/ -> Aqui si tenemos la logica del negocio, si creamos una tarea que pasa? , si la completamos o si la borramos, aqui esta el "cerebro de nuestra aplicacion".

controller/ -> aqui viven  los endpoints , esta es la puerta de entrada a las peticiones HTTP, le pide al service que haga algo y devuelva la respuesta

> Veamos el flujo de estos 3 de manera mas didactica

HTTP REQUEST --> Controller --> Service --> Model --> Base de Datos

En el path, src/main/java/com/gabrielblanco/taskmanager/model

Inicializamos la estructura del proyecto en el archivo >>> Task.java

Valores necesarios:

@Entity --> Le dice a JPA que esta clase es es una tabla EN LA BASE DE DATOS

@Table(name = "tasks") --> esto define el nombre exacto en la tabla en

PostgreSQL, sin esto la tabla se llamaria como la clase en mayuscula , esto la hace

mas explicita y limpia

@Id --> le dice a JPA cual campo es la llave primaria de la tabla

@GeneratedValue(strategy = GenerationType.IDENTITY)

--> le dice que el id se genera automaticamente en la base de datos, de forma

incremental, yo nunca le asigno el id de una tarea manualmente, eso lo hace la base de datos sola.


## 02 Julio 2026 — Día 2

* Creamos 'TaskRepository.java' en la carpeta 'repository/'

- '@Repository' -> le dice a Spring que esta interfaz maneja acceso a datos


- Extendemos 'JpaRepository<Task,Long>' donde:
  - 'Task' -> es la entidad que maneja, apunta a la tabla tasks
  - 'Long' -> el tipo de dato del ID, debe coincidir con el declarado en Task.java
-
- La interfaz esta vacia pero Spring genera automaticamente:
  - 'findAll()' -> trae todas las tareas
  - 'findById(id)' -> trae una tarea por id
  - 'save(task)' -> crea o actualiza una tarea
  - 'deleteById(id)' -> borra una tarea
- Esto que en Java puro tomaria horas con SQL, JpaRepository lo da gratis
