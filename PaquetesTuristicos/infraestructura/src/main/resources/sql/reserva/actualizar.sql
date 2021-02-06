update reserva
set fecha_reserva = :fechaReserva,
	cedula_cliente = :cedulaCliente,
	nombre_cliente = :nombreCliente,
	telefono_cliente = :telefonoCliente,
	email_cliente = :emailCliente,
	numero_personas = :numeroPersonas,
	id_paquete_turistico = :idPaqueteTuristico,
	observaciones = :observaciones,
	identificador_reserva = :identificadorReserva,
	precio = :precio
where id = :id