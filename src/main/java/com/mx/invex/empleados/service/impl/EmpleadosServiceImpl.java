package com.mx.invex.empleados.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.invex.empleados.model.Empleados;
import com.mx.invex.empleados.repositories.EmpleadoRepository;
import com.mx.invex.empleados.service.EmpleadosService;

@Service
public class EmpleadosServiceImpl implements EmpleadosService {
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	
	@Override
	public List<Empleados> getEmpleados() {
		return empleadoRepository.findAll();
	}


	@Override
	public void deleteEmpleados(Empleados empleados) {
		empleadoRepository.delete(empleados);
		
	}


	@Override
	public List<Empleados> saveEmpleados(List<Empleados> empleados) {
		return empleadoRepository.saveAll(empleados);
	}


	@Override
	public Empleados getEmpleadoById(Long idEmpleado) {
		return empleadoRepository.getById(idEmpleado);
	}

}
