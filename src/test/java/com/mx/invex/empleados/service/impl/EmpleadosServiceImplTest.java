package com.mx.invex.empleados.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mx.invex.empleados.controller.EmpleadosController;
import com.mx.invex.empleados.model.Empleados;
import com.mx.invex.empleados.repositories.EmpleadoRepository;

@ExtendWith(MockitoExtension.class)
class EmpleadosServiceImplTest {
	
	
	@InjectMocks
	EmpleadosServiceImpl empleadosServiceImpl;
	
	@Mock
	EmpleadoRepository empleadoRepository;

	@Test
	void testGetEmpleados() {
		when(empleadoRepository.findAll()).thenReturn(new ArrayList<>());
		List<Empleados> list = empleadosServiceImpl.getEmpleados();
		assertThat(list.size()>0);
	}

//	@Test
//	void testDeleteEmpleados() {
//		fail("Not yet implemented");
//	}

	@Test
	void testSaveEmpleados() {
		List<Empleados> list = new ArrayList<>();
		list.add(new Empleados());
		when(empleadoRepository.saveAll(list)).thenReturn(new ArrayList<>());
		List<Empleados> list2 = empleadosServiceImpl.saveEmpleados(list);
		assertThat(list2.size()>0);
	}

	@Test
	void testGetEmpleadoById() {
		when(empleadoRepository.getById(0L)).thenReturn(new Empleados());
		Empleados empleado = empleadosServiceImpl.getEmpleadoById(0L);
		assertThat(empleado);
	}

}
