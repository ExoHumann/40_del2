
package spil;

import gui_main.GUI;

import java.awt.*;

public class Game {

    public void play() throws InterruptedException {

        Board board = new Board();
        FieldList fl = new FieldList();

        Logic logic = new Logic(0,0);

        GUI gui = new GUI(board.createBoard(fl.getFields()), Color.WHITE);
        GameGUI gameGui = new GameGUI(gui);

        int playerAmount = gameGui.setPlayerAmount();
        PlayerList pl = new PlayerList(playerAmount);


        Dice dice = new Dice(0,0);

        for (int i = 0; i < playerAmount; i++) {
            String name = gameGui.setPlayerName();
            pl.getPlayerList(i).setName(name);
            pl.getAccount(i).setBalance(1000);
        }


        gameGui.addPlayers(pl.getPlayersList());

        int playerTurn = 0;


        while(logic.winCondition(pl, playerTurn)) for (int i = 0; i < playerAmount; i++) {

            logic.displayTakingTurn(pl, playerTurn);
            gameGui.rollDiceAction(pl.players, playerTurn);

            logic.movePlayer(pl, fl, dice, playerTurn);

            int pos = logic.getPos();
            int prePos = logic.getPrePos();

            logic.diceInfo(pl, dice, playerTurn);

            gameGui.fancyMoveGuiPlayer(prePos, playerTurn, dice);
            //gameGui.moveGuiPlayers(prePos, pos, playerTurn);
            gameGui.showDice(dice.getDie1(), dice.getDie2());
            gameGui.showBalance(pl,playerTurn);

            pl.getPlayerList(playerTurn).incrementTurn();
            logic.displayTurn(pl,playerTurn);
            playerTurn = (playerTurn + 1)%playerAmount;

        }
    }
}