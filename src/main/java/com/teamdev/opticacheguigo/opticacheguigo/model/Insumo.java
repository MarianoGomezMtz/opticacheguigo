package com.teamdev.opticacheguigo.opticacheguigo.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "insumos") //INDICA EL NOMBRE DE LA TABLA EN LA BASE DE DATOS
public class Insumo implements Serializable {

	//INDICA LA LLAVE PRINCIPAL DE LA TABLA, POR DEFECTO EL NOMBRE SERA
	//COMO EL DE LA PROPIEDAD
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//SE PUEDEN DECLARAR PROPIEDADES DE LA COLUMNA, AQUI DICE QUE EL CAMPO insumo no recibe vacios
	@NotEmpty
	private String insumo;
	
	//DE IGUAL MANERA LA DESCRIPCION NO RECIBE VACIOS
	@NotEmpty
	private String descrcipcion;

	//AQUI TAMPOCO
	@NotEmpty
	private Integer status;

	
	@NotNull
	//DE ESTA MANERA SE ESPECIFICA EL NOMBRE DE LA COLUMNA EN LA BASE DE DATOS
	@Column(name = "create_at")
	//AQUI ESPECIFICAMOS EL TIPO DE DATO EN LA BD
	@Temporal(TemporalType.DATE)
	//ESTE ES EL FORMATO DE INGRESO POR EL USUARIO PARA INSERTAR EN LA BD
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;

	//METODO QUE ESTABLECE VALORES POR DEFECTO PARA LOS CAMPOS NECESARIOS
	//EJEMPLO FECHA Y ESTATUS
	@PrePersist
	public void prePersist() {
		createAt = new Date();
		status = 1;
	}
	
	//CONJUNTO DE GETTERS Y SETTERS PARA ENVIO Y OBTENCION DE LOS CAMPOS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

			
	public String getDescrcipcion() {
		return descrcipcion;
	}

	public void setDescrcipcion(String descrcipcion) {
		this.descrcipcion = descrcipcion;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
		
	public String getInsumo() {
		return insumo;
	}

	public void setInsumo(String insumo) {
		this.insumo = insumo;
	}



	private static final long serialVersionUID = 1L;
}
