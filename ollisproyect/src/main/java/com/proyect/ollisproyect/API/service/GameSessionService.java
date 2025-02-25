package com.proyect.ollisproyect.API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.ollisproyect.API.model.GameSession;
import com.proyect.ollisproyect.API.repository.GameSessionRepository;

@Service
public class GameSessionService {

    @Autowired
    private GameSessionRepository gameSessionRepository;

    public List<GameSession> getGameSession() {
        return gameSessionRepository.findAll();
    }

    public Optional<GameSession> getGameSessionForId(Long id) {
        return gameSessionRepository.findById(id);
    }

    public GameSession saveGameSession(GameSession gameSession) {
        return gameSessionRepository.save(gameSession);
    }

    public GameSession updateGameSession(Long id, GameSession gameSessionUpdated) {
        return gameSessionRepository.findById(id).map(gameSession -> {
            gameSession.setName(gameSessionUpdated.getName());
            gameSession.setTimePlayed(gameSessionUpdated.getTimePlayed());
            return gameSessionRepository.save(gameSession);
        }).orElseThrow(() -> new RuntimeException("GameSession not found"));
    }

    public void deleteGameSession(Long id) {
        gameSessionRepository.deleteById(id);
    }
}
