package com.mx.invex.empleados.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.mx.invex.empleados.model.Empleados;
import com.mx.invex.empleados.service.EmpleadosService;

import io.swagger.annotations.Api;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping (value = "api")
@Api(value = "Empleados services", tags = " Empleados Services")
public class EmpleadosController {
	
	@Autowired
	EmpleadosService empleadosService;
	
	@GetMapping(value = "/getEmpleados", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Empleados>> getEmpleados(){
		List<Empleados> list = empleadosService.getEmpleados();
		return new ResponseEntity<List<Empleados>>(list,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteEmpleado", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Empleados>> deleteEmpleados(@RequestParam (name = "id", required = true) Long idEmpleado){
		empleadosService.deleteEmpleados(empleadosService.getEmpleadoById(idEmpleado));
		return new ResponseEntity<List<Empleados>>(HttpStatus.OK);
	}
	
	@PatchMapping(value = "/updateEmpleados", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Empleados>> updateEmpleados(@RequestBody Empleados empleado){
		List<Empleados> empleadosUpdate = new ArrayList<>();
		empleadosUpdate.add(empleado);
		List<Empleados> list = empleadosService.saveEmpleados(empleadosUpdate);
		return new ResponseEntity<List<Empleados>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/saveEmpleados", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Empleados>> saveEmpleados(@RequestBody List<Empleados> empleado){
		List<Empleados> list = empleadosService.saveEmpleados(empleado);
		return new ResponseEntity<List<Empleados>>(list,HttpStatus.OK);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	  public ResponseEntity<String> handleNoSuchElementFoundException(
			  MethodArgumentTypeMismatchException exception
	  ) {
	    return ResponseEntity
	        .status(HttpStatus.BAD_REQUEST)
	        .body(exception.getMessage());
	  }
	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	  public ResponseEntity<String> handleNoSuchElementFoundException(
			  HttpMediaTypeNotSupportedException exception
	  ) {
	    return ResponseEntity
	        .status(HttpStatus.BAD_REQUEST)
	        .body(exception.getMessage());
	  }

}
