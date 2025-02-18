# Readme
## Instrucciones de Instalacion
El micro servicio se encuentra desplegado en una instancia de AWS en la siguiente direccion:
* http://35.168.238.21:8001

El codigo fuente esta a dispocision en:
* https://github.com/ELopez2018/franchises

### Puede descargarlo con el siguiente comando:
```
git clone https://github.com/ELopez2018/franchises.git
```
## DOCKER EN AMBIENTES WINDOWS
### Para levantarlo localmente debe instalar docker  desktop y ejecutar el siguente comando en la raiz del proyecto donde esta el archivo docker-compose.yml:
```
docker-compose up  -d 
```
### Para bajarlo debe ejecutar el siguente comando en la raiz del proyecto donde esta el archivo docker-compose.yml:
```
docker-compose down
```

Recuerde  configurar la base de datos en el archivo src/main/resources/application.yaml recuerde cambiar por su ip local, ademas el puerto donde arranca el sistema cambielo en PORT: 8081
```
url: jdbc:postgresql://${DB_HOST:192.168.1.5}:${DB_PORT:5532}/${DB_DATABASE:franchises_db}
```

Este micro servicio, esta hecho en Java Spring Boot 3.4 Java 17 y esta dockerizado al levantar el ms localmente se desplegara el microservicio y ademas la base de datos local. Si necesita probar la base de datos en la nube debe apuntarla de esta forma:
```
url: jdbc:postgresql://${DB_HOST:35.168.238.21}:${DB_PORT:5540}/${DB_DATABASE:franchises_db}
```
