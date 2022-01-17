package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor visitor;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void hasDefaultPrice() {
        assertEquals(4.50, dodgems.defaultPrice(), 0.0);
    }

    @Test
    public void canCalculatePriceForAdult() {
        visitor = new Visitor(12, 150, 100);
        assertEquals(4.50, dodgems.priceFor(visitor), 0.0);
    }

    @Test
    public void canCalculatePriceForChild() {
        visitor = new Visitor(11, 130, 100);
        assertEquals(2.25, dodgems.priceFor(visitor), 0.0);
    }
}
