CREATE TABLE articles (
	 articleId SERIAL PRIMARY KEY,
	 title VARCHAR(200) NOT NULL,
	 category VARCHAR(100) NOT NULL
);

SELECT * FROM articles;

INSERT INTO articles VALUES (1,'Sprint', 'Backend'); 
INSERT INTO articles VALUES (2,'Sprintboot', 'Frontend');
INSERT INTO articles VALUES (3,'Sprintbootrest', 'database');


CREATE TABLE COLEGIO (
	 codigo_id SERIAL PRIMARY KEY,
	 nit             INT  NOT NULL,
	 nombre          VARCHAR(200) NOT NULL,
         codigo_colegio  INT NOT NULL,
         codigo_dane  	 INT NOT NULL,
	 direccion       VARCHAR(100) NOT NULL,
	 telefono        VARCHAR(20) NOT NULL,
	 fini_fiscal     DATE NOT NULL,
	 ffin_fiscal     DATE NOT NULL,
	 ubicacion_geo   VARCHAR(100) NOT NULL,
	 foto            VARCHAR(100) NOT NULL
	 
);


SELECT * FROM COLEGIO



