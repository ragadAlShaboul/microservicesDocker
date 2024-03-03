FROM mysql:latest

   ENV   MYSQL_ROOT_PASSWORD: root
   ENV   MYSQL_DATABASE: users
   ENV   DATABASE_PORT: 3307
   ENV   MYSQL_USER : ragad
   ENV   MYSQL_PASSWORD: 123
   ENV   DATABASE_HOST: docker


COPY init.sql /docker-entrypoint-initdb.d/
