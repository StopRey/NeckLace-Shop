package MainClasses;

import Main.MainClasses.Necklace;
import Main.MainClasses.ShopGoods;
import Main.MainClasses.Stone;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ShopGoodsTest {

    @Test
    void readNecklacesFromFile() {
        ShopGoods shopGoods = new ShopGoods(new ArrayList<>());

        String testFileName = "C:\\Users\\admin\\Desktop\\Прикладне програмування\\Complex PP Herasymenko Vadym OI-23\\Test\\ShopGoods.txt";
        shopGoods.readNecklacesFromFile(testFileName);

        List<Necklace> necklaceList = shopGoods.getNecklaceList();

        assertFalse(necklaceList.isEmpty());
        assertEquals(2, necklaceList.size());

        Necklace necklace1 = necklaceList.get(0);
        assertEquals(550, necklace1.totalCost(), 0.001);
        assertEquals(2, necklace1.getStonesList().size());

        Necklace necklace2 = necklaceList.get(1);
        assertEquals(1250, necklace2.totalCost(), 0.001);
        assertEquals(2, necklace2.getStonesList().size());
    }

    @Test
    void getNecklace() {
        List<Necklace> necklaceList = new ArrayList<>();
        necklaceList.add(new Necklace(new ArrayList<>()));
        necklaceList.add(new Necklace(new ArrayList<>()));
        ShopGoods shopGoods = new ShopGoods(necklaceList);

        assertEquals(necklaceList.get(0), shopGoods.getNecklace(0));
        assertEquals(necklaceList.get(1), shopGoods.getNecklace(1));
    }

    @Test
    void getNecklaceList() {
        List<Necklace> necklaceList = new ArrayList<>();
        necklaceList.add(new Necklace(new ArrayList<>()));
        necklaceList.add(new Necklace(new ArrayList<>()));
        ShopGoods shopGoods = new ShopGoods(necklaceList);

        assertEquals(necklaceList, shopGoods.getNecklaceList());
    }

    @Test
    void setNecklaceList() {
        List<Necklace> necklaceList = new ArrayList<>();
        necklaceList.add(new Necklace(new ArrayList<>()));
        necklaceList.add(new Necklace(new ArrayList<>()));
        ShopGoods shopGoods = new ShopGoods(new ArrayList<>());

        shopGoods.setNecklaceList(necklaceList);

        assertEquals(necklaceList, shopGoods.getNecklaceList());
    }
}
