package spil;

import gui_main.GUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //GUI gui = new GUI();
        Scanner in = new Scanner(System.in);

        System.out.println("Set your name");
        String pName = in.nextLine();
        System.out.println("Set computers name");
        String cName = in.nextLine();

        Player player = new Player(pName, 0);
        Player computer = new Player(cName, 0);

        Dice cDice = new Dice(0,0);
        Dice pDice = new Dice(0,0);

       new Game(player, computer, 1, cDice, pDice);
    }
}
