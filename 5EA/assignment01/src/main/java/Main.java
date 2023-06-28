import entities.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args){
        Car car1 = new Car(1, "Renegade", "Jeep", 2023, 0);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarService");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        // create
        System.out.println("\nCreating Car: \n" + car1.getModel() + "\n");
        tx.begin();
        em.persist(car1);
        tx.commit();

        //read
        System.out.println("Created Car: ");
        Car c = em.find(Car.class, 1);
        System.out.println(c);

        //update
        c.setModel("Renegade Modified");

        //read
        Car modifiedCar = em.find(Car.class, 1);
        System.out.println("Modified Car: ");
        System.out.println(modifiedCar);

        //delete
        tx.begin();
        em.remove(modifiedCar);
        tx.commit();

        Car deletedCar = em.find(Car.class, 1);
        System.out.println("Deleted Car: ");
        System.out.println(deletedCar);
    }

}
