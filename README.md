<h1 align="center">appHumanResources</h1>

<p align="center">Aplicacion pensada para reclutadores, en este microservicio se puede acceder a una lista de aspirantes ficticios obtenidos de la api JSONPlaceholder, se los puede contratar, asignarles un sueldo con un aumento establecido de cada 6 meses, desvincular un empleado, actualizar empleados, ver la lista completa de empleados y filtrarlos por id</p>

## Links

- [JSONPlaceholder](https://jsonplaceholder.typicode.com/)

## Tecnologias utilizadas

- PostgreSQL
- Java 17
- Git

## Instalacion

Para comenzar es necesario clonar el repositorio, para eso usamos git: `git clone <url-repositorio>`.
Luego nos dirigimos a la carpeta `src/main/resources` y abrimos con PostgreSQL el archivo llamado `scripthumanresources.script`.
<br>Abrimos el archivo y seguimos paso a paso ejecutando cada instruccion.
<br><br>
Luego vamos al archivo `application.properties` ubicada tambien en `src/main/resources` y actualizamos con nuestras credenciales de la base de datos los siguientes campos:
<br>

### `spring.datasource.username = postgres`
### `spring.datasource.password = root`

La app utiliza el puerto 8081, esto tambien puede cambiarse desde `application.properties`.
<br>
### `server.port = 8081`

Para finalizar levantamos el proyecto y usamos la herramienta Postman (opcional) para probar nuestros metodos Http. En la carpeta `src/main/resources` hay una collection de postman llamada `RecursosHumanos.postman_collection`

## Author

**Yair Alejandro Fuertes**

- [Profile](https://github.com/AlejandroFuertes "Alejandro Fuertes")
- [LinkedIn](https://www.linkedin.com/in/afuertes96/ "Yair Alejandro Fuertes")
