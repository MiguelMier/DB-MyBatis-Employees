# API de Gestión de Salarios

Este repositorio contiene una API mínima para gestionar salarios de empleados en una empresa, con cinco acciones que permiten realizar diversas operaciones relacionadas con los salarios y los empleados.

<div align="center">

## Acciones

| Acción                                                   |
|:--------------------------------------------------------:|
| Obtener salario promedio anual de la empresa            |
| Obtener salario mensual de un empleado                  |
| Crear lista de salario para un empleado en un año        |
| Búsqueda paginada de empleados                          |
| Actualizar salario mensual de un empleado en un mes específico |

</div>

## Para realizar pruebas

La realización de pruebas se hará vía **Postman**, usando como base el URL:

<div align="center">

http://localhost:8080/company/

</div>

Es importante tener en cuenta que la dirección a la que se conecta la base de datos MariaDB (especificada en el archivo `application.properties`) es:

<div align="center">

jdbc:mariadb://localhost:3306/babel_ing_univ_proj_result

</div>


## Base de Datos y MyBatis

La API utiliza una base de datos MariaDB adjunta para almacenar y recuperar los datos de los empleados y sus salarios. MyBatis se utiliza como framework de persistencia para mapear objetos Java a sentencias SQL y viceversa.

### Conexión con MariaDB
Se establece una conexión con la base de datos MariaDB utilizando las siguientes credenciales:
- **Host:** localhost
- **Puerto:** 3306 (predeterminado)
- **Usuario:** root
- **Contraseña:** ***********
- **Base de datos:** babel_ing_univ_proj_result

Para configurar la conexión, asegúrese de proporcionar la información correcta en el archivo `application.properties`.

### MyBatis
MyBatis es utilizado para mapear los objetos Java a las consultas SQL correspondientes. Se definen mapeos en archivos XML que especifican cómo los objetos Java se traducen a tablas y columnas en la base de datos.

### Swagger
Se utiliza Swagger para realizar una documentación de la API, para acceder a ella, debemos lanzar la aplicación y mediante el siguiente enlace podremos ver documentación de los controladores y de los modelos:

<div align="center">

[http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

</div>

Para consultar las anotaciones: https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations

### Validaciones
Para documentar y hacer validaciones del **modelo** usamos Hybernate: https://baeldung.com/java-validation
