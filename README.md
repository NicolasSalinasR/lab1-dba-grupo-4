# RES-Q

### Creación base de datos

1.- crear una base de datos en pg admin 4 con el nombre "bdalab1"
2.- copiar el codigo que esta en el archivo "script creacion tablas lab1 bda.sql"
3.- el codigo copiado anteriormente ejecutarlo en una consola dentro de pgadmin en la base de datos creada en el paso 1

### Configuración de los parametros

1.- Ir al archivo de application.properties en la ruta Backend\src\main\resources\application.properties
2.- Cambiar la ip con el puerto en la propiedad spring.datasource.url
3.- Agregar usuario en la propiedad spring.datasource.username
4.- Agregar contraseña en la propiedad spring.datasource.password

### Ejecución del proyecto

#### Backend

Ejecute la función main del archivo \Backend\src\main\java\Backend_Voluntarios\Backend\BackendApplication.java

#### Frontend

Ejecute el comando npm run dev en la carpeta \Frontend
