package com.cursospring.app.proyectobanco.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.cursospring.app.proyectobanco.model.Banco;

@Service
public class InicioRecorridoJson implements EjecutarRecorridoJson{
	
	RecorrerJsonService recorrerJsonService;
	
	public InicioRecorridoJson(RecorrerJsonService recorrerJsonService) {
		this.recorrerJsonService = recorrerJsonService;
	}

	/**
	 * Este método consume el json y empieza a ejecutar el recorrido del json a través del Map y sus Keys 
	 * @param json Nivel de profunidad del json u objeto en el que se encuentra
	 * @param lista Recibe una lista vacia del objeto Banco
	 * @return
	 */
	public List<Banco> recorrerJson(JSONObject json, List<Banco> lista){
		
		Set<String> set = json.keySet();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			JSONObject subRuta = json.getJSONObject(key);
			
			lista = recorrerJsonService.recorrerJson(subRuta, lista);
			
		}
		return lista;
		
	}


	
}
