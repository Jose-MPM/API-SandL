package com.SandL.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SandL.api.entity.Ingrediente;
import com.SandL.api.entity.TipoProducto;
import com.SandL.api.service.SvcIngrediente;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/inventario")
public class CtrlIngrediente {
	
	@Autowired
    private SvcIngrediente svc;
	
	
	/**
	 * Regresa una lista con todos los productos a las peticiones get recibidas en:
	 * /inventario
	 * @return una lista con todos los tipos productos.
	 */
	@GetMapping
	public ResponseEntity<List<Ingrediente>> getIngredientes() throws Exception{
		svc.insertarIngredienteEjemplo();
		return new ResponseEntity<>(svc.getIngredientes(), HttpStatus.OK);
	}

    /**
     * Regresa una INGREDIENTE de nuestro inventario.
     * @return una producto de nuestro inventario
     */
    @GetMapping("/{id_Ingrediente}")
    public ResponseEntity<?> getIngrediente(@PathVariable Integer id_Ingrediente) {
    	Ingrediente ingredienteAux = svc.getIngrediente(id_Ingrediente);
    	if(ingredienteAux == null)
    		return new ResponseEntity<>("No existe un tipo ingrediente con ese id", HttpStatus.OK);
        return new ResponseEntity<>(ingredienteAux, HttpStatus.OK);
    }
    
    // ("/guardar")
	//@ResponseStatus(HttpStatus.CREATED)
    // EL response Entity nos permite responder un request, agregar un header y un body
    // BildingResult nos permite aplicar un validador y acceder a los errores generados
    @PostMapping
    public ResponseEntity<?> createIngrediente(@Valid @RequestBody Ingrediente ingrediente, BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) {
			Map<String,Object> response = new HashMap<>();
			response.put("mensaje", "Error en los datos incluidos en el Json");		
			response.put("error", bindingResult.getAllErrors().get(0).getDefaultMessage());
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}
    	Map<String,Object> response = new HashMap<>();
        // codigo correspondiente para insertar estos datos en la base de datos
    	
        response.put("mensaje", "El producto ha sido agregado a nuestro inventario.");
		return new ResponseEntity<>(svc.createIngrediente(ingrediente), HttpStatus.OK);
		//Map<String,Object>
    }

    // put nos indica que vamos a actualizar
    @PutMapping("/{id_Ingrediente}")
    public ResponseEntity<?> updateIngrediente(@PathVariable Integer id_Ingrediente, 
    											@Valid @RequestBody Ingrediente ingrediente, 
    											BindingResult bindingResult) {
       if(bindingResult.hasErrors()) {
            Map<String,Object> response = new HashMap<>();
            response.put("mensaje", "Error en los datos incluidos en el Json");     
            response.put("error", bindingResult.getAllErrors().get(0).getDefaultMessage());
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
        }
        //Map<String,Object> response = new HashMap<>();
        // codigo correspondiente para ingresar en la base de datos
        // si existe lo actualiza, si no debemos enviar un mensaje de error
        //TipoProducto tipoProductoAEditar = svc.updateTipoProducto(idTipoProducto, tipoProducto);
        //response.put("mensaje", "El producto ha sido actualizado a nuestro inventario con exito.");
        return new ResponseEntity<>(svc.updateIngrediente(ingrediente, id_Ingrediente), HttpStatus.OK);
    }

    @DeleteMapping("/{id_ingrediente}")
	//@ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteIngrediente(@PathVariable Integer id_ingrediente) {
        //Map<String,Object> response = new HashMap<>();
        //la aplicacion como tal no debería de permitirnos borrar por completo algo, solo desactivar
        // codigo para validar que hay existe este producto con este id
    	// tomar en cuenta que si tenemos un ingrediente con un tipo que se quiere borrar no se va a poder 
        //response.put("mensaje", "El producto ha sido eliminado con exito.");
    	return new ResponseEntity<>(svc.deleteIngrediente(id_ingrediente), HttpStatus.OK);
    }
}
