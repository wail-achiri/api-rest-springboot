package com.examen.examenmonto.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monto {
	private double monto;
	private String moneda_origen;
	private String moneda_destino;
	private Double cambio_moneda;
}
