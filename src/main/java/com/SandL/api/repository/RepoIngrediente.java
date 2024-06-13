package com.SandL.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.SandL.api.entity.Ingrediente;

import jakarta.transaction.Transactional;

public interface RepoIngrediente extends JpaRepository<Ingrediente, Integer> {
	
	/**
	 * Regresa una lista con todos los tipos productos activos de nuestro inventario.
	 * @return una lista con todos los productos en nuestra base.
	 */
	//WHERE stock_inicial > 0
	@Query(value= "SELECT * FROM ingrediente WHERE status = :status", nativeQuery = true)
	List<Ingrediente> getIngredientes(@Param("status") Integer status);
	
	
	List<Ingrediente> findByStatus(Integer status);
	
	//@Transactional 
	//@Modifying
	//@Query(value= "UPDATE ingrediente SET nombre = :nombre " +
			//		"+"+
		//	 "WHERE id_tipo_producto = :id_tipo_producto", nativeQuery = true)
	//Integer updateTipoProducto(@Param("id_tipo_producto") Integer id_tipo_producto, @Param("tipo") String tipo); // el integer nos permite saber cuantas cosas actualizo 0 SI NO actualizo nada
	
	

}
