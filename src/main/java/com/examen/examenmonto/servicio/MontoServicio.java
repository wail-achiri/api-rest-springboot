package com.examen.examenmonto.servicio;

import java.util.Optional;

import com.examen.examenmonto.modelo.Monto;
import com.examen.examenmonto.modelo.MontoEntidad;


public interface MontoServicio {
	MontoEntidad guardarMonto(MontoEntidad monto);
	
	//MontoEntidad obtenerMonto(Long idMonto,double cantidad, String monedaOrigen, String monedaDestino); //OPTIONAL NOS PREVIENE DE UN ERROR NULL POINTER, RECIBIREMOS EL ID DEL USUARIO PARA OBTENER

	Monto obtenerCambio(double monto,String moneda_origen,String moneda_destino);
	
	MontoEntidad montoAModificar(Long id, MontoEntidad montoModificar);
}
