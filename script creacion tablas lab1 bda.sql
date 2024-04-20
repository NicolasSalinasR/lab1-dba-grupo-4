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

