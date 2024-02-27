package MainClasses;

import Main.MainClasses.Necklace;
import Main.MainClasses.Stone;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class NecklaceTest {

    @Test
    void totalCost() {
        List<Stone> stonesList = new ArrayList<>();
        stonesList.add(new Stone("Diamond", 1.5, 1500.0, 0.9));
        stonesList.add(new Stone("Ruby", 2.0, 1000.0, 0.8));

        Necklace necklace = new Necklace(stonesList);

        double expectedTotalCost = 1500.0 + 1000.0;

        assertEquals(expectedTotalCost, necklace.totalCost(), 0.001);
    }

    @Test
    void addStone() {
        Necklace necklace = new Necklace(new ArrayList<>());
        Stone newStone = new Stone("Sapphire", 1.0, 1200.0, 0.85);

        necklace.addStone(newStone);

        assertTrue(necklace.getStonesList().contains(newStone));
    }

    @Test
    void totalWeight() {
        List<Stone> stonesList = new ArrayList<>();
        stonesList.add(new Stone("Diamond", 1.5, 1500.0, 0.9));
        stonesList.add(new Stone("Ruby", 2.0, 1000.0, 0.8));

        Necklace necklace = new Necklace(stonesList);

        double expectedTotalWeight = 1.5 + 2.0;

        assertEquals(expectedTotalWeight, necklace.totalWeight(), 0.001);
    }

    @Test
    void setStonesList() {
        List<Stone> stonesList = new ArrayList<>();
        stonesList.add(new Stone("Diamond", 1.5, 1500.0, 0.9));
        stonesList.add(new Stone("Ruby", 2.0, 1000.0, 0.8));

        Necklace necklace = new Necklace(new ArrayList<>());
        necklace.setStonesList(stonesList);

        assertEquals(stonesList, necklace.getStonesList());
    }
}
