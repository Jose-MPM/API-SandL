package com.SandL.api.service;

import java.util.List;

import com.SandL.api.entity.Ingrediente;
import com.SandL.api.entity.TipoProducto;

public interface SvcIngrediente {

	public List<Ingrediente> getIngredientes();s

	public Ingrediente getIngrediente(Integer id_ingrediente);

	public String createIngrediente(Ingrediente in);

	public String updateIngrediente(Ingrediente in, Integer id_ingrediente);

	public String deleteIngrediente(Integer id_ingrediente);

	// para actualizar el TipoProducto
	// recibe el tipo producto que se debe actualizar y el id al cliente
	public String updateIngredienteTipoProducto(TipoProducto tipoProducto, Integer id);

	public void insertarIngredienteEjemplo();
}
