create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table municipio (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 codigo varchar(20) not null,
 primary key (id)
);

create table lugarturistico (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 descripcion varchar(500) not null,
 direccion varchar(250) not null,
 id_municipio int(11) not null,
 primary key (id)
);

Alter table lugarturistico ADD FOREIGN KEY (id_municipio) REFERENCES municipio(id);

