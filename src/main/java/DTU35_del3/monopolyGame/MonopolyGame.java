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

public class MonopolyGame {


    private Player player1 = new Player();
    private Player player2 = new Player();
    private Player player3 = new Player();
    private Player player4 = new Player();

    private GUI_Field[] fields = {
            new GUI_Start("START", "", "",  Color.RED, Color.WHITE),
            new GUI_Brewery("35_del3/src/main/java/DTU35_del3/Pictures/Burger_final.jpg", "Burgerbaren", "1M","","", Color.RED, Color.BLACK)


    };

    private GUI gui = new GUI(fields);

    public void Start() {}

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
