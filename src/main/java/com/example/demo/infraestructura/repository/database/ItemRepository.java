package com.example.demo.infraestructura.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.infraestructura.dto.ItemDto;

@Repository
public interface ItemRepository extends JpaRepository<ItemDto, Long > {

}
