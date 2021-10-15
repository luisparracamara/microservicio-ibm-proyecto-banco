package com.cursospring.app.proyectobanco.service;


import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



/**
 * En esta clase se consume el json
 * @author Luis Parra
 *
 */

@Service
public class ConsumirJsonService {
	
private final RestTemplate restTempalte;

	
	@Autowired
	public ConsumirJsonService(RestTemplate restTempalte) {
		this.restTempalte = restTempalte;
	}
	
	
	/**
	 * Este método consume el json a través de rest template
	 * @return json fuente completo
	 */
	public JSONObject consumirJson(){
		String url = "http://localhost:8080/json5.json";
		@SuppressWarnings("unchecked")
		Map<String,Object> objeto = (Map<String, Object>) restTempalte.getForObject(url, Object.class);
			
		
		JSONObject input = new JSONObject(objeto);
		JSONObject json = input.getJSONObject("Servicios");
		
		return json;
		
	}


	
}
