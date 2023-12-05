package com.SandL.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SandL.api.entity.TipoProducto;
import com.SandL.api.repository.RepoTipoProducto;

@Service
public class SvcTipoProductoImp implements SvcTipoProducto {

	@Autowired
	RepoTipoProducto repo;
	
	@Override
	public List<TipoProducto> getTiposProductos() {
		return repo.findByStatus(1);
	}

	@Override
	public TipoProducto getTipoProducto(Integer id_tipo_producto) {
		return repo.findByTipoProductoId(id_tipo_producto);
	}

	@Override
	public String createTipoProducto(TipoProducto tipoProducto) {
		TipoProducto tipoProductoSaved = (TipoProducto) repo.findByTipoProducto(tipoProducto.getTipo());
		if(tipoProductoSaved != null) {
			if(tipoProductoSaved.getStatus() == 0)
				repo.activateTipoProducto(tipoProducto.getId_tipo_producto());
			else
				return "El Tipo producto que intentas crear ya existe.";
		}
		repo.createTipoProducto(tipoProducto.getTipo());
		return "Tipo Producto Creado";
	}

	@Override
	public String updateTipoProducto(Integer id_tipo_producto, TipoProducto tipoProducto) {
		TipoProducto tipoProductoSaved = (TipoProducto) repo.findByTipoProductoId(id_tipo_producto);
		String message = "";
		if(tipoProductoSaved == null) {
			message = "El Tipo producto que intentas actualizar no existe.";
		}
		if(tipoProductoSaved != null) {
			if(tipoProductoSaved.getStatus() == 0)
				message =  "El Tipo producto que intentas actualizar no esta activo.";
			else {
				tipoProductoSaved = (TipoProducto) repo.findByTipoProducto(tipoProducto.getTipo());
				if(tipoProductoSaved != null) {
					// es importante notar que no podemos tener dos tipos productos con el mismo tipo
					message = "El Tipo Producto que quieres actualizar ya existe."; 
				}
				repo.updateTipoProducto(id_tipo_producto, tipoProducto.getTipo());
				message = "Tipo Producto Actualizado";
			}
		}
		return message;
	}

	@Override
	public String deleteTipoProducto(Integer id_tipo_producto) {
		TipoProducto tipoProductoSaved = (TipoProducto) repo.findByTipoProductoId(id_tipo_producto);
		if(tipoProductoSaved == null) {
			return "El Tipo producto que intentas borrar no existe.";
		} else {
			repo.deleteById(id_tipo_producto);
			return "El Tipo Producto ha sido eliminada exitosamente.";
		}
	}

}
