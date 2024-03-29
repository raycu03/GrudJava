package com.example.demo.infraestructura.repository.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.infraestructura.dto.ProductoDto;
@Repository
public interface ProductoRepository extends JpaRepository<ProductoDto, Long >{
	
	public List<ProductoDto> findByCodigo(String codigo);

}
