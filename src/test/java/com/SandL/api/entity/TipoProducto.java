package com.SandL.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Clase para representar un INVENTARIO(de productos) de SyL.
 */
@Entity
@Table(name="tipo_producto")
public class TipoProducto{

	@Id
	@Column(name = "idTipoProducto", unique=true)
	@JsonProperty("id_tipo_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoProducto;
    
	@Column(name="tipo")
	@NotNull(message="El tipo es requerido")
	//@JsonProperty("tipo")
    private String tipo;

    /* Status del tipo del producto. */
	@Column(name="status")
	@Min(value = 0, message="El status debe de ser 1 o 0.")
	@Min(value = 1, message="El status debe de ser 1 o 0.")
	@JsonProperty("status")
	
    private Integer status;
    
	public Long getIdTipoProducto() {
		return idTipoProducto;
	}

	@Override
	public String toString() {
		return "TipoProducto [idTipoProducto=" + idTipoProducto + ", tipo=" + tipo + ", status=" + status + "]";
	}

	public String getTipo() {
		return tipo;
	}

	public void setIdTipoProducto(Long idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}