# REST CRUD API con Spring Boot, Mysql, JPA and Hibernate DE EMPLEADOS INVEX

## Steps to Setup

**1. Clona la aplicacion**

```bash
https://github.com/erikdjent/MICROSERVICE-EMPLEADOS-INVEX.git
```

**2. Crea la base de datos Mysql**
```bash
create database empleados_invex
```

**3. Cambia tu usuario y contraseña despues de la instalacion**

+ abre `src/main/resources/application.properties`

+ cambia `spring.datasource.username` y `spring.datasource.password` despues de la instalacion de Mysql

**4. Construye y corre la app utilizando maven**

```bash
mvn package
java -jar target/EmpleadosApi-0.0.1-SNAPSHOT.jar

```

Alternativamente puedes correr la app sin el empaquetado usando -

```bash
mvn spring-boot:run
```

La app sera iniciada en <http://localhost:8080>.

## Explora Rest APIs

La app contiene los siguientes CRUD APIs.

    GET /api/getEmpleados
    
    DELETE /api/deleteEmpleado/{userId}
    
    PATCH /api/updateEmpleados
    
    POST /api/saveEmpleados

    
## CURL POSTMAN

curl --location 'http://localhost:8080/api/getEmpleados'

curl --location --request DELETE 'http://localhost:8080/api/deleteEmpleado?id=64'

curl --location --request PATCH 'http://localhost:8080/api/updateEmpleados' \
--header 'Content-Type: application/json' \
--data '    {
        "id": 10,
        "primerNombre": "PRUEBA",
        "segundoNombre": "PRUEBA",
        "primerApellido": "PRUEBA",
        "segundoApellido": "PRUEBA",
        "edad": 49,
        "sexo": "FEMENINO",
        "fechaNacimiento": "2024-05-07T06:00:00.000+00:00",
        "puesto": "PRUEBA"
    }'
    
    
curl --location 'http://localhost:8080/api/saveEmpleados' \
--header 'Content-Type: application/json' \
--data '[
    {
        "id": null,
        "primerNombre": "ERIK",
        "segundoNombre": "GUSTAVO",
        "primerApellido": "VELAZQUEZ",
        "segundoApellido": "PALENCIA",
        "edad": 30,
        "sexo": "MASCULINO",
        "fechaNacimiento": "1994-03-08T06:00:00.000+00:00",
        "puesto": "DESARROLLADOR"
    },
    {
        "id": null,
        "primerNombre": "PRUEBA2",
        "segundoNombre": "PRUEBA2",
        "primerApellido": "PRUEBA2",
        "segundoApellido": "PRUEBA2",
        "edad": 49,
        "sexo": "FEMENINO",
        "fechaNacimiento": "2024-05-07T06:00:00.000+00:00",
        "puesto": "PRUEBA2"
    }
]'