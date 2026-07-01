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
