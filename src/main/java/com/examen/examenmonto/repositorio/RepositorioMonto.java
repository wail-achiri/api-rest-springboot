package com.examen.examenmonto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.examen.examenmonto.modelo.MontoEntidad;

public interface RepositorioMonto extends JpaRepository<MontoEntidad,Long>{
	public MontoEntidad findByMonedaOrigenAndMonedaDestino(@Param("moneda_origen") String moneda_origen,@Param("moneda_destino") String moneda_destino);
}
