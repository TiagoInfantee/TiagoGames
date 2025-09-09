package com.tiagogames.games;

import com.tiagogames.games.Models.Game;
import org.springframework.ui.Model;
import com.tiagogames.games.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GamesController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/getallgames")
    public String getAllGames(Model model) {
        List<Game> games = gameRepository.findAll();
        model.addAttribute("games", games);
        return "list-games";
    }

    @GetMapping("/addgame")
    public String showForm(Model model) {
        model.addAttribute("game", new Game());
        return "form-game";
    }

    @PostMapping("/savegame")
    public String addGame(@ModelAttribute Game newGame) {
        gameRepository.save(newGame);
        return "redirect:/addgame?success";
    }

}
