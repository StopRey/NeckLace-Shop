package MainClasses;

import Main.MainClasses.ShopStones;
import Main.MainClasses.Stone;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ShopStonesTest {

    @Test
    void readStonesFromFile() {
        ShopStones shopStones = new ShopStones(new ArrayList<>());

        String testFileName = "C:\\Users\\admin\\Desktop\\Прикладне програмування\\Complex PP Herasymenko Vadym OI-23\\Test\\ShopStones.txt";
        shopStones.readStonesFromFile(testFileName);

        List<Stone> stoneList = shopStones.getStoneList();

        assertFalse(stoneList.isEmpty());
        assertEquals(2, stoneList.size());

        Stone stone1 = stoneList.get(0);
        assertEquals("Ruby", stone1.getName());
        assertEquals(30, stone1.getWeight(), 0.001);
        assertEquals(250, stone1.getPrice(), 0.001);
        assertEquals(0.4, stone1.getTransparency(), 0.001);

        stone1 = stoneList.get(1);
        assertEquals("Emerald", stone1.getName());
        assertEquals(40, stone1.getWeight(), 0.001);
        assertEquals(300, stone1.getPrice(), 0.001);
        assertEquals(0.3, stone1.getTransparency(), 0.001);
    }

    @Test
    void clearSort() {
        List<Stone> stoneList = new ArrayList<>();
        stoneList.add(new Stone("Diamond", 1.5, 1500.0, 0.9));
        stoneList.add(new Stone("Ruby", 2.0, 1000.0, 0.8));

        ShopStones shopStones = new ShopStones(stoneList);
        shopStones.clearSort();

        assertEquals(stoneList, shopStones.getSortedStoneList());
    }

    @Test
    void sortPriceLowest() {
        List<Stone> stoneList = new ArrayList<>();
        stoneList.add(new Stone("Diamond", 1.5, 1500.0, 0.9));
        stoneList.add(new Stone("Ruby", 2.0, 1000.0, 0.8));

        ShopStones shopStones = new ShopStones(stoneList);
        shopStones.sortPriceLowest();

        List<Stone> sortedList = shopStones.getSortedStoneList();
        assertEquals(1000.0, sortedList.get(0).getPrice(), 0.001);
        assertEquals(1500.0, sortedList.get(1).getPrice(), 0.001);
    }

    @Test
    void sortWeightHighest() {
        List<Stone> stoneList = new ArrayList<>();
        stoneList.add(new Stone("Diamond", 1.5, 1500.0, 0.9));
        stoneList.add(new Stone("Ruby", 2.0, 1000.0, 0.8));

        ShopStones shopStones = new ShopStones(stoneList);
        shopStones.sortWeightHighest();

        List<Stone> sortedList = shopStones.getSortedStoneList();
        assertEquals(2.0, sortedList.get(0).getWeight(), 0.001);
        assertEquals(1.5, sortedList.get(1).getWeight(), 0.001);
    }

    @Test
    void rangePrice() {
        List<Stone> stoneList = new ArrayList<>();
        stoneList.add(new Stone("Diamond", 1.5, 1500.0, 0.9));
        stoneList.add(new Stone("Ruby", 2.0, 1000.0, 0.8));
        stoneList.add(new Stone("Sapphire", 1.0, 1200.0, 0.85));

        ShopStones shopStones = new ShopStones(stoneList);
        shopStones.rangePrice(1000.0, 1400.0);

        List<Stone> filteredList = shopStones.getSortedStoneList();
        assertEquals(2, filteredList.size());
        assertEquals("Ruby", filteredList.get(0).getName());
        assertEquals("Sapphire", filteredList.get(1).getName());
    }

    @Test
    void rangeTransparency() {
        List<Stone> stoneList = new ArrayList<>();
        stoneList.add(new Stone("Diamond", 1.5, 1500.0, 0.9));
        stoneList.add(new Stone("Ruby", 2.0, 1000.0, 0.8));
        stoneList.add(new Stone("Sapphire", 1.0, 1200.0, 0.85));

        ShopStones shopStones = new ShopStones(stoneList);
        shopStones.rangeTransparency(0.8, 0.9);

        List<Stone> filteredList = shopStones.getSortedStoneList();
        assertEquals(3, filteredList.size());
        assertEquals("Ruby", filteredList.get(1).getName());
        assertEquals("Diamond", filteredList.get(0).getName());
        assertEquals("Sapphire", filteredList.get(2).getName());
    }

    @Test
    void sortTransparencyLowest() {
        List<Stone> stoneList = new ArrayList<>();
        stoneList.add(new Stone("Diamond", 1.5, 1500.0, 0.9));
        stoneList.add(new Stone("Ruby", 2.0, 1000.0, 0.8));

        ShopStones shopStones = new ShopStones(stoneList);
        shopStones.sortTransparencyLowest();

        List<Stone> sortedList = shopStones.getSortedStoneList();
        assertEquals(0.8, sortedList.get(0).getTransparency(), 0.001);
        assertEquals(0.9, sortedList.get(1).getTransparency(), 0.001);
    }

    @Test
    void sortTransparencyHighest() {
        List<Stone> stoneList = new ArrayList<>();
        stoneList.add(new Stone("Diamond", 1.5, 1500.0, 0.9));
        stoneList.add(new Stone("Ruby", 2.0, 1000.0, 0.8));

        ShopStones shopStones = new ShopStones(stoneList);
        shopStones.sortTransparencyHighest();

        List<Stone> sortedList = shopStones.getSortedStoneList();
        assertEquals(0.9, sortedList.get(0).getTransparency(), 0.001);
        assertEquals(0.8, sortedList.get(1).getTransparency(), 0.001);
    }

    @Test
    void rangeWeight() {
        List<Stone> stoneList = new ArrayList<>();
        stoneList.add(new Stone("Diamond", 1.5, 1500.0, 0.9));
        stoneList.add(new Stone("Ruby", 2.0, 1000.0, 0.8));
        stoneList.add(new Stone("Sapphire", 1.0, 1200.0, 0.85));

        ShopStones shopStones = new ShopStones(stoneList);
        shopStones.rangeWeight(1.0, 1.5);

        List<Stone> filteredList = shopStones.getSortedStoneList();
        assertEquals(2, filteredList.size());
        assertEquals("Diamond", filteredList.get(0).getName());
        assertEquals("Sapphire", filteredList.get(1).getName());
    }

    @Test
    void clearSortedStoneList() {
        List<Stone> stoneList = new ArrayList<>();
        stoneList.add(new Stone("Diamond", 1.5, 1500.0, 0.9));
        stoneList.add(new Stone("Ruby", 2.0, 1000.0, 0.8));

        ShopStones shopStones = new ShopStones(stoneList);
        shopStones.clearSortedStoneList();

        assertTrue(shopStones.getSortedStoneList().isEmpty());
    }
}
