package com.tiagogames.games;

import com.tiagogames.games.Models.Game;
import com.tiagogames.games.Models.Player;
import com.tiagogames.games.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PlayersController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/getallplayers")
    public String getAllPlayers(Model model) {
        List<Player> players = playerRepository.findAll();
        model.addAttribute("players", players);
        return "list-players";
    }

    @GetMapping("/addplayer")
    public String showForm(Model model) {
        model.addAttribute("player", new Player());
        return "form-player";
    }

    @PostMapping("/saveplayer")
    public String addPlayer(@ModelAttribute Player newPlayer) {
        playerRepository.save(newPlayer);
        return "redirect:/addplayer?success";
    }
}