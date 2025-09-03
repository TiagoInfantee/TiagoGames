package com.tiagogames.games.Repository;

import com.tiagogames.games.Models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository <Game , Integer> {
}
