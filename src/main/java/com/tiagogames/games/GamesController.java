package com.tiagogames.games;

import com.tiagogames.games.Models.Game;
import com.tiagogames.games.Repository.GameRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GamesController {

    private final GameRepository gameRepository;

    public GamesController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/getallgames")
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @PostMapping("/addgame")
    public Game addGame(Game newGame){

        newGame = (new Game( "Rocket League", "Football", 2015, 8.5));

        return gameRepository.save(newGame);
    }

}
