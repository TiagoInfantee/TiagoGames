package com.tiagogames.games;

import com.tiagogames.games.Models.Game;
import com.tiagogames.games.Models.Player;
import com.tiagogames.games.Models.Score;
import com.tiagogames.games.Repository.GameRepository;
import com.tiagogames.games.Repository.PlayerRepository;
import com.tiagogames.games.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ScoresController {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/getallscores")
    public String getAllScores(Model model) {
        List<Score> scores = scoreRepository.findAll();
        model.addAttribute("scores", scores);
        return "list-scores";
    }

    @GetMapping("/addscore")
    public String showForm(Model model) {
        model.addAttribute("score", new Score());
        model.addAttribute("games", gameRepository.findAll());
        model.addAttribute("players", playerRepository.findAll());
        return "form-score";
    }

    @PostMapping("/savescore")
    public String addScore(@ModelAttribute Score newScore) {
        Game game = gameRepository.findById(newScore.getGame().getId())
                .orElseThrow(() -> new IllegalArgumentException("Game not found"));
        Player player = playerRepository.findById(newScore.getPlayer().getId())
                .orElseThrow(() -> new IllegalArgumentException("Player not found"));

        newScore.setGame(game);
        newScore.setPlayer(player);

        scoreRepository.save(newScore);
        return "redirect:/addscore?success";
    }

}
