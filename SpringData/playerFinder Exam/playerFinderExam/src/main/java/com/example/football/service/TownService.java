package com.example.football.service;

public interface TownService {

    boolean areImported();

    String readTownsFileContent() ;
	
	String importTowns();

}
