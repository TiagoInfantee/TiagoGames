package com.tiagogames.games.Repository;

import com.tiagogames.games.Models.Game;
import com.tiagogames.games.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
