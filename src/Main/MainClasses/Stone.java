package Main.MainClasses;

public class Stone {
    private String name;
    private double weight;
    private double price;
    private double transparency;


    public Stone(String name, double weight, double price, double transparency){
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.transparency = transparency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTransparency() {
        return transparency;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
