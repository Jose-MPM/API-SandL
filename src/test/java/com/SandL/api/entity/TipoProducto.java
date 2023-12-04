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
	@Column(name = "id_tipo_producto", unique=true)
	@JsonProperty("id_tipo_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipo_producto;
    
	@Column(name="tipo")
	@NotNull(message="El tipo es requerido")
	//@JsonProperty("tipo")
    private String tipo;

    /* Status del tipo del producto . */
	@Column(name="status")
	@Min(value = 0, message="El status debe de ser 1 o 0.")
	@Min(value = 1, message="El status debe de ser 1 o 0.")
	@JsonProperty("status")
	private Integer status;

	@Override
	public String toString() {
		return "TipoProducto [id_tipo_producto=" + id_tipo_producto + ", tipo=" + tipo + ", status=" + status + "]";
	}

	public Integer getId_tipo_producto() {
		return id_tipo_producto;
	}

	public String getTipo() {
		return tipo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setId_tipo_producto(Integer id_tipo_producto) {
		this.id_tipo_producto = id_tipo_producto;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}