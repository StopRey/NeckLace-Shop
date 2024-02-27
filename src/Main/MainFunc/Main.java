package Main.MainFunc;

import Main.MainClasses.*;

import java.util.ArrayList;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.GregorianCalendar;
import java.util.Calendar;

public class Main {
    private static final String LOG_FILE_PATH = "C:\\Users\\admin\\Desktop\\2 курс 1 семестр\\Прикладне програмування\\Complex PP Herasymenko Vadym OI-23\\src\\applog.txt";

    public static void log(String type,String message) {
        GregorianCalendar date = new GregorianCalendar();
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.println(date.get(Calendar.YEAR) + "-" + date.get(Calendar.MONTH) + "-" + date.get(Calendar.DAY_OF_MONTH) + " " + date.get(Calendar.HOUR) +":"+ date.get(Calendar.MINUTE) +":"+ date.get(Calendar.SECOND) + " " + type + "  " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        log("INFO","New Process Started");
        String fileName = "C:\\Users\\admin\\Desktop\\2 курс 1 семестр\\Прикладне програмування\\Complex PP Herasymenko Vadym OI-23\\src\\Main\\ShopGoods.txt";
        List<Necklace> necklaceListShop = new ArrayList<>();
        ShopGoods shopGoods = new ShopGoods(necklaceListShop);
        shopGoods.readNecklacesFromFile(fileName);

        fileName = "C:\\Users\\admin\\Desktop\\2 курс 1 семестр\\Прикладне програмування\\Complex PP Herasymenko Vadym OI-23\\src\\Main\\ShopStones.txt";
        List<Stone> stonesListShop = new ArrayList<>();
        ShopStones shopStones = new ShopStones(stonesListShop);
        shopStones.readStonesFromFile(fileName);


        List<Necklace> necklaceList = new ArrayList<>();
        Basket basket = new Basket(necklaceList);

        while(true){
            MainFunc.menu(shopGoods, shopStones, basket);
        }
    }
}