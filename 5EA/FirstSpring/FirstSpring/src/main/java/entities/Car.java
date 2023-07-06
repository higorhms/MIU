package entities;

public class Car implements Vehicle {

    private String model;

    private int year;

    @Override
    public void move() {
        System.out.println("Car move");
    }

    public Car(String model) {
        this.model = model;
    }

    public Car(){}

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
