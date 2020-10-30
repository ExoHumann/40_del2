package Model.Playerlist;

import Model.FieldList;

import java.awt.*;

public class Player {

    private String name;
    private Color color;
    private int currentPosition;
    private int turn;

    /**
     * Constructor for the player takes a name and color
     * @param name Players name
     * @param color Players color used for example to set his car color
     */
    public Player(String name, Color color){
        this.name = name;
        this.color = color;
        int turn = 0;
    }

    /**
     * Updates the position of the player and makes sure he can go all the way around with modulus
     * @param position The position is the amount of fields the player is going to move
     * @param fl field list is used to get the amount of fields on the board
     */
    public void move(int position, FieldList fl){
        int fieldLength = fl.getSize();
        this.currentPosition = (currentPosition + position) % fieldLength;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }


    public  void setCurrentPosition(int position){
        this.currentPosition = position;
    }


    public void incrementTurn(){
        turn++;
    }


    public int getTurn(){
        return turn;
    }


    public Color getColor() {
        return color;
    }


    public void setColor(Color color) {
        this.color = color;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }

}