package com.SandL.api.entity;

import java.io.Serializable;

import com.SandL.api.constraint.DateRangeConstraint;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructors
@Table(name="ingrediente")
public class Ingrediente implements Serializable{

	public Ingrediente() {
		super();
	}

	private static final long serialVersionUID = 1L;

	/* Id del ingrediente. */
	@Id
	@Column(name = "id_ingrediente", unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_ingrediente")
	private Integer idIngrediente;
	
	/* Nombre del producto. */
	@NotNull(message="El nombre es requerido")
	@NotBlank(message = "El nombre no puede ser una secuencia de caracteres vacios")
	@Size(min = 3, max = 200, message 
      = "El nombre debe tener entre 3 y 200 caracteres")
	@Column(name="nombre")
	@JsonProperty("nombre")
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/* Tipo del producto.*/
	//@ManyToOne
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "tipo_producto", referencedColumnName = "id_tipo_producto")
    //@JsonProperty("tipo_producto")
    //@JsonIgnore
    private TipoProducto tipoProducto;
	// le pasaremos ya el TipoProducto desde parametro 
	// para que tenga sus respectivas validaciones
	
	@DateRangeConstraint
    @Valid
    //@JsonIgnore
    private DateRange periodo;
	
	public DateRange getPeriodo() {
		return periodo;
	}

	public void setPeriodo(DateRange periodo) {
		this.periodo = periodo;
	}

	/* Cantidad del producto. */
	@Column(name="cantidad")
	@NotNull(message="La cantidad es requerido")
	@Min(value=0, message="La cantidad debe de ser positivo")
	@JsonProperty("cantidad")
    private int cantidad;
	
	@Column(name="medida")
	@NotNull(message="La medida es requerida")
	@JsonProperty("medida")
    private String medida;
	//con que etiqueta podemos acotar a que sean los gramos, etc
    
    /* Precio del producto. */
	@Column(name="precio")
	@NotNull(message="El precio es requerido")
	@Min(value=1, message="El precio debe de ser positivo, no puede ser 0")
	@JsonProperty("precio")
    private float precio;
	//@Max(value=500, message="El precio no puede ser más de 500")
	
	/* Descripcion del prodcuto. */
	@Column(name="descripcion")
	@JsonProperty("descripcion")
	private String descripcion;
	
	/* Comentario del prodcuto.
	 * Lo acotamos a 1, no queremos una lista. */
	@JsonProperty("comentarios")
	@Column(name="comentarios")
	private String comentarios;
	
	public Integer getIdIngrediente() {
		return idIngrediente;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String getMedida() {
		return medida;
	}

	public float getPrecio() {
		return precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getComentarios() {
		return comentarios;
	}

	public String getProveedor() {
		return proveedor;
	}

	public Integer getStatus() {
		return status;
	}

	public void setIdIngrediente(Integer idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/* Proveedor del prodcuto. */
	@Column(name="proveedor")
	@NotNull(message="El provedor es requerido.")
	@JsonProperty("proveedor")
    private String proveedor;
	
	/* Status del producto. */
	@Column(name="status")
	@Min(value = 0, message="El status debe de ser 1 o 0.")
	@Min(value = 1, message="El status debe de ser 1 o 0.")
	@JsonProperty("status")
	@JsonIgnore
    private Integer status;

    // Nuevo método para obtener solo el campo 'tipo' de 'TipoProducto'
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("tipo_producto")
    public String getTipoProductoString() {
        return (tipoProducto != null) ? tipoProducto.getTipo() : null;
    }
}

