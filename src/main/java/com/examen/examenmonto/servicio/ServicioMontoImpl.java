package com.examen.examenmonto.servicio;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examen.examenmonto.modelo.Monto;
import com.examen.examenmonto.modelo.MontoEntidad;
import com.examen.examenmonto.repositorio.RepositorioMonto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicioMontoImpl implements MontoServicio{

	private final RepositorioMonto repositorioMonto;
	
	@Override
	public MontoEntidad guardarMonto(MontoEntidad monto) {
		// TODO Auto-generated method stub
		return repositorioMonto.save(monto); //AGREGAMOS EL NUEVO MONTO
	}


	
	@Override
	public Monto obtenerCambio(double monto, String moneda_origen, String moneda_destino) {
		// TODO Auto-generated method stub
		Monto cambio_monto = new Monto();
		MontoEntidad monto_entidad = repositorioMonto.findByMonedaOrigenAndMonedaDestino(moneda_origen, moneda_destino);
		
		if(monto_entidad != null) {
			cambio_monto.setMonto(monto);
			cambio_monto.setMoneda_origen(moneda_origen);
			cambio_monto.setMoneda_destino(moneda_destino);
			cambio_monto.setCambio_moneda((Math.round((monto_entidad.getCambio()*monto)*100.0)/100.0));;
		}
		
		return cambio_monto;
	}

	@Override
	public MontoEntidad montoAModificar(Long id, MontoEntidad montoModificar) {
		// TODO Auto-generated method stub
		MontoEntidad montoBuscado = repositorioMonto.findById(id).get();
		montoBuscado.setMonedaOrigen(montoModificar.getMonedaOrigen());
		montoBuscado.setMonedaDestino(montoModificar.getMonedaDestino());
		montoBuscado.setCambio(montoModificar.getCambio());
		
		return repositorioMonto.save(montoBuscado);
	}


	/*@Override
	public MontoEntidad obtenerMonto(Long idMonto,double cantidad, String monedaOrigen, String monedaDestino) {
		// TODO Auto-generated method stub
		MontoEntidad montoBuscado = repositorioMonto.findById(idMonto).get();
		
			return new MontoEntidad(idMonto, monedaDestino, monedaDestino, montoBuscado.getCambio()*cantidad);
		//return Optional.ofNullable(repositorioMonto.findById(idMonto).orElseThrow(() -> {throw new RuntimeException();}));
		
	}*/

}
