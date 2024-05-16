package com.mx.invex.empleados.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.invex.empleados.model.Empleados;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleados, Long>{
	
}
