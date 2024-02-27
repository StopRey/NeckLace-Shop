package MainFunc;

import Main.MainClasses.*;
import Main.MainFunc.MainFunc;
import Main.MainFunc.Output;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainFuncTest {
    @Test
    void makeOrder() {
        List<Stone> stonesList = new ArrayList<>();
        stonesList.add(new Stone("Ruby", 1.5, 1500.0, 0.9));
        stonesList.add(new Stone("Emerald", 2.0, 1000.0, 0.8));
        Necklace necklace = new Necklace(stonesList);

        List<Necklace> necklaceList = new ArrayList<>();
        necklaceList.add(necklace);

        Basket basket = new Basket(necklaceList);

        MainFunc.makeOrder(basket);

        // Now, you can assert the expected behavior
        assertEquals(0, basket.getNecklaceList().size());
    }

    @Test
    void addBusket() {
        List<Stone> stonesList = new ArrayList<>();
        stonesList.add(new Stone("Ruby", 1.5, 1500.0, 0.9));
        stonesList.add(new Stone("Emerald", 2.0, 1000.0, 0.8));
        Necklace necklace = new Necklace(stonesList);

        List<Necklace> necklaceList = new ArrayList<>();
        necklaceList.add(necklace);

        Basket basket = new Basket(necklaceList);

        ShopGoods shopGoods = new ShopGoods(new ArrayList<>());
        shopGoods.getNecklaceList().add(necklace);

        MainFunc.addBusket(shopGoods, basket, 1);

        // Now, you can assert the expected behavior
        assertEquals(2, basket.getNecklaceList().size());
    }

    @Test
    void showShopGoods() {
        List<Stone> stonesList = new ArrayList<>();
        stonesList.add(new Stone("Ruby", 1.5, 1500.0, 0.9));
        stonesList.add(new Stone("Emerald", 2.0, 1000.0, 0.8));
        Necklace necklace = new Necklace(stonesList);

        ShopGoods shopGoods = new ShopGoods(new ArrayList<>());
        shopGoods.getNecklaceList().add(necklace);

        Basket basket = new Basket(new ArrayList<>());

        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        MainFunc.showShopGoods(shopGoods, basket);

        // Now, you can assert the expected behavior
        assertEquals(0, basket.getNecklaceList().size());
    }
}
