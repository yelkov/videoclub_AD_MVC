DROP DATABASE IF EXISTS PELICULAS;
CREATE DATABASE IF NOT EXISTS PELICULAS;

USE PELICULAS;

DROP TABLE IF EXISTS PELICULAS;
CREATE TABLE IF NOT EXISTS PELICULAS
(
	ID INT UNSIGNED AUTO_INCREMENT NOT NULL,
    TITULO VARCHAR(50) NOT NULL,
    ACTOR VARCHAR(50) NOT NULL,
    TEMATICA VARCHAR(20) NOT NULL,
    GUION TEXT NOT NULL,
    DISPONIBLE BOOLEAN NOT NULL,
    /*****************************************/
    PRIMARY KEY (ID)
)ENGINE INNODB;

INSERT INTO PELICULAS (TITULO, ACTOR, TEMATICA, GUION, DISPONIBLE) VALUES
('Cadena Perpetua', 'Tim Robbins', 'Drama', 'Andy Dufresne, condenado injustamente, lucha por sobrevivir y encontrar esperanza en prisión.', TRUE),
('El Padrino', 'Marlon Brando', 'Acción', 'La historia de la familia Corleone y su imperio mafioso en Nueva York.', TRUE),
('El Caballero Oscuro', 'Christian Bale', 'Acción', 'Batman lucha contra el caos del Joker en Gotham City.', TRUE),
('La Lista de Schindler', 'Liam Neeson', 'Aventura', 'Oskar Schindler salva a más de mil judíos durante el Holocausto.', TRUE),
('Pulp Fiction', 'John Travolta', 'Acción', 'Las vidas de varios criminales se entrelazan en Los Ángeles.', FALSE),
('El Señor de los Anillos', 'Elijah Wood', 'Aventura', 'Frodo Bolsón debe destruir el Anillo Único para salvar el mundo.', TRUE),
('Forrest Gump', 'Tom Hanks', 'Romance', 'Forrest Gump vive una vida sorprendente y encuentra el amor en Jenny.', TRUE),
('Origen', 'Leonardo DiCaprio', 'Ciencia Ficción', 'Un grupo de ladrones roba secretos a través de los sueños.', FALSE),
('El Club de la Lucha', 'Brad Pitt', 'Acción', 'Un hombre crea un club de peleas para liberar sus frustraciones.', TRUE),
('Matrix', 'Keanu Reeves', 'Ciencia Ficción', 'Neo descubre que la realidad es una simulación creada por máquinas.', TRUE),
('Goodfellas', 'Robert De Niro', 'Acción', 'La historia de un hombre que se une a la mafia en Nueva York.', FALSE),
('Seven', 'Brad Pitt', 'Terror', 'Dos detectives siguen a un asesino que mata según los siete pecados capitales.', TRUE),
('Interstellar', 'Matthew McConaughey', 'Ciencia Ficción', 'Un grupo de astronautas viaja a través de un agujero de gusano en busca de un nuevo planeta.', TRUE),
('Gladiador', 'Russell Crowe', 'Acción', 'Maximus busca venganza en la arena del Coliseo tras la muerte de su familia.', FALSE),
('Salvad al Soldado Ryan', 'Tom Hanks', 'Aventura', 'Un grupo de soldados busca rescatar a un paracaidista en la Segunda Guerra Mundial.', TRUE),
('El Silencio de los Corderos', 'Jodie Foster', 'Terror', 'Una joven agente del FBI consulta al caníbal Hannibal Lecter para capturar a un asesino en serie.', TRUE),
('La Milla Verde', 'Tom Hanks', 'Drama', 'Un oficial de prisión se enfrenta al destino de un prisionero con poderes especiales.', TRUE),
('El Rey León', 'Matthew Broderick', 'Aventura', 'Simba regresa para reclamar su trono como rey de la Sabana.', TRUE),
('Infiltrados', 'Leonardo DiCaprio', 'Acción', 'Un policía y un criminal se infiltran en las filas del enemigo, pero ninguno sabe quién es el otro.', FALSE),
('Whiplash', 'Miles Teller', 'Drama', 'Un joven baterista enfrenta la presión extrema de su maestro en busca de la perfección.', TRUE);