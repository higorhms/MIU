package prog22rand;


public class Prog2 {

    public static void main(String[] args) {

        double firstRandomNumber = RandomNumbers.getRandomInt(1, 9);
        double secondRandomNumber = RandomNumbers.getRandomInt(1, 9);


        System.out.println(firstRandomNumber + "^π =  " + Math.pow(firstRandomNumber, Math.PI));
        System.out.println(Math.PI + "^" + secondRandomNumber + " =  " + Math.pow(Math.PI, secondRandomNumber));
    }
}
