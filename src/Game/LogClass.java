package Game;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;


public class LogClass {


    private String date;
    private String action;

    private static List<String> LogList = new ArrayList<>();
    public LogClass() {
    }

    public void LogAdd(String action){
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH.mm").format(new java.util.Date());
        timeStamp += " -> ";
        timeStamp += action;
        timeStamp += " \n ";
        LogList.add(timeStamp);
    }

    public static void ShowLog(){
            System.out.println(LogList);
    }

    @Override
    public String toString() {
        return LogList.toString();
    }
}
