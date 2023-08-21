package com.example.automappingobjects;

import com.example.automappingobjects.model.dto.AddGameDto;
import com.example.automappingobjects.model.dto.UserLoginDto;
import com.example.automappingobjects.model.dto.UserRegisterDto;
import com.example.automappingobjects.service.GameService;
import com.example.automappingobjects.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final BufferedReader reader;
    private final UserService userService;
    private final GameService gameService;

    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        while (true){
            System.out.println("Please enter your commands");
            String[] commands = reader.readLine().split("\\|");
            switch (commands[0]){
                case "RegisterUser" -> userService.registerUser(
                        new UserRegisterDto(commands[1], commands[2], commands[3], commands[4])
                );
                case "LoginUser" -> userService.loginUser(new UserLoginDto(commands[1], commands[2]));
                case "Logout" -> userService.logout();
                case "AddGame" -> gameService.addGame(new AddGameDto(commands[1],
                        new BigDecimal(commands[2]), Double.parseDouble(commands[3]) , commands[4], commands[5], commands[6], commands[7]));
            }
        }
    }
}
