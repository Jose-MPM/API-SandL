package com.SandL.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SandL.api.entity.TipoProducto;

import jakarta.transaction.Transactional;

@Repository
public interface RepoTipoProducto extends JpaRepository<TipoProducto, Integer> {
    // Métodos personalizados si son necesarios
	/**
	 * Cosas importantes:
	 * @Transactional  indica que es transaccional 
	 * @Modifying indica que este query es de modificacion
	 */
	
	/**
	 * Regresa una lista con todos los tipos productos activos de nuestro inventario.
	 * @return una lista con todos los productos en nuestra base.
	 */
	//WHERE stock_inicial > 0
	@Query(value= "SELECT * FROM tipo_producto WHERE status = :status", nativeQuery = true)
	List<TipoProducto> findByStatus(@Param("status") Integer status);
	
	
	/**
	 * Consulta de un TipoProducto por su id siempre y cuando este activo
	 * @return el TIPO PRODUCTO del en nuestra base.
	 */
	//WHERE stock_inicial > 0
	@Query(value= "SELECT * FROM tipo_producto WHERE id_tipo_producto = :id_tipo_producto AND status = 1", nativeQuery = true)
	TipoProducto findByTipoProductoId(@Param("id_tipo_producto") Integer id_tipo_producto);
	
	/**
	 * Buscar los TipoProductos con este tipo.
	 * @return el TIPO PRODUCTO del en nuestra base.
	 */
	@Query(value= "SELECT * FROM tipo_producto WHERE tipo = :tipo", nativeQuery = true)
	TipoProducto findByTipoProducto(@Param("tipo") String tipo);
	
	/**
	 * Buscar los TipoProductos con este tipo.
	 * @return el TIPO PRODUCTO del en nuestra base.
	 */
	@Transactional 
	@Modifying
	@Query(value= "INSERT INTO tipo_producto (tipo) VALUES(:tipo, 1)", nativeQuery = true)
	void createTipoProducto(@Param("tipo") String tipo); // nos devolvera el TipoProducto que estamos insertando
	
	/**
	 * Buscar los TipoProductos con este tipo.
	 * @return el TIPO PRODUCTO del en nuestra base.
	 */
	@Transactional 
	@Modifying
	@Query(value= "UPDATE tipo_producto SET tipo = :tipo WHERE id_tipo_producto = :id_tipo_producto", nativeQuery = true)
	Integer updateTipoProducto(@Param("id_tipo_producto") Integer id_tipo_producto, @Param("tipo") String tipo); // el integer nos permite saber cuantas cosas actualizo 0 SI NO actualizo nada
	
	/**
	 * Buscar los TipoProductos con este tipo.
	 * @return el TIPO PRODUCTO del en nuestra base.
	 */
	@Transactional 
	@Modifying
	@Query(value= "UPDATE tipo_producto SET status = 1 WHERE id_tipo_producto = :id_tipo_producto", nativeQuery = true)
	void activateTipoProducto(@Param("id_tipo_producto") Integer id_tipo_producto); 
	
	/**
	 * Buscar los TipoProductos con este tipo.
	 * @return el TIPO PRODUCTO del en nuestra base.
	 */
	@Transactional 
	@Modifying
	@Query(value= "UPDATE tipo_producto SET status = 0 WHERE id_tipo_producto = :id_tipo_producto", nativeQuery = true)
	void deleteById(@Param("id_tipo_producto") Integer id_tipo_producto); // el integer nos permite saber cuantas cosas actualizo 0 SI NO actualizo nada
	
	// save literal es una insercion
	// 
}
