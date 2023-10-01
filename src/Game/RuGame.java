package Game;

import java.util.ArrayList;
import java.util.Arrays;

public class RuGame extends  AbstractClass{
    String name;

    protected RuGame() {
        this.name = "Russian";;
    }

    public String getName() {
        return name;
    }
    @Override
    ArrayList<String> generateCharList() {
        return new ArrayList<>(Arrays.asList("абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toUpperCase().split("")));

    }
}