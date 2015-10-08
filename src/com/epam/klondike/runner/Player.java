package com.epam.klondike.runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.epam.exeptions.KlondikeException;
import com.epam.klondike.GameEngine;
import com.epam.klondike.GameEngineImpl;
import com.epam.klondike.GameTable;

public class Player {

    private static GameTable gameTable = new GameTable();
    private static GameEngine gameEngine = new GameEngineImpl(gameTable);

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String input = null;
        System.out.println("-------------------------------------");
        System.out.println("Welcome to Klondike! The best game ever.");
        System.out.println("----------Here are stocks:-----------");
        System.out.println("Su - Stock with up faced cards");
        System.out.println("Sd - Stock with down faced cards");
        System.out.println("T1..T7 - Tableau stocks");
        System.out.println("F1..F4 - Foundation stocks");
        System.out.println("-------Here are your functions:-------");
        System.out.println("GENERATE - generate new table");
        System.out.println("MOVE.<from>.<to> - move card");
        System.out.println("MOVEMANY.<from>.<to> - move many cards");
        System.out.println("OPEN - open one card from stockDown");
        System.out.println("RESET - reset stockDown and stockUp");
        System.out.println("-------------------------------------");
        do {
            try {
                input = reader.readLine();
                
                if (input.toLowerCase().startsWith("GENERATE")) {
                    gameEngine.generateTable();
                } else if (input.toLowerCase().startsWith("MOVE")) {
                    
                } else if (input.toLowerCase().startsWith("MOVEMANY")) {

                } else if (input.toLowerCase().startsWith("OPEN")) {

                } else if (input.toLowerCase().startsWith("RESET")) {

                }
                System.out.println("-------------------------------------");
                System.out.println(gameTable.getState());
                System.out.println("-------------------------------------");
                
            } catch (KlondikeException e) {
                System.out.println(e);
            } catch (IOException e) {
                throw new RuntimeException("Can't read standard input", e);
            }
        } while (!input.toLowerCase().startsWith("q")); // quit
    }

}
