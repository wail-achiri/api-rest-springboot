package com.examen.examenmonto.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.examenmonto.modelo.MontoEntidad;
import com.examen.examenmonto.servicio.MontoServicio;

import lombok.RequiredArgsConstructor;

@RestController //LE INDICA QUE ESTA CLASE SE VA A MANEJRA POR UN CONTROLADOR
@RequestMapping("/monto") //ES DONDE LE VAMOS A INDICAR LA RUTA ES LA QUE TIENE QUE SEGUIR PARA LLEGAR AL CONTROLADOR
@RequiredArgsConstructor //HACE LO MISMO QUE @AllArgsConstructor 
public class ControladorMonto {
	
	private final MontoServicio montoServicio;//INYECCION DE DEPENDENCIAS CONSTRUCTOR
	
	//CREAR
	@PostMapping
	public ResponseEntity guardarMonto(@RequestBody MontoEntidad monto) { 
		return new ResponseEntity(montoServicio.guardarMonto(monto),HttpStatus.CREATED); //CODIGO DE HTTP CREATED 
	}
	
	//OBTENER
	@GetMapping("/{cantidad}/{monedaOrigen}/{monedaDestino}")
	public ResponseEntity obtenerMonto(@PathVariable("cantidad") double cantidad,@PathVariable("monedaOrigen") String monedaOrigen,@PathVariable("monedaDestino") String monedaDestino) { 
		return new ResponseEntity(montoServicio.obtenerCambio(cantidad,monedaOrigen,monedaDestino),HttpStatus.OK); //CODIGO DE HTTP OK PETICION CORRECTAMENTE
	}
	
	/*public ResponseEntity obtenerMonto(@PathVariable("id") Long idMonto,@PathVariable("cantidad") double cantidad,@PathVariable("monedaOrigen") String monedaOrigen,@PathVariable("monedaDestino") String monedaDestino) { //NO QUEREMOS JSON, SI NO ENVIAR EL ID USUARIO, lo que hace el pathvariable el parametro idUsuario, se lo esta enviando en el getmapping donde esta la url
		return new ResponseEntity(montoServicio.obtenerMonto(idMonto,cantidad,monedaOrigen,monedaDestino),HttpStatus.OK); //CODIGO DE HTTP OK PETICION CORRECTAMENTE
	}*/
	
	//MODIFICAR
	@PutMapping("/{id}")
	public ResponseEntity modificarMonto(@PathVariable("id") Long idMonto, @RequestBody MontoEntidad monto) {
		return new ResponseEntity(montoServicio.montoAModificar(idMonto,monto),HttpStatus.OK);
	}
	
}
