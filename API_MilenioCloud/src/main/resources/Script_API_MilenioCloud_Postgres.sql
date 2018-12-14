CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
--SELECT md5(random()::text || clock_timestamp()::text)::uuid

CREATE EXTENSION "pgcrypto";
--SELECT gen_random_uuid()

DROP TABLE IF EXISTS  articles CASCADE;
DROP TABLE IF EXISTS  COLEGIO CASCADE;
DROP TABLE IF EXISTS  departamento CASCADE;


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


CREATE TABLE departamento (
	 codigo_id      VARCHAR(50) NOT NULL PRIMARY KEY,
	 codigo         VARCHAR(20) NOT NULL,
	 nombre    	VARCHAR(300) NOT NULL,
	 latitud   	VARCHAR(50),	
	 longitud  	VARCHAR(50)
);

SELECT * FROM departamento

TRUNCATE TABLE departamento

INSERT INTO departamento VALUES( gen_random_uuid(),'91','Amazonas','-1.0197222','-71.9383333' );
INSERT INTO departamento VALUES( gen_random_uuid(),'05','Antioquia','7','-75.5' );
INSERT INTO departamento VALUES( gen_random_uuid(),'81','Arauca','7.0902778','-70.7616667' );
INSERT INTO departamento VALUES( gen_random_uuid(),'08','Atlantico','10.75','-75' );
INSERT INTO departamento VALUES( gen_random_uuid(),'13','Bolivar','9','-74.3333333' );
INSERT INTO departamento VALUES( gen_random_uuid(),'15','Boyaca','5.5','-72.5' );
INSERT INTO departamento VALUES( gen_random_uuid(),'17','Caldas','5.25','-75.5' );
INSERT INTO departamento VALUES( gen_random_uuid(),'18','Caqueta','1','-74' );
INSERT INTO departamento VALUES( gen_random_uuid(),'85','Casanare','5.5','-71.5' );
INSERT INTO departamento VALUES( gen_random_uuid(),'19','Cauca','2.5','-76.8333333' );
INSERT INTO departamento VALUES( gen_random_uuid(),'20','Cesar','9.3333333','-73.5' );
INSERT INTO departamento VALUES( gen_random_uuid(),'27','Choco³','6','-77' );
INSERT INTO departamento VALUES( gen_random_uuid(),'25','Cundinamarca','5','-74.1666667' );
INSERT INTO departamento VALUES( gen_random_uuid(),'23','Cordoba','8.3333333','-75.6666667' );
INSERT INTO departamento VALUES( gen_random_uuid(),'94','Guainia','2.5','-69' );
INSERT INTO departamento VALUES( gen_random_uuid(),'95','Guaviare','1.6894444','-72.8202778' );
INSERT INTO departamento VALUES( gen_random_uuid(),'41','Huila','2.5','-75.75' );
INSERT INTO departamento VALUES( gen_random_uuid(),'44','La Guajira','11.5','-72.5' );
INSERT INTO departamento VALUES( gen_random_uuid(),'47','Magdalena','10','-74.5' );
INSERT INTO departamento VALUES( gen_random_uuid(),'50','Meta','3.5','-73' );
INSERT INTO departamento VALUES( gen_random_uuid(),'52','Nariño','1.5','-78' );
INSERT INTO departamento VALUES( gen_random_uuid(),'54','Norte de Santander','8','-73' );
INSERT INTO departamento VALUES( gen_random_uuid(),'86','Putumayo','0.5','-76' );
INSERT INTO departamento VALUES( gen_random_uuid(),'63','Quindio','4.5','-75.6666667' );
INSERT INTO departamento VALUES( gen_random_uuid(),'66','Risaralda','5','-76' );
INSERT INTO departamento VALUES( gen_random_uuid(),'88','San Andres','12.5847222','-81.7005556' );
INSERT INTO departamento VALUES( gen_random_uuid(),'68','Santander','7','-73.25' );
INSERT INTO departamento VALUES( gen_random_uuid(),'70','Sucre','9','-75' );
INSERT INTO departamento VALUES( gen_random_uuid(),'73','Tolima','3.75','-75.25' );
INSERT INTO departamento VALUES( gen_random_uuid(),'76','Valle del Cauca','3.75','-76.5' );
INSERT INTO departamento VALUES( gen_random_uuid(),'97','Vaupes','0.25','-70.75' );
INSERT INTO departamento VALUES( gen_random_uuid(),'99','Vichada','5','-69.5' );


SELECT * FROM (
  SELECT *, ROW_NUMBER () OVER (ORDER BY nombre)
  FROM departamento
) x WHERE ROW_NUMBER BETWEEN 10 AND 20;


DROP FUNCTION IF EXISTS departamento( VARCHAR(50), VARCHAR(20),  VARCHAR(300),  VARCHAR(50),  VARCHAR(50))

CREATE OR REPLACE FUNCTION departamento( v_codigo_id VARCHAR(50), v_codigo VARCHAR(20), v_nombre VARCHAR(300), v_latitud VARCHAR(50), v_longitud VARCHAR(50) )
  RETURNS BOOLEAN AS $$
DECLARE
  id_insert INTEGER;
  cantidad_datos INTEGER;
  temporal INTEGER;
  nombre_tabla VARCHAR := 'departamento';
  atributos_tabla VARCHAR := 'codigo_id, codigo, nombre, latitud, longitud';
  c_atributos_tabla VARCHAR := '$1, $2, $3, $4, $5';
BEGIN
  BEGIN
    EXECUTE format('INSERT INTO %I  (' || atributos_tabla || ')  VALUES(' || c_atributos_tabla ||') ', nombre_tabla)
    USING v_codigo_id, v_codigo, v_nombre, v_latitud, v_longitud;
    RETURN true;
    EXCEPTION WHEN OTHERS THEN
    RETURN 0;
  END;
END;
$$ LANGUAGE plpgsql;

