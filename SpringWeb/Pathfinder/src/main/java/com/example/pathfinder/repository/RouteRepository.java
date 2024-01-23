package com.example.pathfinder.repository;

import com.example.pathfinder.model.entity.Route;
import com.example.pathfinder.model.entity.enums.LevelEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    Optional<Route> findByLevel(LevelEnum level);
}
