package com.projeto.treinamento.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.treinamento.spring.entities.EstadoEntity;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoEntity, Integer> {
}
