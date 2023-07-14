package entities;

public class Car implements Vehicle {

    private String model;

    private int year;

    @Override
    public void move() {
        System.out.println("Car move");
    }

    public Car(String model) {
//        System.out.println("Car constructor");
        this.model = model;
    }

    public Car(){}

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void init(){
        System.out.println("init car");
    }


    public static Car getInstance(){
        return new Car();
    }

    public static Car getInstance(String s) {
        return new Car(s);
    }
}
