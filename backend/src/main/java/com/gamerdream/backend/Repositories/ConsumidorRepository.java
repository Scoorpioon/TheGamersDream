package com.gamerdream.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamerdream.backend.Models.Usuarios.Consumidor;

@Repository
public interface ConsumidorRepository extends JpaRepository<Consumidor, Long> {
    
}