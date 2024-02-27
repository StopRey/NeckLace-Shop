package Main.MainClasses;

import java.util.*;

public class Basket {
    private List<Necklace> necklaceList = new ArrayList<>();

    public Basket(List<Necklace> necklaceList){
        this.necklaceList = necklaceList;
    }

    public void clearBasket(){
        necklaceList.clear();
    }

    public double totalPrice(){
        double sum = 0;
        for (Necklace necklace : necklaceList) {
            sum = sum + necklace.totalCost();
        }
        return sum;
    }

    public void deleteNecklace(int num){
        (this.necklaceList).remove(num-1);
    }

    public double totalCost(){
        double sum = 0;
        for (Necklace element : necklaceList) {
            sum = sum + element.totalCost();
        }
        return sum;
    }

    public void addNecklace(Necklace necklace){
        (this.necklaceList).add(necklace);
    }



    public List<Necklace> getNecklaceList() {
        return necklaceList;
    }

    public void setNecklaceList(List<Necklace> necklaceList) {
        this.necklaceList = necklaceList;
    }
}
