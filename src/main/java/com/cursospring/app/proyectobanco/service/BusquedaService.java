package com.cursospring.app.proyectobanco.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cursospring.app.proyectobanco.model.Banco;

/**
 * Servicio el cual es capáz de realizar la busqueda de las sucursales o cajeros mas cercanos
 * @author Luis Parra
 *
 */

@Service
public class BusquedaService {
	
	/**
	 * Este método realiza dos busquedas independientes, primero con CP al ser el parámetro de mayor exactitud. Si no encuentra nada procede a realizar la busqueda con
	 * el nombre de la ciudad, no es una busqueda complementaria, cada parámetro es independiente
	 * Si no encuentra nada arroja una excepción
	 * @param lista lista completa de los datos del objeto Banco
	 * @param cp código postal introducido por el usuario
	 * @param ciudad nombre ciudad introducido por el usuario
	 * @return lista con los cajeros/sucursales mas cercanos
	 */
	public List<Banco> buscar(List<Banco> lista, String cp, String ciudad){
		List<Banco> listaBancos = new LinkedList<>();
		for (Iterator<Banco> iterator = lista.iterator(); iterator.hasNext();) {
			Banco banco = iterator.next();
			if(banco.getCodigoPostal().equalsIgnoreCase(cp) )  {
				listaBancos.add(banco);
			}
		}
		
		
		if(listaBancos.isEmpty()) {
			for (Iterator<Banco> iterator = lista.iterator(); iterator.hasNext();) {
				Banco banco = iterator.next();
				if(banco.getCiudad().equalsIgnoreCase(ciudad) )  {
					listaBancos.add(banco);
				}
			}
		}
		
		if(listaBancos.isEmpty()) {
			throw new IllegalArgumentException("No se encontró ninguna sucursal o cajero cerca de su ubiación");
		}
		

		return listaBancos;
		
	}

}
