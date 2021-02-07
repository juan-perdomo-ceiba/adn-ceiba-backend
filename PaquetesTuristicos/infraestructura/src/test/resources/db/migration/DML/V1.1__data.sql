insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

INSERT INTO lugarturistico (nombre, descripcion, direccion ,id_municipio) VALUES ('Islandia', 'excelente', 'Calle 5 N 4', 1);

INSERT INTO paqueteturistico (nombre, descripcion, cantidad_maxima_personas, cantidad_maxima_reservas, precio_por_persona, id_lugar_turistico)
VALUES ('Paquete Gold Islandia', 'Excelente paquete', 60, 20, 50000, 1);

INSERT INTO reserva(fecha_reserva, cedula_cliente, nombre_cliente, telefono_cliente, email_cliente,numero_personas,id_paquete_turistico, observaciones, identificador_reserva, precio)
VALUES ('2020-12-26', '1326985478', 'Juan Jose Perdomo Forero', '3168184478' ,'juan.perdomo@@ceiba.com.co', 10, 1, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '84813e78-6b94-4bdf-8462-a8c8db96ada8', 200000);
