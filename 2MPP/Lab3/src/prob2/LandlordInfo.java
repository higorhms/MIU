package prob2;

import java.util.ArrayList;
import java.util.List;

public class LandlordInfo {
    private List<Building> buildingList = new ArrayList<Building>();

    public void addBuilding(Building b) {
        buildingList.add(b);
    }

    public String calcProfits() {
        double rent = 0;
        double maintenanceCost = 0;

        for(Building building : this.buildingList){
            for(Apartment apartment : building.getApartments()){
                rent += apartment.getRent();
            }

            maintenanceCost += building.getMaintenanceCost();
        }

        String profits = String.format("Total profit: %s", rent-maintenanceCost);

        return profits;
    }
}
