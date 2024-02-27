package MainClasses;

import Main.MainClasses.Basket;
import Main.MainClasses.Necklace;
import Main.MainClasses.Stone;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @Test
    void clearBasket() {
        List<Necklace> necklaceList = new ArrayList<>();
        necklaceList.add(new Necklace(new ArrayList<>()));
        Basket basket = new Basket(necklaceList);

        basket.clearBasket();

        assertTrue(basket.getNecklaceList().isEmpty());
    }

    @Test
    void totalPrice() {
        List<Necklace> necklaceList = new ArrayList<>();
        List<Stone> stones1 = new ArrayList<>();
        stones1.add(new Stone("Diamond", 1.5, 1500.0, 0.9));
        stones1.add(new Stone("Ruby", 2.0, 1000.0, 0.8));
        necklaceList.add(new Necklace(stones1));

        List<Stone> stones2 = new ArrayList<>();
        stones2.add(new Stone("Sapphire", 1.0, 1200.0, 0.85));
        necklaceList.add(new Necklace(stones2));

        Basket basket = new Basket(necklaceList);

        double expectedTotalPrice = 1500.0 + 1000.0 + 1200.0;

        assertEquals(expectedTotalPrice, basket.totalPrice(), 0.001);
    }

    @Test
    void deleteNecklace() {
        List<Necklace> necklaceList = new ArrayList<>();
        necklaceList.add(new Necklace(new ArrayList<>()));
        necklaceList.add(new Necklace(new ArrayList<>()));
        Basket basket = new Basket(necklaceList);

        int necklaceToRemove = 1;

        basket.deleteNecklace(necklaceToRemove);

        assertEquals(1, basket.getNecklaceList().size());
    }

    @Test
    void totalCost() {
        List<Necklace> necklaceList = new ArrayList<>();
        List<Stone> stones1 = new ArrayList<>();
        stones1.add(new Stone("Diamond", 1.5, 1500.0, 0.9));
        stones1.add(new Stone("Ruby", 2.0, 1000.0, 0.8));
        necklaceList.add(new Necklace(stones1));

        List<Stone> stones2 = new ArrayList<>();
        stones2.add(new Stone("Sapphire", 1.0, 1200.0, 0.85));
        necklaceList.add(new Necklace(stones2));

        Basket basket = new Basket(necklaceList);

        double expectedTotalCost = 1500.0 + 1000.0 + 1200.0;

        assertEquals(expectedTotalCost, basket.totalCost(), 0.001);
    }

    @Test
    void addNecklace() {
        List<Necklace> necklaceList = new ArrayList<>();
        Necklace newNecklace = new Necklace(new ArrayList<>());
        Basket basket = new Basket(necklaceList);

        basket.addNecklace(newNecklace);

        assertTrue(basket.getNecklaceList().contains(newNecklace));
    }
}
