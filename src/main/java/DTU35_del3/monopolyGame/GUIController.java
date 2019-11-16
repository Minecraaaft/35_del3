package DTU35_del3.monopolyGame;

import DTU35_del3.board.Board;
import DTU35_del3.player.Player;
import gui_fields.*;
import gui_main.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GUIController {
    private GameLogic gameLogic = new GameLogic();
    private GUI_Player[] GUIplayers;
    private GUI_Car[] cars = {  new GUI_Car(Color.green, Color.BLACK, GUI_Car.Type.UFO, GUI_Car.Pattern.FILL),
                                new GUI_Car(Color.red, Color.BLACK, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.FILL),
                                new GUI_Car(Color.CYAN, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL),
                                new GUI_Car(Color.yellow, Color.BLACK, GUI_Car.Type.RACECAR, GUI_Car.Pattern.FILL)
    };


    private GUI_Field[] fields = {
            new GUI_Start("START", "", "",  Color.RED, Color.WHITE),
            new GUI_Brewery("src/main/java/Pictures/Burger.jpg", "Burgerbaren", "1M","","1", new Color(112, 75, 0), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Pizza.jpg", "Pizzariaet", "1M","","1", new Color(112, 75, 0), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Chance.jpg", "Chance", "","","", new Color(235, 156, 48), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Slik.jpg", "Slikbutikken", "1M","","1", new Color(135, 206, 235), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Is.jpg", "Isbutikken", "1M","","1", new Color(135, 206, 235), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/På_besøg.jpg", "På Besøg", "","","", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Museum.jpg", "Museet", "2M","","2", Color.PINK, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Bog.jpg", "Biblioteket", "2M","","2", Color.PINK, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Chance.jpg", "Chance", "","","", new Color(235, 156, 48), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Skater.jpg", "Skaterparken", "2M","","2", Color.ORANGE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Svømmer.jpg", "Svømmehallen", "2M","","2", Color.ORANGE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Gratis_parkering.jpg", "Gratis ", "parkering","","", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Arcade.jpg", "Spillehalle", "3M","","3", new Color(235, 80, 59), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Biograf.jpg", "Biografen", "3M","","3", new Color(235, 80, 59), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Chance.jpg", "Chance", "","","", new Color(235, 156, 48), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Legetøj.jpg", "Legetøjsbutiken", "3M","","3", Color.YELLOW, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Dyrehandel.jpg", "Dyrehandlen", "3M","","3", Color.YELLOW, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Gå_i_fængsel.jpg", "Gå i", "fængsel","","", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Bowling.jpg", "Bowlinghallen", "4M","","4", new Color(5, 118, 8), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Zoo.jpg", "Zoo", "4M","","4", new Color(5, 118, 8), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Chance.jpg", "Chance", "","","", new Color(235, 156, 48), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Vandland.jpg", "Vandlandet", "4M","","4", new Color(45, 113, 235), Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Strand.jpg", "Strandpromenaden", "4M","","4", new Color(45, 113, 235), Color.BLACK),

    };

    private GUI gui = new GUI(fields);


    public void Start() {
        int players = gui.getUserInteger("How many players?", 2, 4);
        int balance = 20;

        if (players == 3) {
            balance = 18;
        } else if (players == 4) {
            balance = 16;
        }
        String[] names = new String[players];
        for (int i = 0; i < players; i++) {
            names[i] = gui.getUserString("Player " + (i+1) + ", choose name please:");

        }
        GUIplayers = new GUI_Player[names.length];
        for (int i = 0; i < players; i++) {
            GUIplayers[i] = new GUI_Player(names[i], balance, cars[i]);
            gui.addPlayer(GUIplayers[i]);
        }


    }


    //makes an animation of player's piece moving
    public void movePlayer(String name, int from, int to){
    }

    //updates all players balances
    public void updateBalance() {

    }

    //shows the street is bought and by whom
    public void buyStreet() {

    }

    //moves player to jail
    public void moveToJail() {

    }

    public void displayChanceCard(String message) {

    }

    public void displayDie() {

    }

    public void showGUIMessage() {

    }



    public int[] johansmetode() {
        //Creates a 20 long array with random numbers from 1 to 20. called "chanceArr"
        int[] chanceArr = new int[20];
        Random ran = new Random();
        boolean inArray = false;
        int counter = 0;

        while (chanceArr[19] == 0) {
            int ranNumber = ran.nextInt(21);

            for (int i = 0; i < chanceArr.length; i++) {
                if (chanceArr[i] == ranNumber) {
                    inArray = true;
                }
            }
            if (!inArray) {
                chanceArr[counter] = ranNumber;
                counter++;
            }
            inArray = false;
        }
        return chanceArr;
    }
}
