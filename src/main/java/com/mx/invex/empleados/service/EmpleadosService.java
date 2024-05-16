package com.mx.invex.empleados.service;

import java.util.List;

import com.mx.invex.empleados.model.Empleados;

public interface EmpleadosService {
	
	public List<Empleados> getEmpleados();
	
	public Empleados getEmpleadoById(Long idEmpleado);
	
	public void deleteEmpleados(Empleados empleados);
	
	public List<Empleados> saveEmpleados(List<Empleados> empleados);

}
