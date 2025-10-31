
#  Instalación y ejecución


Frontend:
```
cd frontend
npm install
npm run dev
```

Backend - ejecución en VSC, o:
```
cd backend
./mvnw clean package
./mvnw spring-boot:run
```

Requiere base de datos MySQL o MariaDB. 'script.sql' contiene los statements para la inserción de datos. Importante:
- La base de datos 'sosdrink_db' ya debe existir. `CREATE DATABASE sosdrink_db;`
- Las tablas son generadas por el aplicativo backend; este debe ejecutarse antes de ejecutar el script.

**PORTS: Frontend 5173, Backend 8080**
