CREATE DATABASE "laboratorio 1 bda"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Latin America.1252'
    LC_CTYPE = 'Spanish_Latin America.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;



create table parametros_trigger (
    id_usuario INTEGER,
    tipo_operacion VARCHAR(10),
    descripcion VARCHAR(200)
);

create table auditoria (
    id SERIAL PRIMARY KEY,
    id_usuario INTEGER L,
    tipo_operacion VARCHAR(10) ,
    descripcion varchar(200),
    fecha DATE ,
    hora TIME 
);

create table voluntario(
	idVoluntario serial primary key,
	condicionVoluntario varchar(200),
	disponibilidadVoluntario boolean,
	zonaViviendaVoluntario varchar(200), 
	equipamientoVoluntario varchar(200)
);


create table emergencia(
	idEmergencia serial primary key,
	tipoEmergencia varchar(200),
	zonaEmergencia varchar(200),
	condicionFisica varchar(200),
	cantidadVoluntarioMinimo varchar(200),
	cantidadVoluntarioMaximo varchar(200)
);

create table habilidad(
	idHabilidad serial primary key,
	nombreHabilidad varchar(200)	
);

create table estadoTarea(
	idEstadoTarea serial primary key,
	estadoTarea varchar(200)
);

create table tarea(
	idTarea serial primary key,
	idEstadoTarea integer,
	nombreTarea varchar(200),
	descripcionTarea varchar(500),
	tipoTarea varchar(200)
);

create table ranking (
	idRanking serial primary key,
	idTarea integer,
	idVoluntario integer,
	nivelRanking integer,
	tareaRanking varchar(200),
	FOREIGN KEY (idTarea) REFERENCES tarea(idTarea),
	FOREIGN KEY (idVoluntario) REFERENCES voluntario(idVoluntario)
);

create table voluntarioHabilidad(
	idVoluntarioHabilidad serial primary key,
	idVoluntario integer,
	idHabilidad integer,
	FOREIGN KEY (idVoluntario) REFERENCES voluntario(idVoluntario),
	FOREIGN KEY (idHabilidad) REFERENCES habilidad(idHabilidad)
);

create table institucion (
	idInstitucion serial primary key,
	idEmergencia integer,
	nombreInstitucion varchar(200),
	FOREIGN KEY (idEmergencia) REFERENCES emergencia(idEmergencia)
);

create table emergenciaHabilidad(
	idEmergenciaHabilidad serial primary key,
	idHabilidad integer,
	idEmergencia integer,
	FOREIGN KEY (idHabilidad) REFERENCES habilidad(idHabilidad),
	FOREIGN KEY (idEmergencia) REFERENCES emergencia(idEmergencia)
);

create table tareaHabilidad(
	idTareaHabilidad serial primary key,
	idTarea integer,
	idHabilidad integer,
	habilidadRequerida varchar(200),
	FOREIGN KEY (idTarea) REFERENCES tarea(idTarea),
	FOREIGN KEY (idHabilidad) REFERENCES habilidad(idHabilidad)
);


CREATE  FUNCTION auditar_operacion()
RETURNS TRIGGER AS $$
DECLARE
    id_usuario INTEGER;
    tipo_operacion VARCHAR(10);
    descripcion VARCHAR(200);
BEGIN

    SELECT id_usuario, tipo_operacion, descripcion INTO id_usuario, tipo_operacion, descripcion
    FROM parametros_trigger
    WHERE id = 1; 

   
    INSERT INTO auditoria (id_usuario, tipo_operacion, descripcion, fecha, hora)
    VALUES (id_usuario, TG_OP, descripcion, current_date, current_time);

    
    DELETE FROM parametros_trigger WHERE id = 1;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;



CREATE TRIGGER trigger_auditoria
AFTER INSERT OR UPDATE OR DELETE ON emergencia
FOR EACH ROW
EXECUTE FUNCTION auditar_operacion();


CREATE TRIGGER trigger_auditoria
AFTER INSERT OR UPDATE OR DELETE ON emergenciahabilidad
FOR EACH ROW
EXECUTE FUNCTION auditar_operacion();


CREATE TRIGGER trigger_auditoria
AFTER INSERT OR UPDATE OR DELETE ON estadotarea
FOR EACH ROW
EXECUTE FUNCTION auditar_operacion();


CREATE TRIGGER trigger_auditoria
AFTER INSERT OR UPDATE OR DELETE ON habilidad
FOR EACH ROW
EXECUTE FUNCTION auditar_operacion();


CREATE TRIGGER trigger_auditoria
AFTER INSERT OR UPDATE OR DELETE ON institucion
FOR EACH ROW
EXECUTE FUNCTION auditar_operacion();


CREATE TRIGGER trigger_auditoria
AFTER INSERT OR UPDATE OR DELETE ON ranking
FOR EACH ROW
EXECUTE FUNCTION auditar_operacion();



CREATE TRIGGER trigger_auditoria
AFTER INSERT OR UPDATE OR DELETE ON tarea
FOR EACH ROW
EXECUTE FUNCTION auditar_operacion();


CREATE TRIGGER trigger_auditoria
AFTER INSERT OR UPDATE OR DELETE ON tareahabilidad
FOR EACH ROW
EXECUTE FUNCTION auditar_operacion();


CREATE TRIGGER trigger_auditoria
AFTER INSERT OR UPDATE OR DELETE ON voluntario
FOR EACH ROW
EXECUTE FUNCTION auditar_operacion();


CREATE TRIGGER trigger_auditoria
AFTER INSERT OR UPDATE OR DELETE ON voluntariohabilidad
FOR EACH ROW
EXECUTE FUNCTION auditar_operacion();




CREATE FUNCTION public.mayores_consultas()
    RETURNS integer[]
    LANGUAGE 'plpgsql'
    
AS $BODY$
declare id_usuario_actualizaciones INTEGER;
declare    id_usuario_inserts INTEGER;
declare    id_usuario_deletes INTEGER;
declare    resultado INTEGER[];

Begin
 
     SELECT id_usuario INTO id_usuario_actualizaciones
    FROM (
        SELECT id_usuario, COUNT(*) AS num_actualizaciones
        FROM auditoria
        WHERE tipo_operacion = 'UPDATE'
        GROUP BY id_usuario
        ORDER BY COUNT(*) DESC
        LIMIT 1
    ) AS t1;
    

    SELECT id_usuario INTO id_usuario_inserts
    FROM (
        SELECT id_usuario, COUNT(*) AS num_inserts
        FROM auditoria
        WHERE tipo_operacion = 'INSERT'
        GROUP BY id_usuario
        ORDER BY COUNT(*) DESC
        LIMIT 1
    ) AS t2;
    
    
    SELECT id_usuario INTO id_usuario_deletes
    FROM (
        SELECT id_usuario, COUNT(*) AS num_deletes
        FROM auditoria
        WHERE tipo_operacion = 'DELETE'
        GROUP BY id_usuario
        ORDER BY COUNT(*) DESC
        LIMIT 1
    ) AS t3;

 
    resultado := ARRAY[id_usuario_actualizaciones, id_usuario_inserts, id_usuario_deletes];

  
    RETURN resultado;

end;
$BODY$;

ALTER FUNCTION public.mayores_consultas()
    OWNER TO postgres;