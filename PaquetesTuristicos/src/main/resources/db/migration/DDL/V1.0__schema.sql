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

INSERT INTO municipio (id, nombre, codigo) VALUES (1, 'Armenia', '001');

create table lugarturistico (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 descripcion varchar(500) not null,
 direccion varchar(250) not null,
 id_municipio int(11) not null,
 primary key (id)
);

Alter table lugarturistico ADD FOREIGN KEY (id_municipio) REFERENCES municipio(id);

create table paqueteturistico (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 descripcion varchar(500) not null,
 cantidad_maxima_personas int(11) not null,
 cantidad_maxima_reservas int(11) not null,
 precio_por_persona DECIMAL(16,4) not null,
 id_lugar_turistico int(11) not null,
 primary key (id)
);

Alter table paqueteturistico ADD FOREIGN KEY (id_lugar_turistico) REFERENCES lugarturistico(id);

create table reserva (
 id int(11) not null auto_increment,
 fecha_reserva date not null,
 cedula_cliente varchar(20) not null,
 nombre_cliente varchar(200) not null,
 telefono_cliente varchar(10) not null,
 email_cliente varchar(50) not null,
 numero_personas int(11) not null,
 id_paquete_turistico int(11) not null,
 observaciones varchar(600),
 identificador_reserva varchar(100),
 precio DECIMAL(16,4) not null,
 primary key (id)
);

Alter table reserva ADD FOREIGN KEY (id_paquete_turistico) REFERENCES paqueteturistico(id);


