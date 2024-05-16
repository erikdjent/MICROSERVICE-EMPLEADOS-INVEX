package com.mx.invex.empleados.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;


import com.mx.invex.empleados.model.Empleados;
import com.mx.invex.empleados.repositories.EmpleadoRepository;
import com.mx.invex.empleados.service.EmpleadosService;

@ExtendWith(MockitoExtension.class)
class EmpleadosControllerTest {

	@InjectMocks
	EmpleadosController empleadosController;

	
	@Mock
	EmpleadosService empleadosService;

	@Test
	public void testGetEmpleados() {
		Empleados empleado = new Empleados(null, null, null, null, null, null, null, null, null);
		Empleados empleado2 = new Empleados(null, null, null, null, null, null, null, null, null);

		List<Empleados> empleados = new ArrayList<>();
		empleados.add(empleado);
		empleados.add(empleado2);
		when(empleadosService.getEmpleados()).thenReturn(empleados);

		ResponseEntity<List<Empleados>> result = empleadosController.getEmpleados();

		assertThat(result.getBody().size()>0);
	}
	
//	@Test
//	public void testDeleteEmpleados() {
//		Empleados empleado = new Empleados(10L, null, null, null, null, null, null, null, null);
//		Empleados empleado2 = new Empleados(10L, null, null, null, null, null, null, null, null);
//		when(empleadosService.getEmpleadoById(10L)).thenReturn(empleado2);
//		empleadosService.deleteEmpleados(empleado);
//		verify(empleadoRepository).delete(empleado);; 
//	}
	
	@Test
	public void testUpdateEmpleados() {
		Empleados empleado = new Empleados(null, null, null, null, null, null, null, null, null);
		List<Empleados> empleados = new ArrayList<>();
		empleados.add(empleado);
		when(empleadosService.saveEmpleados(empleados)).thenReturn(empleados);
		ResponseEntity<List<Empleados>> result = empleadosController.updateEmpleados(empleado);
		assertThat(result.getBody().size()>0);
	}
	
	@Test
	public void testSaveEmpleados() {
		Empleados empleado = new Empleados(null, null, null, null, null, null, null, null, null);
		List<Empleados> empleados = new ArrayList<>();
		empleados.add(empleado);
		when(empleadosService.saveEmpleados(empleados)).thenReturn(empleados);
		ResponseEntity<List<Empleados>> result = empleadosController.saveEmpleados(empleados);
		assertThat(result.getBody().size()>0);
	}

}
