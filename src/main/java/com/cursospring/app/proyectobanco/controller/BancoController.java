package com.cursospring.app.proyectobanco.controller;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.app.proyectobanco.model.Banco;
import com.cursospring.app.proyectobanco.service.BusquedaService;
import com.cursospring.app.proyectobanco.service.ConsumirJsonService;
import com.cursospring.app.proyectobanco.service.InicioRecorridoJson;

/**
 * Clase controlador en la que ocurre el flujo de la lógica del progama
 * @author Luis Parra
 *
 */

@RestController
@RequestMapping("/banco")
public class BancoController {
	
	private ConsumirJsonService consumirJsonService;
	private BusquedaService busquedaService;
	private InicioRecorridoJson inicioRecorridoJson;

	/**
	 * Inyección de dependencias
	 * @param consumirJsonService Clase en la que se consume el json
	 * @param busquedaService Clase en la que se realiza la búsqueda
	 * @param inicioRecorridoJson Clase en la que empieza el recorrido del json
	 */
	public BancoController(ConsumirJsonService consumirJsonService, BusquedaService busquedaService, InicioRecorridoJson inicioRecorridoJson) {
		this.consumirJsonService = consumirJsonService;
		this.busquedaService = busquedaService;
		this.inicioRecorridoJson = inicioRecorridoJson;
	}

	
	/**
	 * 
	 * @param banco objeto con los atributos introducidos por el usuario (CÓDIGO POSTAL Ó CIUDAD) cualquiera de los dos es válido, pero no toma ambas como dependientes, primero busca con CP y si no encuentra con ciudad
	 * @return lista con la busqueda realizada
	 */

	@PostMapping
	public List<Banco> getData(@RequestBody Banco banco){
		
		List<Banco> lista = new LinkedList<>();
		JSONObject json = consumirJsonService.consumirJson();
		lista  = inicioRecorridoJson.recorrerJson(json, lista);
				
		return busquedaService.buscar(lista, banco.getCodigoPostal(), banco.getCiudad());
	}
	
	

}
