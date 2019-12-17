package com.example.demo.infraestructura.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.infraestructura.dto.FacturaDto;


public interface FacturaRepository extends JpaRepository<FacturaDto, Long >{

}
