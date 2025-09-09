package com.tiagogames.games.Repository;

import com.tiagogames.games.Models.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Integer> {
}
