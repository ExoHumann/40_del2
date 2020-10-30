package Model;

import Controller.Game;
import Model.Field;

import java.awt.*;

public class FieldList {

    Field[] fields = new Field[12];

    public FieldList(int fieldAmount) {


        fields[0] = new Field(Game.translation.getFieldsName()[0],200,"1", Color.green);
        fields[1] = new Field(Game.translation.getFieldsName()[1],250,"2", Color.green);
        fields[2] = new Field(Game.translation.getFieldsName()[2],100,"3", Color.red);
        fields[3] = new Field(Game.translation.getFieldsName()[3],100,"4", Color.green);
        fields[4] = new Field(Game.translation.getFieldsName()[4],20,"5", Color.red);
        fields[5] = new Field(Game.translation.getFieldsName()[5],180,"6", Color.green);
        fields[6] = new Field(Game.translation.getFieldsName()[6],0,"7", Color.green);
        fields[7] = new Field(Game.translation.getFieldsName()[7],70,"8", Color.red);
        fields[8] = new Field(Game.translation.getFieldsName()[8],60,"9", Color.green);
        fields[9] = new Field(Game.translation.getFieldsName()[9],80,"10",Color.red);
        fields[10] = new Field(Game.translation.getFieldsName()[10],50,"11",Color.red);
        fields[11] = new Field(Game.translation.getFieldsName()[11],650,"12",Color.green);
    }

    // Prints out all the fields to the console
    public void getAllFields() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(fields[i]);
        }
    }


    //Getters and setters
    public Field getField(int fieldNum) { return fields[fieldNum]; }
    public Field[] getFields(){return fields; }
    public int getSize(){ return fields.length; }
}
