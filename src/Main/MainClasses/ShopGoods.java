package Main.MainClasses;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShopGoods {
    private List<Necklace> necklaceList;

    public ShopGoods(List<Necklace> necklaceList){
        this.necklaceList = necklaceList;
    }

    public void readNecklacesFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            List<Stone> stonesList = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue;
                }

                if (line.trim().isEmpty()) {
                    if (!stonesList.isEmpty()) {
                        Necklace necklace = new Necklace(new ArrayList<>(stonesList));
                        necklaceList.add(necklace);

                        stonesList.clear();
                    }
                } else {
                    String[] parts = line.split(",");
                    String stoneName = parts[0].trim();
                    double stoneWeight = Double.parseDouble(parts[1].trim());
                    double stonePrice = Double.parseDouble(parts[2].trim());
                    double stoneTransparency = Double.parseDouble(parts[3].trim());

                    Stone stone = new Stone(stoneName, stoneWeight, stonePrice, stoneTransparency);
                    stonesList.add(stone);
                }
            }

            if (!stonesList.isEmpty()) {
                Necklace necklace = new Necklace(new ArrayList<>(stonesList));
                necklaceList.add(necklace);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public Necklace getNecklace(int num){
        return (this.necklaceList).get(num);
    }

    public List<Necklace> getNecklaceList() {
        return necklaceList;
    }

    public void setNecklaceList(List<Necklace> necklaceList) {
        this.necklaceList = necklaceList;
    }
}
