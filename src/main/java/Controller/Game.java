
package Controller;

import Model.Dice;
import Model.FieldList;
import Model.PlayerList;
import Translation.Translator;
import View.Board;
import View.GameGUI;
import gui_main.GUI;

import java.awt.*;

public class Game {

    static public Translator translation;

    public void play() throws InterruptedException {

        translation = new Translator("da");

        Board board = new Board();
        FieldList fl = new FieldList(12);

        Logic logic = new Logic();

        GUI gui = new GUI(board.createBoard(fl), Color.WHITE);
        GameGUI gameGui = new GameGUI(gui);

        int playerAmount = gameGui.setPlayerAmount();
        PlayerList pl = new PlayerList(playerAmount);

        Dice dice = new Dice(0,0);

        for (int i = 0; i < playerAmount; i++) {
            String name = gameGui.setPlayerName();
            pl.getPlayerList(i).setName(name);
            pl.getAccount(i).setBalance(pl.getAccount(i).getStartingBalance());
        }

        gameGui.addPlayers(pl);

        int playerTurn = 0;
        int preTurn = 0;

        for (int i = 0; i < playerAmount; i++) {
            while(!logic.winCondition(pl)) {
                preTurn = playerTurn;

                logic.displayTakingTurn(pl, playerTurn);
                gameGui.rollDiceAction(pl, playerTurn);

                logic.movePlayer(pl, fl, dice, playerTurn);

                logic.diceInfo(pl, dice, playerTurn);

                gameGui.showDice(dice.getDie1(), dice.getDie2());
                gameGui.fancyMoveGuiPlayer(logic.prePos, playerTurn, dice);
                gameGui.showBalance(pl, playerTurn);

                pl.getPlayerList(playerTurn).incrementTurn();
                logic.displayTurn(pl, playerTurn);
                playerTurn = (playerTurn + 1)%playerAmount;
            }
        }
        logic.findWinner(pl, preTurn);
        gameGui.displayWinner(pl, preTurn);
        gui.close();
    }
}