# API-SandL
API REST to Salas and Life website

## Configurar Base de datos

Parara fines de pruebas, es posible ejecutar un servidor de base de datos utilizando docker,
por ejemplo:

```
ntory@flavor:~/Escritorio/CC/20241/Technologies-for-internet-dev/API-SandL$ docker-compose up -d
[+] Building 0.0s (0/0)
[+] Running 1/1
 ✔ Container api-sandl-postgres-1  Started       
```

Para verificar que se ha creado nuestro contenedor usado para neustra DB solo hay que ejecutar:
```                                                                                 5.1s 
ntory@flavor:~/Escritorio/CC/20241/Technologies-for-internet-dev/API-SandL$ docker ps
CONTAINER ID   IMAGE                COMMAND                  CREATED         STATUS         PORTS                                         NAMES
14a415188143   postgres:14-alpine   "docker-entrypoint.s…"   8 seconds ago   Up 2 seconds   0.0.0.0:31123->5432/tcp, :::31123->5432/tcp   api-sandl-postgres-1

```

### Postgrest

- Como estamos ocupando postgrest para el proyecto: Para conectarse a nuestro contenedor basta ejecutar:
	- sudo docker exec -it api-sandl-postgres-1 bash
	- psql -h localhost -U main -d SandL -p 32124
```
ntory@flavor:~/Escritorio/CC/20241/Technologies-for-internet-dev/API-SandL$ psql -h localhost -U main -d SandL -p 32124
Contraseña para usuario main: 
psql (15.5 (Debian 15.5-0+deb12u1), servidor 14.9)
Digite «help» para obtener ayuda.

SandL=# exit
```
	-
```
asd
```

También se puede utilizar cualquier otro servidor que al que se tenga acceso, solo hay que
actualizar los parámetros de conexión en el archivo application.properties.

La creación de la base de datos es manejada por JPA, por lo que la creación de las tablas y vaciado es automático.  

## Levantar el proyecto
Para ejecutar el proyecto solo basta con ejecutar desde la raíz:
```
./mvnw spring-boot:run
```

## Actualizar el Proyecto despues de agregar una nueva dependencia

Una vez que haya agregado las dependencias necesarías de Java de MySQL Connector a su archivo pom.xml, debemos actualizar el proyecto para descargar la biblioteca. Puede hacerlo ejecutando el siguiente comando en la terminal.

```
./mvnw clean install
```

## Dependecias usadas:

- spring-boot-starter-data-jpa
- spring-boot-starter-validation
- spring-boot-starter-parent
- spring-boot-starter-web
- spring-boot-devtools
- spring-boot-starter-test
- lombok
- spring-boot-starter-data-jpa
- postgresql
- spring-boot-starter-validation
- spring-boot-maven-plugin
- maven-compiler-plugin