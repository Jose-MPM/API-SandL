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

import com.SandL.api.entity.TipoProducto;
import com.SandL.api.service.SvcTipoProducto;

import jakarta.validation.Valid;

//@CrossOrigin(origins= {"http://localhost:8080"})
@RestController
@RequestMapping("/tipoProducto")
public class CtrlTipoProducto{
	// encargado de recibir las operaciones y validar que los datos requeridos en las peticiones seán correctos
	// el repo se encarga de toda la parte de las DB para extraer la info necesaria
	// pero quien decide el como y el orden es el service
	// serv 
    @Autowired
    private SvcTipoProducto svc;

    @Autowired
    //private TipoProductoService tipoProductoService;

    //private final Logger logger = LogManager.getLogger(InventarioController.class);

    /**
	 * Regresa una lista con todos los productos a las peticiones get recibidas en:
	 * /api/inventario
	 * @return una lista con todos los tipos productos.
	 */
	@GetMapping
	public ResponseEntity<List<TipoProducto>> getTiposProductos() throws Exception{
		return new ResponseEntity<>(svc.getTiposProductos(), HttpStatus.OK);
	}

    /**
     * Regresa una producto de nuestro inventario.
     * @return una producto de nuestro inventario
     */
    @GetMapping("/{idTipoProducto}")
    public ResponseEntity<TipoProducto> getTipoProducto(@PathVariable Integer idTipoProducto) {
        return new ResponseEntity<>(svc.getTipoProducto(idTipoProducto), HttpStatus.OK);
    }
    
    // ("/guardar")
	//@ResponseStatus(HttpStatus.CREATED)
    // EL response Entity nos permite responder un request, agregar un header y un body
    // BildingResult nos permite aplicar un validador y acceder a los errores generados
    @PostMapping
    public ResponseEntity<?> createTipoProducto(@Valid @RequestBody TipoProducto tipoProducto, BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) {
			Map<String,Object> response = new HashMap<>();
			response.put("mensaje", "Error en los datos incluidos en el Json");		
			response.put("error", bindingResult.getAllErrors().get(0).getDefaultMessage());
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}
    	Map<String,Object> response = new HashMap<>();
        // codigo correspondiente para insertar estos datos en la base de datos
    	
        response.put("mensaje", "El producto ha sido agregado a nuestro inventario.");
		return new ResponseEntity<>(svc.createTipoProducto(tipoProducto), HttpStatus.OK);
		//Map<String,Object>
    }

    // put nos indica que vamos a actualizar
    @PutMapping("/{idTipoProducto}")
    public ResponseEntity<?> updateTipoProducto(@PathVariable Integer idTipoProducto, 
    											@Valid @RequestBody TipoProducto tipoProducto, 
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
        return new ResponseEntity<>(svc.updateTipoProducto(idTipoProducto, tipoProducto), HttpStatus.OK);
    }

    @DeleteMapping("/{idTipoProducto}")
	//@ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteTipoProducto(@PathVariable Integer idTipoProducto) {
        //Map<String,Object> response = new HashMap<>();
        //la aplicacion como tal no debería de permitirnos borrar por completo algo, solo desactivar
        // codigo para validar que hay existe este producto con este id
    	// tomar en cuenta que si tenemos un ingrediente con un tipo que se quiere borrar no se va a poder 
        //response.put("mensaje", "El producto ha sido eliminado con exito.");
    	return new ResponseEntity<>(svc.deleteTipoProducto(idTipoProducto), HttpStatus.OK);
    }
}

