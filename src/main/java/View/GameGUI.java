
package View;

import Controller.Game;
import Model.Dice;
import gui_fields.*;
import gui_main.GUI;
import Model.Playerlist.Player;
import Model.PlayerList;

import static java.lang.Thread.sleep;

public class GameGUI {

    private GUI gui;
    private GUI_Field[] fields;
    public GUI_Player[] gui_players;
    private GUI_Car[] gui_cars;

    public GameGUI(GUI gui){
        this.gui = gui;
        this.fields = gui.getFields();
    }

    /**
     * Players are placed on a field and shown their balance
     * @param pl gui players and - cars are made from the player length
     */
    public void addPlayers(PlayerList pl){
        gui_cars = new GUI_Car[pl.getPlayersList().length];
        gui_players = new GUI_Player[pl.getPlayersList().length];

        for (int i = 0; i < pl.getPlayersList().length; i++) {
            Player player = pl.getPlayerList(i);
            gui_cars[i] = new GUI_Car(player.getColor(), player.getColor(), GUI_Car.Type.UFO, GUI_Car.Pattern.ZEBRA);
            gui_players[i] = new GUI_Player(player.getName(),0, gui_cars[i]);
            gui.addPlayer(gui_players[i]);
            fields[0].setCar(gui_players[i], true);
            gui_players[i].setBalance(pl.getAccount(i).getStartingBalance());
        }
    }

    /**
     * Player is move 1 field at a time
     * @param prePos Previous position of the player
     * @param PNum  The player that are being moved
     * @param dice  Uses dice.getSum() to find the amount of fields it needs to move
     * @throws InterruptedException Uses sleep() to make a shot pause before moving again
     */
    public void fancyMoveGuiPlayer(int prePos, int PNum, Dice dice) throws InterruptedException {
        int dif = dice.getSum();
        int fieldLength = fields.length;
        for (int i = 0; i < dif ; i++) {
            int pos = (prePos + 1) % fieldLength;
        if (fields[prePos].hasCar(gui_players[PNum])) {
            fields[prePos].setCar(gui_players[PNum], false);
            fields[pos].setCar(gui_players[PNum], true);
            sleep(170);
            prePos = (prePos + 1) % fieldLength;
            }
        }
    }

    /**
     * Moves the player to the starting field 0
     * @param pl Used to find the position of the player that are being moved
     * @param PNum The player that are being moved
     */
    public void moveToStart(PlayerList pl, int PNum) {
        int prePos = pl.getPlayerList(PNum).getCurrentPosition();
        if (fields[prePos].hasCar(gui_players[PNum])) {
            fields[prePos].setCar(gui_players[PNum], false);
            fields[0].setCar(gui_players[PNum], true);
            pl.getPlayerList(PNum).setCurrentPosition(0);
        }
    }

    /**
     * Updates the balance that is shown on the screen
     * @param pl Used to get the players account
     * @param PNum The player that are being accessed
     */
    public void showBalance(PlayerList pl, int PNum){
        int balance = pl.getAccount(PNum).getBalance();
        gui_players[PNum].setBalance(balance);
    }


    public String setPlayerName(){ return gui.getUserString(Game.translation.getPlayerNameAction()); }

    public int setPlayerAmount(){ return gui.getUserInteger(Game.translation.getPlayerSelectAction(), 2, 6);}

    public void showDice(int dice1, int dice2){ gui.setDice(dice1,dice2); }

    public void rollDiceAction(PlayerList pl, int PNum){ gui.showMessage(pl.getPlayerList(PNum).getName() + " " + Game.translation.getRollDiceAction()); }

    public void displayWinner(PlayerList pl, int PNum) { gui.showMessage(pl.getPlayerList(PNum).getName() + " " + Game.translation.getWonTheGameString() + pl.getAccount(PNum).getBalance()); }

    public void closeGame() { gui.close(); }
}
