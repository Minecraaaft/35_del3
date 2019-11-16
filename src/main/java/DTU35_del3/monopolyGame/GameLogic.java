package DTU35_del3.monopolyGame;

import DTU35_del3.board.Board;
import DTU35_del3.diceCup.DiceCup;
import DTU35_del3.player.Balance;
import DTU35_del3.player.Player;

public class GameLogic {
    private Player player1 = new Player();
    private Player player2 = new Player();
    private Player player3 = new Player();
    private Player player4 = new Player();
    private Player[] playerList= {player1, player2, player3, player4};
    private Balance balance1, balance2, balance3, balance4;
    private DiceCup diceCup = new DiceCup();
    private Board board = new Board();
    private GUIController guiController = new GUIController();

    public void Start() {
        String[] names = guiController.startMenu();

        for (int i = 0; i < names.length - 1; i++) {
            playerList[i].setName(names[i]);
        }

    }


}
