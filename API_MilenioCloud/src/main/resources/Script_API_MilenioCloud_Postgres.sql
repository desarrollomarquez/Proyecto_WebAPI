CREATE TABLE articles (
	 articleId SERIAL PRIMARY KEY,
	 title VARCHAR(200) NOT NULL,
	 category VARCHAR(100) NOT NULL
);

SELECT * FROM articles;

INSERT INTO articles VALUES (1,'Sprint', 'Backend'); 
INSERT INTO articles VALUES (2,'Sprintboot', 'Frontend');
INSERT INTO articles VALUES (3,'Sprintbootrest', 'database');

SELECT current_date

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

INSERT INTO public.colegio(
            codigo_id, nit, nombre, codigo_colegio, codigo_dane, direccion, 
            telefono, fini_fiscal, ffin_fiscal, ubicacion_geo, foto)
    VALUES (1, 90012354, 'Fe y Alegria', 52, 201, 'CALLE MENTIRAS', '20121020', current_date , current_date, (121212,313131), 'Ruta/fotos');


SELECT * FROM COLEGIO



