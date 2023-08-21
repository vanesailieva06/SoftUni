package com.example.automappingobjects.config;

import com.example.automappingobjects.model.dto.AddGameDto;
import com.example.automappingobjects.model.entity.Game;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper mapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(AddGameDto.class, Game.class)
                .addMappings(mapper ->
                        mapper.map(AddGameDto::getThumbnailURL, Game::setImageThumbnailUrl));
        return modelMapper;
    }
}
