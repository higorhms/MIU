package prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private List<Apartment> apartments = new ArrayList<Apartment>();
    private double maintenanceCost;
    private int number;

    public Building(int number, double maintenanceCost){
        this.number = number;
        this.maintenanceCost = maintenanceCost;
    }

    public void addApartment(Apartment a) {
        apartments.add(a);
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }
}
