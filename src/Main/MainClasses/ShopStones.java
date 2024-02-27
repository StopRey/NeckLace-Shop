package Main.MainClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class ShopStones {

    private List<Stone> stoneList;
    private List<Stone> sortedStoneList;


    public ShopStones(List<Stone> stoneList){
        this.stoneList = stoneList;
        this.sortedStoneList = stoneList;
    }


    public void readStonesFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String stoneName = parts[0].trim();
                double stoneWeight = Double.parseDouble(parts[1].trim());
                double stonePrice = Double.parseDouble(parts[2].trim());
                double stoneTransparency = Double.parseDouble(parts[3].trim());

                Stone stone = new Stone(stoneName, stoneWeight, stonePrice, stoneTransparency);
                stoneList.add(stone);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void clearSort(){
        this.sortedStoneList = this.stoneList;
    }

    public void sortPriceLowest(){
        Collections.sort(sortedStoneList, Comparator.comparingDouble(Stone::getPrice));
    }
    public void sortWeightLowest(){
        Collections.sort(sortedStoneList, Comparator.comparingDouble(Stone::getWeight));
    }
    public void sortTransparencyLowest(){
        Collections.sort(sortedStoneList, Comparator.comparingDouble(Stone::getTransparency));
    }


    public void sortPriceHighest(){
        Collections.sort(sortedStoneList, Comparator.comparingDouble(Stone::getPrice).reversed());
    }
    public void sortWeightHighest(){
        Collections.sort(sortedStoneList, Comparator.comparingDouble(Stone::getWeight).reversed());
    }
    public void sortTransparencyHighest(){
        Collections.sort(sortedStoneList, Comparator.comparingDouble(Stone::getTransparency).reversed());
    }



    public void rangePrice(double x1, double x2){
        this.clearSortedStoneList();
        for (Stone element : stoneList) {
            if(element.getPrice()>=x1 && element.getPrice()<=x2){
                this.sortedStoneList.add(element);
            }
        }
    }
    public void rangeWeight(double x1, double x2){
        this.clearSortedStoneList();
        for (Stone element : stoneList) {
            if(element.getWeight()>=x1 && element.getWeight()<=x2){
                this.sortedStoneList.add(element);
            }
        }
    }
    public void rangeTransparency(double x1, double x2){
        this.clearSortedStoneList();
        for (Stone element : stoneList) {
            if(element.getTransparency()>=x1 && element.getTransparency()<=x2){
                this.sortedStoneList.add(element);
            }
        }
    }

    public void clearSortedStoneList(){
        this.sortedStoneList = new ArrayList<>();
    }


    public List<Stone> getStoneList() {
        return stoneList;
    }

    public void setStoneList(List<Stone> stoneList) {
        this.stoneList = stoneList;
    }

    public List<Stone> getSortedStoneList() {
        return sortedStoneList;
    }

    public void setSortedStoneList(List<Stone> sortedStoneList) {
        this.sortedStoneList = sortedStoneList;
    }
}
