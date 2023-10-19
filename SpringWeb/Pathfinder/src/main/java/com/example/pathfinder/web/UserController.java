package com.example.pathfinder.web;

import com.example.pathfinder.model.dto.UserLoginDto;
import com.example.pathfinder.model.dto.UserRegisterDto;
import com.example.pathfinder.model.service.UserServiceModel;
import com.example.pathfinder.model.view.UserViewModel;
import com.example.pathfinder.service.UserService;
import com.example.pathfinder.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserController(UserService userService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @ModelAttribute
    public UserRegisterDto userRegisterDto(){
        return new UserRegisterDto();
    }

    @ModelAttribute
    public UserLoginDto userLoginDto(){
        return new UserLoginDto();
    }

    @GetMapping("/register")
    public String register(Model model){
        return "register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegisterDto userRegisterDto,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors() || !userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDto",
                            bindingResult);
            return "redirect:register";
        }

        boolean isExist = userService.findByUsername(userRegisterDto.getUsername()) != null;

        if (!isExist) {
            userService.userRegister(modelMapper.map(userRegisterDto, UserServiceModel.class));
            return "redirect:login";
        }
        return "redirect:register";
    }

    @PostMapping("/login")
    public String loginUser(@Valid UserLoginDto userLoginDto,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addAttribute("userLoginDto", userLoginDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginDto",
                            bindingResult);
            return "redirect:login";
        }

        UserServiceModel user = userService.findByUsernameAndPassword(userLoginDto.getUsername(), userLoginDto.getPassword());

        if (user == null){
            redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginDto",
                            bindingResult);
            return "redirect:login";
        }

        currentUser.setUsername(user.getUsername());
        currentUser.setId(user.getId());

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(){
        userService.logout();

        return "redirect:/";
    }

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable Long id, Model model){
        model.addAttribute("user",
                modelMapper.map(userService.findById(id), UserViewModel.class));
        return "profile";
    }
}
