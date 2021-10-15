package com.cursospring.app.proyectobanco.service;

import java.util.List;

import org.json.JSONObject;

import com.cursospring.app.proyectobanco.model.Banco;
/**
 * Interfaz que implementa el método para el recorrido del json
 * @author Luis Parra
 *
 */
public interface EjecutarRecorridoJson {
	public List<Banco> recorrerJson(JSONObject json, List<Banco> lista);
}
