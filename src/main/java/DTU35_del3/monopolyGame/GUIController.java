package DTU35_del3.monopolyGame;

import DTU35_del3.board.Board;
import DTU35_del3.player.Player;
import gui_fields.GUI_Brewery;
import gui_fields.GUI_Field;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_main.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GUIController {




    private GUI_Field[] fields = {
            new GUI_Start("START", "", "",  Color.RED, Color.WHITE),
            new GUI_Brewery("src/main/java/Pictures/Burger.jpg", "Burgerbaren", "1M","","1", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Pizza.jpg", "Pizzariaet", "1M","","1", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Slik.jpg", "Slikbutikken", "1M","","1", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Is.jpg", "Isbutikken", "1M","","1", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Museum.jpg", "Museet", "2M","","2", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Bog.jpg", "Biblioteket", "2M","","2", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Burger.jpg", "Burgerbaren", "1M","","", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Burger.jpg", "Burgerbaren", "1M","","", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Burger.jpg", "Burgerbaren", "1M","","", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Burger.jpg", "Burgerbaren", "1M","","", Color.WHITE, Color.BLACK),
            new GUI_Brewery("src/main/java/Pictures/Burger.jpg", "Burgerbaren", "1M","","", Color.WHITE, Color.BLACK),


    };

    private GUI gui = new GUI(fields);



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
