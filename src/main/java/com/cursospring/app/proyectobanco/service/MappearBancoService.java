package com.cursospring.app.proyectobanco.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.cursospring.app.proyectobanco.model.Banco;

/**
 * Clase en la que se mapean todos los datos y se introducen a una lista
 * @author Luis Parra
 *
 */

@Service
public class MappearBancoService implements EjecutarRecorridoJson{
	
	/**
	 * En este método se mapea el objeto Banco con todos sus atributos para después introducirlo en una lista
	 * @param json Recibe el objeto json desde el nivel de profunidad en el que se encuentra
	 * @param lista lista vacía
	 * @return lista completa con todos los datos de sucursales y cajeros
	 */
	
	public List<Banco> recorrerJson(JSONObject json, List<Banco> lista){
		
		Set<String> set = json.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			JSONArray arr = json.getJSONArray(key);
			Banco banco = new Banco( arr.getString(2), arr.getString(17), arr.getString(4), arr.getString(19),null );
			
			

			//obtener el codigo postal
			String cp = (String) arr.get(4);
			char[] cpChar = cp.toCharArray();
			
			String res = "";
			for (int i = 0; i < cpChar.length; i++) {
				char elemento = cpChar[i];
				if (Character.isDigit(elemento)) {
					res+=elemento;
				}
				banco.setCodigoPostal(res);
			}
			lista.add(banco);	

		}
		
		return lista;
	}
	
}
