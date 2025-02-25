package com.proyect.ollisproyect.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyect.ollisproyect.API.model.GameSession;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {

}
