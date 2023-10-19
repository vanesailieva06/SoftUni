package com.example.shoppinglist.web;

import com.example.shoppinglist.model.dto.UserLoginDto;
import com.example.shoppinglist.model.dto.UserRegisterDto;
import com.example.shoppinglist.model.entity.User;
import com.example.shoppinglist.service.UserService;
import com.example.shoppinglist.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/register")
    public String register(){
        return "register";
    }


    @ModelAttribute
    public UserRegisterDto userRegisterDto(){
        return new UserRegisterDto();
    }
    @ModelAttribute
    public UserLoginDto userLoginDto(){
        return new UserLoginDto();
    }
    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("isExist");
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegisterDto userRegisterDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors() || !userRegisterDto.getPassword().equals(
                userRegisterDto.getConfirmPassword()
        )){
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDto",
                            bindingResult);
            return "redirect:register";
        }

        boolean isExist = userService.findByUsername(userRegisterDto.getUsername()) != null;

        if (isExist){
            return "redirect:register";
        }

        userService.registerUser(modelMapper.map(userRegisterDto, User.class));
        return "redirect:login";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @PostMapping("/login")
    public String loginUser(@Valid UserLoginDto userLoginDto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return addAttributes(userLoginDto, bindingResult, redirectAttributes);
        }
        User user = userService.findByUsernameAndPassword(userLoginDto.getUsername(), userLoginDto.getPassword());
        boolean isExist = user != null;

        if (!isExist){
            redirectAttributes.addFlashAttribute("isExist", false);
            return addAttributes(userLoginDto, bindingResult, redirectAttributes);
        }
        currentUser.setId(user.getId());
        currentUser.setUsername(user.getUsername());

        return "redirect:/";
    }

    private static String addAttributes(UserLoginDto userLoginDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto)
                .addFlashAttribute("org.springframework.validation.BindingResult.userLoginDto",
                        bindingResult);
        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout(){
        userService.logout();

        return "redirect:/";
    }
}
