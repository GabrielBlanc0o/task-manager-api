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

increm  ental, yo nunca le asigno el id de una tarea manualmente, eso lo hace la base de datos sola.

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

### Nuevo tema, Creacion de nuestro primer servicio!!! service/TaskService.java

Primero que todo en la ruta de nuestro proyecto en el apartado especial para servicio lo que vamos hacer van a ser los metodos para que nuestro servicio use los metodos de JpaRepository , por eso aparte importamos el model Task y repository Task, task creo nuestra tabla  y tiene la variable que identifica todo como nuestra llave primaria que sera el Id, y con su constructor para instanciar y tambien los metodos setter y getters para las variables que usaremos.

TaskRepository simplemente es el puente entre una interfaz publica y JpaRepository usando de atriutos a task y el metodo LONG, importante!! especificando esto Long es el dato que se usara para las consultas (Osea nuestro Id) , no va nada dentro.

**#### Que va dentro de nuestro Servicio?**

Primero el paquete , tambien usaremos listas, y dos importaciones llamando a la tarea modelo y al repositorio

- Declaramos esta clase como servicio
  - variable para instanciar taskRepository

nuestro constructor parametrizado para llamar a taskRepository, como pensamos no podemos instanciar taskRepository como un objeto porque no es una clase es una interfaz por eso esta como un "variable".

Creamos 4 metodos  , el primero de tipo Lista y q usa a Task por sus atributos variables, para obtener todas las tareas con el metodo q nos da Spring ".findAll()" , de tipo lista para mostrar todo,  para crear tareas seria de tipo Task tanto el tipo del metodo como el parametro de entrada , con taskRepository para instanciar el metodo .save() y dentro la variable q recibira el dato a guardar 

El metodo mas complejo entre "" , es para marcar una tarea como completada, de tipo Task y recibe el id osea la llave primaria para marcarla como completada, instanciamos la clase Task como objeto,  y junto a los metodos de spring gracias a la variable taskRepository y el metodo .findById() y la variable de entrada de el metodo , junto a .orElseThrow(() -> new RuntimeException("Tarea no encontrada")); esto lo que hace es que el metodo actua como un condicional ya que si encuentra el id lo busca y Ok, si no arroja esa excepcion , si no se cumple esa excepcion la variable del objeto mas el metodo .setCompleted(true) se marca con el setter como true, y devuelve con taskRepository y el metodo .save() la variable q recibio si existe

El ultimo metodo no devuelve nada solo procesa, es para eliminar tareas , solo busca por el Id y con el metodo spring .deleteById() mas el id lo borra, aqui quizas podriamos tambien agregar condicional , por ahora no.
