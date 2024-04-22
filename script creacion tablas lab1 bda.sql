CREATE DATABASE "laboratorio 1 bda"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Latin America.1252'
    LC_CTYPE = 'Spanish_Latin America.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;


create table auditoria (
	idAuditoria serial primary key,
	modificacion Varchar(200),
	descripcion Varchar(200)
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


CREATE OR REPLACE FUNCTION auditar_operacion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO auditoria (id_usuario, tipo_operacion, descripcion, fecha, hora)
    VALUES (CURRENT_USER, TG_OP);
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
