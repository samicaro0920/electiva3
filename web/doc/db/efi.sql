-----------Base de datos => Sistema Academico-----------

create database efi;

create table persona(
    per_id varchar(20) not null,
    per_nombre varchar(50) not null,
    per_apellido varchar(50) not null,
    per_fecha_nacimiento date not null,
    per_direccion varchar(100),
    per_correo varchar (30) not null,
    primary key (per_id)
);

create table usuario(
    per_id varchar(20) not null,
    usu_clave varchar(20)not null,
    usu_usuario varchar(50) not null,
    primary key (per_id), 
    foreign key (per_id) references persona(per_id) 
    on update cascade on delete restrict
);

create table rol(
    rol_id varchar(30) not null,
    rol_nombre varchar(80) not null,
    rol_descripcion varchar(100) not null,
    primary key (rol_id)
);

create table modulo(
    mod_id varchar (30) not null,
    mod_nombre varchar(50) not null,
    mod_descripcion varchar(150) not null,
    primary key (mod_id)
);

create table funcionalidad(
    fun_id varchar(50) not null,
    fun_nombre varchar(50) not null,
    fun_ruta varchar(80) not null,
    fun_descripcion varchar(150) not null,
    mod_id varchar (30) not null,
    primary key (fun_id),
    foreign key (mod_id) references modulo(mod_id)
    on update cascade on delete restrict
);

create table usuarioxrol(
    rol_id varchar (30) not null,
    per_id varchar(20) Not null,
    primary key (rol_id,per_id),
    foreign key (rol_id) references rol(rol_id) 
    on update cascade on delete restrict,
    foreign key (per_id) references usuario(per_id) 
    on update cascade on delete restrict
);

create table rolxfuncionalidad(
    rol_id varchar(30) not null,
    fun_id varchar(50) not null,
    primary key (fun_id,rol_id),
    foreign key (fun_id) references funcionalidad(fun_id) 
    on update cascade on delete restrict,
    foreign key (rol_id) references rol(rol_id) 
    on update cascade on delete restrict
);