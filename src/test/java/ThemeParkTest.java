import attractions.*;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    private ThemePark themePark;

    @Before
    public void before() {
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Park("Leafy Meadows", 9));
        attractions.add(new Dodgems("Bumper Cars", 5));
        attractions.add(new Playground("Fun Zone", 7));
        attractions.add(new RollerCoaster("Blue Ridge", 10));
        ArrayList<Stall> stalls = new ArrayList<>();
        stalls.add(new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 5));
        stalls.add(new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 7));
        stalls.add(new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 8));
        themePark = new ThemePark(attractions, stalls);
    }

    @Test
    public void hasAttractions() {
        assertEquals(4, themePark.getAttractions().size());
    }

    @Test
    public void hasStalls() {
        assertEquals(3, themePark.getStalls().size());
    }

    @Test
    public void hasReviewed() {
        assertEquals(7, themePark.getAllReviewed().size());
    }

    @Test
    public void canVisit() {
        Visitor visitor = new Visitor(25, 175, 100);
        themePark.visit(visitor, themePark.getAttractions().get(0));
        assertEquals(themePark.getAttractions().get(0), visitor.getVisitedAttraction().get(0));
        assertEquals(1, themePark.getAttractions().get(0).getVisitCount());
    }
}
