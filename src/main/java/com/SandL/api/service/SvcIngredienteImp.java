package com.SandL.api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SandL.api.entity.DateRange;
import com.SandL.api.entity.Ingrediente;
import com.SandL.api.entity.TipoProducto;
import com.SandL.api.repository.RepoIngrediente;
import com.SandL.api.repository.RepoTipoProducto;


@Service
public class SvcIngredienteImp implements SvcIngrediente {

	@Autowired
    private RepoIngrediente repoIngrediente;
    
	@Autowired
    private RepoTipoProducto repoTipoProducto;
	
	public void insertarIngredienteEjemplo() {
        // Crear una instancia de Ingrediente
        Ingrediente nuevoIngrediente = new Ingrediente();

        // Setear los atributos de Ingrediente
        nuevoIngrediente.setNombre("Ejemplo Ingrediente");
        nuevoIngrediente.setCantidad(10);
        nuevoIngrediente.setComentarios("Comentario de ejemplo");
        nuevoIngrediente.setDescripcion("Descripción de ejemplo");
        nuevoIngrediente.setMedida("Gramos");
        nuevoIngrediente.setPrecio(9.99f);
        nuevoIngrediente.setProveedor("Proveedor de ejemplo");
        nuevoIngrediente.setStatus(1); // Ajusta según tus necesidades

        // Setear el periodo (DateRange)
        DateRange periodo = new DateRange();
        periodo.setAdquisicion(LocalDate.now());
        periodo.setExpiracion(LocalDate.now().plusMonths(6));
        nuevoIngrediente.setPeriodo(periodo);

        // Obtener el TipoProducto correspondiente desde la base de datos
        TipoProducto tipoProducto = repoTipoProducto.findById(1).orElse(null); // Ajusta según tus necesidades
        nuevoIngrediente.setTipoProducto(tipoProducto);

        // Guardar el nuevo Ingrediente en la base de datos
        repoIngrediente.save(nuevoIngrediente);
    }
	
	@Override
	public List<Ingrediente> getIngredientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ingrediente getIngrediente(Integer id_ingrediente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createIngrediente(Ingrediente in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateIngrediente(Ingrediente in, Integer id_ingrediente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteIngrediente(Integer id_ingrediente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateIngredienteTipoProducto(TipoProducto tipoProducto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
