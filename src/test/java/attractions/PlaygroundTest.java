package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class PlaygroundTest {
    Playground playground;
    Visitor visitor;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void canVisit() {
        visitor = new Visitor(8, 140, 100);
        assertTrue(playground.isAllowedTo(visitor));
    }

    @Test
    public void cannotVisit() {
        visitor = new Visitor(16, 180, 100);
        assertFalse(playground.isAllowedTo(visitor));
    }
}
