package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.dto.RouteAddDto;
import com.example.pathfinder.model.dto.RouteViewDto;
import com.example.pathfinder.model.entity.Route;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.service.CategoryService;
import com.example.pathfinder.service.RouteService;
import com.example.pathfinder.service.UserService;
import com.example.pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public RouteServiceImpl(RouteRepository repository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.routeRepository = repository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public List<RouteViewDto> findAllRoutes() {
        return routeRepository.findAll()
                .stream().map(route -> {
                    RouteViewDto routeViewDto = modelMapper.map(route, RouteViewDto.class);
                    routeViewDto.setPictureUrl(route.getPictures().size() == 0 ?
                            "/images/pic4.jpg" : route.getPictures().stream().findFirst().get().getUrl());
                    return routeViewDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void addRoute(RouteAddDto route) throws IOException {
        Route currentRoute = modelMapper.map(route, Route.class);
        currentRoute.setAuthor(userService.findByID(currentUser.getId()));
        currentRoute.setCategories(route.getCategories()
                .stream().map(categoryService::findByName)
                .collect(Collectors.toSet()));
       currentRoute.setGpxCoordinates(new String(route.getGpxCoordinates().getBytes()));
       currentRoute.setLevel(route.getLevel());
       routeRepository.save(currentRoute);
    }
}
