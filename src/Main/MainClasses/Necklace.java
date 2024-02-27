package Main.MainClasses;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static Main.MainFunc.MainFunc.sendMail;

public class Necklace {
    private static final String LOG_FILE_PATH = "C:\\Users\\admin\\Desktop\\Прикладне програмування\\Complex PP Herasymenko Vadym OI-23\\src\\applog.txt";

    public static void log(String type,String message) {
        GregorianCalendar date = new GregorianCalendar();
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.println(date.get(Calendar.YEAR) + "-" + date.get(Calendar.MONTH) + "-" + date.get(Calendar.DAY_OF_MONTH) + " " + date.get(Calendar.HOUR) +":"+ date.get(Calendar.MINUTE) +":"+ date.get(Calendar.SECOND) + " " + type + "  " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private List<Stone> stonesList = new ArrayList<>();

    public Necklace(List<Stone> stonesList){
        this.stonesList = stonesList;
    }

    public double totalCost(){
        double sum = 0;
        for (Stone element : stonesList) {
            sum = sum + element.getPrice();
        }
        return sum;
    }

    public void addStone(Stone stone){
        if(stonesList.size()<10){
            stonesList.add(stone);
            log("INFO",stone.getName() + " added to Necklace");
        }
        else{
            sendMail("Error Notification", "The program gave an error because the user is trying to add stones to an already overflowing necklace");
            System.out.printf("\nIn Necklace can be MAX 10 Stones\n");
            log("ERROR","An error Occurred when trying to add a Stone to an Overflowing Necklace");
        }
    }

    public double totalWeight(){
        double sum = 0;
        for (Stone element : stonesList) {
            sum = sum + element.getWeight();
        }
        return sum;
    }

    public List<Stone> getStonesList() {
        return stonesList;
    }

    public void setStonesList(List<Stone> stonesList) {
        this.stonesList = stonesList;
    }
}
