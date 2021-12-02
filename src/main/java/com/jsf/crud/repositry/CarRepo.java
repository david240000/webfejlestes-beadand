package com.jsf.crud.repositry;

import com.jsf.crud.entity.CarDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<CarDTO, Long> {
}