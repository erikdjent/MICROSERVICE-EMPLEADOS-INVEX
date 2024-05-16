package com.mx.invex.empleados.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "empleados")
public @Data class Empleados implements Serializable{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = -4892120842397901254L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "ID_EMPLEADO")
	private Long id;
	
	@Column(name = "PRIMER_NOMBRE")
	private String primerNombre;
	
	@Column(name = "SEGUNDO_NOMBRE")
	private String segundoNombre;
	
	@Column(name = "APELLIDO_PATERNO")
	private String primerApellido;
	
	@Column(name = "APELLIDO_MATERNO")
	private String segundoApellido;
	
	@Column(name = "EDAD")
	private Integer edad;
	
	@Column(name = "SEXO")
	private String sexo;
	
	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;
	
	@Column(name = "PUESTO")
	private String puesto;

}
