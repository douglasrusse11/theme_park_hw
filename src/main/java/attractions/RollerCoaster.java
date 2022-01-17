package attractions;

import behaviours.ISecurity;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity {

    private static double defaultPrice = 8.40;

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    public boolean isAllowedTo(Visitor visitor) {
        return visitor.getAge() > 12 && visitor.getHeight() > 145;
    }

    public double defaultPrice() {
        return defaultPrice;
    }

    public double priceFor(Visitor visitor) {
        if (visitor.getHeight() > 200) {
            return defaultPrice * 2;
        }
        return defaultPrice;
    }
}
