package MainClasses;

import Main.MainClasses.Stone;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StoneTest {

    @Test
    void getPrice() {
        Stone stone = new Stone("Diamond", 1.5, 1500.0, 0.9);
        assertEquals(1500.0, stone.getPrice(), 0.001);
    }

    @Test
    void setPrice() {
        Stone stone = new Stone("Diamond", 1.5, 1500.0, 0.9);
        stone.setPrice(2000.0);
        assertEquals(2000.0, stone.getPrice(), 0.001);
    }

    @Test
    void getTransparency() {
        Stone stone = new Stone("Diamond", 1.5, 1500.0, 0.9);
        assertEquals(0.9, stone.getTransparency(), 0.001);
    }

    @Test
    void setTransparency() {
        Stone stone = new Stone("Diamond", 1.5, 1500.0, 0.9);
        stone.setTransparency(0.95);
        assertEquals(0.95, stone.getTransparency(), 0.001);
    }

    @Test
    void getWeight() {
        Stone stone = new Stone("Diamond", 1.5, 1500.0, 0.9);
        assertEquals(1.5, stone.getWeight(), 0.001);
    }

    @Test
    void setWeight() {
        Stone stone = new Stone("Diamond", 1.5, 1500.0, 0.9);
        stone.setWeight(2.0);
        assertEquals(2.0, stone.getWeight(), 0.001);
    }

    @Test
    void getName() {
        Stone stone = new Stone("Diamond", 1.5, 1500.0, 0.9);
        assertEquals("Diamond", stone.getName());
    }

    @Test
    void setName() {
        Stone stone = new Stone("Diamond", 1.5, 1500.0, 0.9);
        stone.setName("Ruby");
        assertEquals("Ruby", stone.getName());
    }
}