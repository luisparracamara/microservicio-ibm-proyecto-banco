package com.cursospring.app.proyectobanco.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.cursospring.app.proyectobanco.model.Banco;

@Service
public class RecorrerJsonService implements EjecutarRecorridoJson{
	
	MappearBancoService mappearBancoService;
	
	public RecorrerJsonService(MappearBancoService mappearBancoService) {
		this.mappearBancoService = mappearBancoService;
	}

	
	/**
	 * 
	 * @param json Recibe el objeto json desde el nivel de profunidad en el que se encuentra
	 * @param lista lista completa con todos los datos de sucursales y cajeros
	 * @return lista completa de datos de sucursales y cajeros
	 */

	public List<Banco> recorrerJson(JSONObject json, List<Banco> lista){
		
		Set<String> set = json.keySet();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			JSONObject subRuta = json.getJSONObject(key);
			mappearBancoService.recorrerJson(subRuta, lista);
			
		}
		
		return lista;
		
	}
	

}
