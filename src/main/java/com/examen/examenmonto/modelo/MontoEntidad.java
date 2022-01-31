package com.examen.examenmonto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "MONTO")
@AllArgsConstructor
@NoArgsConstructor
public class MontoEntidad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(name = "moneda_origen")
	private String monedaOrigen;
	@Column(name = "moneda_destino")
	private String monedaDestino;
	@Column(name = "cambio")
	private double cambio;
	
}
