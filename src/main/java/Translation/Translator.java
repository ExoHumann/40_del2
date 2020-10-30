package Translation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Translator {


    String LandedString,WonString,DiceInfo,TakingTurnString,DisplayTurnString,FieldToString,PlayerNameAction,PlayerSelectAction,RollDiceAction,WonTheGameString;
    String[] fieldsName;
    String[] file;

    public String getLandedString() {
        return LandedString;
    }

    public String getWonString() {
        return WonString;
    }

    public String getDiceInfo() {
        return DiceInfo;
    }

    public String getTakingTurnString() {
        return TakingTurnString;
    }

    public String getDisplayTurnString() {
        return DisplayTurnString;
    }

    public String getFieldToString() {
        return FieldToString;
    }

    public String getPlayerNameAction() {
        return PlayerNameAction;
    }

    public String getPlayerSelectAction() {
        return PlayerSelectAction;
    }

    public String getRollDiceAction() {
        return RollDiceAction;
    }

    public String getWonTheGameString() {
        return WonTheGameString;
    }

    public String[] getFieldsName() {
        return fieldsName;
    }

    public Translator(String localization){
        switch (localization){
            case "da":
                file = readFile("da.txt").split("\n");
                break;
            default:
                file = readFile("en.txt").split("\n");
                break;

        }

        LandedString = file[1];
        WonString = file[3];
        DiceInfo = file[5];
        TakingTurnString = file[7];
        DisplayTurnString = file[9];
        FieldToString = file[11];
        PlayerNameAction = file[13];
        PlayerSelectAction = file[15];
        RollDiceAction = file[17];
        WonTheGameString = file[19];
        fieldsName = Arrays.copyOfRange(file,19,file.length);
    }

    private String readFile(String source){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/"+source));

            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append("\n");
            }

            return content.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
