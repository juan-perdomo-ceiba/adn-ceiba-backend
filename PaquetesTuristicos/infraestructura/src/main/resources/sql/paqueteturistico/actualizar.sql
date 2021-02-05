update paqueteturistico
set nombre = :nombre,
	descripcion = :descripcion,
	fecha_reserva = :fechaReserva,
	cantidad_maxima_personas = :cantidadMaximaPersonas,
	cantidad_maxima_reservas = :cantidadMaximaReservas,
	precio_por_persona = :precioPorPersona
where id = :id