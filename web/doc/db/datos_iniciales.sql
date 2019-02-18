-----------Datos iniciles => Tabla => Persona-----------

insert into persona values ('109245683','carlos','fuentes','1980-01-20','CR 5 N 247 pamplona','carlos@hotmail.com');
insert into persona values ('13345687','daniel','romero','1993-05-20','CR 6 N 247 pamplona','daniel4@hotmail.com');
insert into persona values ('10924567','neimar','fuentes','2000-11-10','CR 7 N 247 pamplona','neimarfu@gmail.com');
insert into persona values ('8850483','monica','latorre','1990-05-18','CR 8 N 247 pamplona','monikita@yahoo.com');
insert into persona values ('10947852','pepito','perez','1998-06-02','CR 9 N 247 pamplona','pepito47@hotmail.com');
insert into persona values ('109284567','juan','montes','1993-01-20','CR 10 N 247 pamplona','neimarfu@gmail.com');
insert into persona values ('88504189','pedro','montañes','1983-07-29','CR 11 N 247 pamplona','monikita@yahoo.com');

-----------Datos iniciles => Tabla => Usuario-----------

insert into usuario values ('109245683','123','usu1');
insert into usuario values ('13345687','124','usu2');
insert into usuario values ('10947852','125','usu3');
insert into usuario values ('10924567','126','usu4');
insert into usuario values ('109284567','127','usu5');
insert into usuario values ('88504189','128','usu6');

-----------Datos iniciles => Tabla => Rol-----------

insert into rol values ('001','Estudiante','Persona que solo puede ver sus notas, programas, cancelacion, etc...');
insert into rol values ('002','Docente','Persona encargada de registrar notas, materias asignadas, grupos, etc...');
insert into rol values ('003','Administradior','Persona encargada de crear cuentas, asignar roles, etc....');
insert into rol values ('004','Director Programa','Persona encargada de administrar el programa al que tiene asignado');

-----------Datos iniciles => Tabla => Modulo-----------

insert into modulo values ('1','inscripcion','1111');
insert into modulo values ('2','matricula','2222');
insert into modulo values ('3','grados','3333');
insert into modulo values ('4','egresados','4444');
insert into modulo values ('5','calificaciones','5555');

-----------Datos iniciles => Tabla => Funcionalidad----------- 

insert into funcionalidad values ('001','Registro de notas','registro y control','------','1');
insert into funcionalidad values ('002','Cambio horario','direcion de programa','------','3');
insert into funcionalidad values ('003','Cambio materias','direcion de programa','------','3');
insert into funcionalidad values ('004','Ver notas','estudiantee','------','1');
insert into funcionalidad values ('005','Reingreso','registro y control ','------','1');
insert into funcionalidad values ('006','Homologacion','registro y control','------','1');

-----------Datos iniciles => Tabla => Usuarioxrol----------- 

insert into usuarioxrol values ('001','109245683');
insert into usuarioxrol values ('002','109284567');
insert into usuarioxrol values ('003','10924567');
insert into usuarioxrol values ('004','10947852');
insert into usuarioxrol values ('002','13345687');
insert into usuarioxrol values ('001','88504189');

-----------Datos iniciles => Tabla => Usuarioxrol----------- 

insert into rolxfuncionalidad values ('001','004');
insert into rolxfuncionalidad values ('004','002');		
insert into rolxfuncionalidad values ('002','001');
insert into rolxfuncionalidad values ('004','003');
insert into rolxfuncionalidad values ('003','006');
insert into rolxfuncionalidad values ('003','005');
insert into rolxfuncionalidad values ('003','004');
insert into rolxfuncionalidad values ('003','002');

