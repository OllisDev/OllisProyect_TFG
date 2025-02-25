package com.proyect.ollisproyect.API.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.ollisproyect.API.model.GameSession;
import com.proyect.ollisproyect.API.service.GameSessionService;

@RestController
@RequestMapping("/api/games")
public class GameSessionController {

    @Autowired
    private GameSessionService gameSessionService;

    @GetMapping
    public List<GameSession> getAllSessions() {
        return gameSessionService.getGameSession();
    }

    @GetMapping("/{id}")
    public Optional<GameSession> getSessionForId(@PathVariable Long id) {
        return gameSessionService.getGameSessionForId(id);
    }

    @PostMapping
    public GameSession addSession(@RequestBody GameSession gameSession) {
        return gameSessionService.saveGameSession(gameSession);
    }

    @PutMapping("/{id}")
    public GameSession updateSession(@PathVariable Long id, @RequestBody GameSession gameSession) {
        return gameSessionService.updateGameSession(id, gameSession);
    }

    @DeleteMapping("{id}")
    public void deleteSession(@PathVariable Long id) {
        gameSessionService.deleteGameSession(id);
    }
}
