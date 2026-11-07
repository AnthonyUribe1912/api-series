# API REST de Catálogo de Series de Televisión

**Estudiante:** Anthony Hernan Uribe Guachamin  
**Institución:** Pontificia Universidad Católica del Ecuador (PUCE Tec)  
**Materia:** Ciberseguridad / Desarrollo de APIs  

## Instrucciones de ejecucion 
1. git clone [https://github.com/AnthonyUribe1912/api-series.git](https://github.com/AnthonyUribe1912/api-series.git)

2. cd apiseries

3. ./mvnw spring-boot:run

URL Base de la API: http://localhost:8080/api/series

Consola H2: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:seriesdb

User Name: sa

Password: (vacío)
## Descripción
API REST completa desarrollada con Spring Boot, Spring Data JPA y base de datos H2 en memoria para gestionar un catálogo de series de televisión realizando las operaciones CRUD básicas.

## Tecnologías Utilizadas
* Java 17
* Spring Boot 3.x
* Spring Data JPA
* H2 Database (In-Memory)
* Lombok
* Maven

## Estructura del Proyecto
```text
src/main/java/com/puce/apiseries/
├── controller/
│   └── SerieController.java    # Controladores REST
├── models/
│   └── Serie.java              # Entidad JPA
├── repository/
│   └── SerieRepository.java     # Repositorio JPA
└── service/
    └── SerieService.java        # Lógica de negocio