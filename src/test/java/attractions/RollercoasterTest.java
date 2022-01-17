package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canVisit() {
        visitor = new Visitor(13, 146, 100);
        assertTrue(rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void cannotVisitIfAgeIsLessThanThirteen() {
        visitor = new Visitor(12, 146, 100);
        assertFalse(rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void cannotVisitIfHeightIsLessThan145() {
        visitor = new Visitor(35, 144, 100);
        assertFalse(rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void cannotVisit() {
        visitor = new Visitor(12, 144, 100);
        assertFalse(rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void hasDefaultPrice() {
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.0);
    }

    @Test
    public void canCalculatePriceForShortPeople() {
        visitor = new Visitor(40, 200, 100);
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.0);
    }

    @Test
    public void canCalculatePriceForTallPeople() {
        visitor = new Visitor(50, 201, 100);
        assertEquals(16.80, rollerCoaster.priceFor(visitor), 0.0);
    }
}
