package Controller;

import Model.Dice;
import Model.FieldList;
import Model.PlayerList;
import Model.Playerlist.*;
import Translation.Translator;

public class Logic {


    public int prePos;
    public int pos;

    public Logic() {
    }

    /**
     * Updates the roll and position of the dice
     * Moves the player outside of the GUI.
     * Manages the balance of the player
     * @param pl Playlist used to access players account and position
     * @param fl FieldList used to access the price of the fields
     * @param dice Dice used to update the roll and move the player
     * @param playerTurn Which player is taking a turn
     */
    public void movePlayer(PlayerList pl, FieldList fl, Dice dice, int playerTurn) {
        Player player = pl.getPlayerList(playerTurn);
        Account account = pl.getAccount(playerTurn);

        prePos = player.getCurrentPosition();
        player.move(dice.roll(), fl);
        pos = player.getCurrentPosition();

        switch (pos) {
            case 0: case 1: case 3: case 5: case 8: case 11:
                account.deposit(fl.getField(pos).getPrice());
                break;
            case 2: case 4: case 7: case 9: case 10:
                account.withdraw(fl.getField(pos).getPrice());
                break;
            case 6:
            default:
                break;
        }
        System.out.printf(Game.translation.getLandedString(),
                player.getName(), pos, fl.getField(pos).getTitle(), fl.getField(pos).getPrice());
    }

    /**
     * Describes the win condition of the game if a player has 3000 balance
     * @param pl player list used to access accounts and check all counts
     * @return Returns if the condition is met or no
     */
    public boolean winCondition(PlayerList pl) {
        boolean winCondition = false;
        for (int i = 0; i <pl.getAccounts().length ; i++) {
            if (pl.getAccount(i).getBalance() >= 3000) winCondition = true;
        }
        return winCondition;
    }

    public void findWinner(PlayerList pl, int playerTurn){
        System.out.println(pl.getPlayerList(playerTurn).getName() + Game.translation.getWonString() + pl.getAccount(playerTurn).getBalance());
    }


    public void diceInfo(PlayerList pl, Dice dice, int PNum) {
        System.out.printf(Game.translation.getDiceInfo() +"\n",pl.getPlayerList(PNum).getName(),dice.getDie1(),dice.getDie2(),dice.getSum(),pl.getPlayerList(PNum).getCurrentPosition(),pl.getAccount(PNum).getBalance());
    }

    public void displayTakingTurn(PlayerList pl, int PNum){
        System.out.printf(Game.translation.getTakingTurnString()+ "\n",pl.getPlayerList(PNum).getName());
    }

    public void displayTurn(PlayerList pl, int PNum){
        System.out.printf(Game.translation.getDisplayTurnString()+ "\n", pl.getPlayerList(PNum).getName(),pl.getPlayerList(PNum).getTurn());
    }

    public int getPrePos() { return prePos; }
    public int getPos() { return pos; }
    public void setPos(int pos) { this.pos = pos; }
}








