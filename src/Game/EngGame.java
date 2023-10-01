package Game;

import java.util.ArrayList;
import java.util.Arrays;

public class EngGame extends  AbstractClass{
String name;

    protected EngGame() {
        this.name = "English";;
    }

    public String getName() {
        return name;
    }
    @Override
    ArrayList<String> generateCharList() {
        return new ArrayList<>(Arrays.asList("abcdefghijklmnopqrstuvwxyz".toUpperCase().split("")));

    }

}