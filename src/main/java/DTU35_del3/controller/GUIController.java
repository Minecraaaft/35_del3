package DTU35_del3.controller;

import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

import static DTU35_del3.Message.getMessage;

public class GUIController {
    private GUI_Player[] GUIplayers;
    private GUI_Car[] cars = {  new GUI_Car(Color.green, Color.BLACK, GUI_Car.Type.UFO, GUI_Car.Pattern.FILL),
                                new GUI_Car(Color.red, Color.BLACK, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.FILL),
                                new GUI_Car(Color.CYAN, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL),
                                new GUI_Car(Color.yellow, Color.BLACK, GUI_Car.Type.RACECAR, GUI_Car.Pattern.FILL)
    };

    private GUI_Field[] fields = {
            new GUI_Start("START", "", "",  Color.RED, Color.WHITE),
            new GUI_Brewery("src/main/java/Pictures/Burger.jpg", "Burgerbaren", "1M", "", "1", new Color(112, 75, 0), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Pizza.jpg", "Pizzariaet", "1M", "", "1", new Color(112, 75, 0), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Chance.jpg", "Chance", "", "", "", new Color(235, 156, 48), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Slik.jpg", "Slikbutikken", "1M", "", "1", new Color(135, 206, 235), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Is.jpg", "Isbutikken", "1M", "", "1", new Color(135, 206, 235), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/På_besøg.jpg", "På Besøg", "", "", "", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Museum.jpg", "Museet", "2M", "", "2", Color.PINK, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Bog.jpg", "Biblioteket", "2M", "", "2", Color.PINK, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Chance.jpg", "Chance", "", "", "", new Color(235, 156, 48), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Skater.jpg", "Skaterparken", "2M", "", "2", Color.ORANGE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Svømmer.jpg", "Svømmehallen", "2M", "", "2", Color.ORANGE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Gratis_parkering.jpg", "Gratis ", "parkering", "", "", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Arcade.jpg", "Spillehalle", "3M", "", "3", new Color(235, 80, 59), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Biograf.jpg", "Biografen", "3M", "", "3", new Color(235, 80, 59), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Chance.jpg", "Chance", "", "", "", new Color(235, 156, 48), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Legetøj.jpg", "Legetøjsbutiken", "3M", "", "3", Color.YELLOW, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Dyrehandel.jpg", "Dyrehandlen", "3M", "", "3", Color.YELLOW, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Gå_i_fængsel.jpg", "Gå i", "fængsel", "", "", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Bowling.jpg", "Bowlinghallen", "4M", "", "4", new Color(5, 118, 8), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Zoo.jpg", "Zoo", "4M", "", "4", new Color(5, 118, 8), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Chance.jpg", "Chance", "", "", "", new Color(235, 156, 48), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Vandland.jpg", "Vandlandet", "5M", "", "5", new Color(45, 113, 235), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Strand.jpg", "Strandpromenaden", "5M", "", "5", new Color(45, 113, 235), Color.BLACK)
    };

    private GUI gui = new GUI(fields);

    public String[] startMenu() {
        int players = gui.getUserInteger(getMessage("start menu", 1), 2, 4);
        int fejl=0;
        while (true) {
            if (players > 1 && players < 5){
                break;
            }
            else{
                gui.showMessage(getMessage("fejlbesked", 1));
                players = gui.getUserInteger(getMessage("start menu", 1), 2, 4);
            }
        }

        int balance=0;
        if (players == 2) {
            balance = 20;
        } else if (players == 3) {
            balance = 18;
        } else if (players == 4) {
            balance = 16;
        }

        //requests names and stores them in an array which then is returned at end of method
        String[] names = new String[players];
        for (int i = 0; i < players; i++) {
            names[i] = gui.getUserString(getMessage("start menu", 2) + (i+1) + getMessage("start menu", 3));
        }

        //checks for empty name
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals("")){
                names[i] = "Mr. nobody" + (i+1);
            }
        }

        //checks for same name and gives players new names
        for (int i = 0; i < names.length-1; i++) {
            if (names[i].equals(names[i+1]) && names[i].equals("Player " + (i+1))){
                names[i] = "Colle";
            }
            else if (names[i].equals(names[i+1])) {
                    names[i] = "Player " + (i+1);
                }
            }


        //players are added to the board
        GUIplayers = new GUI_Player[names.length];
        for (int i = 0; i < players; i++) {
            GUIplayers[i] = new GUI_Player(names[i], balance, cars[i]);
            gui.addPlayer(GUIplayers[i]);
            fields[0].setCar(GUIplayers[i], true);
        }

        return names;

    }


    //makes an animation of player's piece moving
    public void movePlayer(String name, int balance, int from, int to) {
        //finds the player with that name
        GUI_Player choosenPlayer = null;
        for (GUI_Player p: GUIplayers) {
            if (p.getName().equals(name)){
               choosenPlayer = p;
            }
        }
        //move player one square forthward at a time
        for (int i = from; i != to; i = (i + 1) %24) {
            sleep(300);
            fields[i].setCar(choosenPlayer,false);
            if (i == 23) {
                fields[0].setCar(choosenPlayer, true);
                updateBalance(name, balance);
            } else
                fields[i+1].setCar(choosenPlayer, true);

        }
    }


    public void updateBalance(String name, int balance) {
        //finds the player with that name
        GUI_Player choosenPlayer = null;
        for (GUI_Player p: GUIplayers) {
            if (p.getName().equals(name)){
                choosenPlayer = p;
            }
        }

        choosenPlayer.setBalance(balance);
    }

    //shows the street is bought and by whom
    public void buyStreet(String name, int pos) {
        //finds the player with that name an gets the color
        Color carColor = null;
        for (GUI_Player p: GUIplayers) {
            if (p.getName().equals(name)){
                carColor = p.getCar().getPrimaryColor();
            }
        }

        ((GUI_Brewery) fields[pos]).setBorder(carColor);
    }

    //moves player to jail
    //player position in gameLogic has to change after using this method
    public void moveToJail(String name, int currentPos) {
        //finds the player with that name
        GUI_Player choosenPlayer = null;
        for (GUI_Player p: GUIplayers) {
            if (p.getName().equals(name)){
                choosenPlayer = p;
            }
        }

        fields[currentPos].setCar(choosenPlayer, false);
        fields[6].setCar(choosenPlayer, true);
    }

    public void displayChanceCard(String message) {
        gui.displayChanceCard(message);
    }

    public void diceMenu(int value, String name) {
        gui.getUserButtonPressed(getMessage("general", 1) + " " + name + getMessage("general", 2), getMessage("general", 3));
        gui.setDie(value);
    }

    public void showGUIMessage(String message) {
        gui.showMessage(message);
    }



    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {

        }
    }
    public int requestInteger(String msg, int min, int max){
        return gui.getUserInteger(msg,min,max);
    }
    public String requestOption(String msg0,String msg1, String msg2){
        return gui.getUserSelection(msg0,msg1,msg2);
    }
    public String requestField2(String msg0,String[] msg1){
        return gui.getUserSelection(msg0,msg1);
    }




}
