import attractions.Attraction;
import attractions.Park;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
    private HashMap<String, Integer> reviews;

    public ThemePark(ArrayList<Attraction> attractions, ArrayList<Stall> stalls) {
        this.attractions = attractions;
        this.stalls = stalls;
        this.reviews = new HashMap<>();
        for (Attraction attraction: attractions) {
            reviews.put(attraction.getName(), attraction.getRating());
        }
        for (Stall stall: stalls) {
            reviews.put(stall.getName(), stall.getRating());
        }
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public ArrayList<Stall> getStalls() {
        return stalls;
    }

    public ArrayList<IReviewed> getAllReviewed() {
        ArrayList<IReviewed> reviewed = new ArrayList<>();
        reviewed.addAll(attractions);
        reviewed.addAll(stalls);
        return reviewed;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.addVisitedAttraction(attraction);
        attraction.setVisitCount(attraction.getVisitCount() + 1);
    }

    public HashMap<String, Integer> getReviews() {
        return reviews;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> allAllowed = new ArrayList<>();
        for (IReviewed reviewed: getAllReviewed()) {
            if (reviewed instanceof ISecurity) {
                if (((ISecurity) reviewed).isAllowedTo(visitor)) {
                    allAllowed.add(reviewed);
                }
            } else {
                allAllowed.add(reviewed);
            }
        }
        return allAllowed;
    }

}
