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
@Table(name = "armazon") //INDICA EL NOMBRE DE LA TABLA EN LA BASE DE DATOS
public class Armazon implements Serializable {

	//INDICA LA LLAVE PRINCIPAL DE LA TABLA, POR DEFECTO EL NOMBRE SERÁ
	//COMO EL DE LA PROPIEDAD
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//SE PUEDEN DECLARAR PROPIEDADES DE LA COLUMNA, AQUI DICE QUE EL CAMPO insumo no recibe vacios
	@NotEmpty
	private String codigo;
	
	//DE IGUAL MANERA LA DESCRIPCIÓN NO RECIBE VACÍOS
	@NotEmpty
	private String modelo;
	
	private String tamaño;
	
	private String color;
	
	private Integer existencia;

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

			
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getTamaño() {
		return tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getExistencia() {
		return existencia;
	}

	public void setRxistencia(Integer existencia) {
		this.existencia = existencia;
	}

	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
		
	



	private static final long serialVersionUID = 1L;
}
