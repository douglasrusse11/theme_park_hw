package attractions;

import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    private static double defaultPrice = 4.50;

    public Dodgems(String name, int rating) {
        super(name, rating);
    }

    public double defaultPrice() {
        return defaultPrice;
    }

    public double priceFor(Visitor visitor) {
        if (visitor.getAge() < 12) {
            return defaultPrice / 2;
        }
        return defaultPrice;
    }
}
