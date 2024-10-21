CREATE DATABASE my_database;
USE my_database;
CREATE TABLE usuarios (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          usuario VARCHAR(30),
                          contraseña VARCHAR(40)
);
INSERT INTO usuarios (usuario, contraseña) VALUES ('juanperez', 'password123');
INSERT INTO usuarios (usuario, contraseña) VALUES ('mariagonzalez', 'mypassword');
CREATE TABLE peliculas(
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          titulo VARCHAR(50),
                          genero VARCHAR(50),
                          año INT,
                          descripcion VARCHAR(200),
                          director VARCHAR(50)
);
INSERT INTO peliculas (titulo, genero, año, descripcion, director) VALUES ('Origen ', 'Sci-Fi', 2010, 'Un ladrón que roba secretos corporativos a través del uso de la tecnología de compartir sueños recibe una oportunidad para borrar su historial criminal.', 'Christopher Nolan');
INSERT INTO peliculas (titulo, genero, año, descripcion, director) VALUES ('Matrix', 'Acción', 1999, 'Un hacker de ordenadores aprende de rebeldes misteriosos sobre la verdadera naturaleza de su realidad y su papel en la guerra contra sus controladores.', 'Lana Wachowski');
INSERT INTO peliculas (titulo, genero, año, descripcion, director) VALUES ('Interstellar', 'Sci-Fi', 2014, 'Un equipo de exploradores viaja a través de un agujero de gusano en el espacio en un intento de asegurar la supervivencia de la humanidad.', 'Christopher Nolan');
INSERT INTO peliculas (titulo, genero, año, descripcion, director) VALUES ('Star Wars: Episodio IV - Una nueva esperanza', 'Sci-Fi', 1977, 'Un joven granjero se une a una rebelión contra un imperio galáctico tiránico.', 'George Lucas');
CREATE TABLE copias(
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       id_pelicula INT,
                       id_usuario INT,
                       estado VARCHAR(20),
                       soporte VARCHAR(20),
                       FOREIGN KEY (id_pelicula) REFERENCES peliculas(id),
                       FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);
INSERT INTO copias (id_pelicula, id_usuario, estado, soporte) VALUES (1, 1, 'Bueno', 'DVD');
INSERT INTO copias (id_pelicula, id_usuario, estado, soporte) VALUES (1, 1, 'Bueno', 'Blu-ray');
INSERT INTO copias (id_pelicula, id_usuario, estado, soporte) VALUES (2, 2, 'Dañado', 'DVD');
INSERT INTO copias (id_pelicula, id_usuario, estado, soporte) VALUES (3, 1, 'Bueno', 'Blu-ray');
INSERT INTO copias (id_pelicula, id_usuario, estado, soporte) VALUES (4, 2, 'Bueno', 'DVD');
INSERT INTO copias (id_pelicula, id_usuario, estado, soporte) VALUES (4, 1, 'Bueno', 'Blu-ray');