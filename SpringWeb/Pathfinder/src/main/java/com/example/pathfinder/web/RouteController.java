package com.example.pathfinder.web;


import com.example.pathfinder.model.dto.RouteAddDto;
import com.example.pathfinder.model.dto.RouteViewDto;
import com.example.pathfinder.model.entity.Route;
import com.example.pathfinder.service.RouteService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final ModelMapper modelMapper;

    public RouteController(RouteService routeService, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String routes(Model model){

        List<RouteViewDto> allRoutes = routeService.findAllRoutes();

        model.addAttribute("routeView", allRoutes);
        return "routes";
    }

    @GetMapping("/add")
    public String add(){
        return "add-route";
    }

    @PostMapping("/add")
    private String addRoute(@Valid RouteAddDto routeAddDto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) throws IOException {
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("routeAddDto", routeAddDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.routeAddDto",
                            bindingResult);
            return "redirect:add";
        }
        routeService.addRoute(routeAddDto);

        return "redirect:all";
    }

    @GetMapping("details/{id}")
    public String details(@PathVariable Long id){
        return "route-details";
    }

    @ModelAttribute
    public RouteAddDto routeAddDto(){
        return new RouteAddDto();
    }
}
