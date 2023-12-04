package com.SandL.api.service;

import java.util.List;

import com.SandL.api.entity.TipoProducto;

public interface SvcTipoProducto {
	
	List<TipoProducto> getTiposProductos();
	
	TipoProducto getTipoProducto(Integer id_tipo_producto);
	
	String createTipoProducto(TipoProducto tipoProducto);
	
	String updateTipoProducto(Integer id_tipo_producto, TipoProducto tipoProducto);
	
	String deleteTipoProducto(Integer id_tipo_producto);
}
