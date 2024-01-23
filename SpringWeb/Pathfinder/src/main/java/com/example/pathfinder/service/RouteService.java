package com.example.pathfinder.service;

import com.example.pathfinder.model.dto.RouteAddDto;
import com.example.pathfinder.model.dto.RouteViewDto;
import com.example.pathfinder.model.entity.Route;

import java.io.IOException;
import java.util.List;

public interface RouteService {
    List<RouteViewDto> findAllRoutes();

    void addRoute(RouteAddDto route) throws IOException;
}
