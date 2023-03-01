package prog27format;

import prog22rand.RandomNumbers;

import java.util.Random;

public class Prog7 {

    public static void main(String[] args) {
        RandomNumbers random = new RandomNumbers();

        String output = "";
        output += String.format("%n %n");
        output += String.format("%13d %13d %13d %13d %n %n",
                random.getRandomInt(1, 99),
                random.getRandomInt(1, 99),
                random.getRandomInt(1, 99),
                random.getRandomInt(1, 99));
        output += String.format("%9s %3d %9s %3d %9s %3d %9s %3d %n",
                "+", random.getRandomInt(1, 99),
                "+", random.getRandomInt(1, 99),
                "+", random.getRandomInt(1, 99),
                "+", random.getRandomInt(1, 99));
        output += String.format("%13s %13s %13s %13s %n %n",
                "______",
                "______",
                "______",
                "______");
        output += String.format("%n %n %n");
        output += String.format("%13d %13d %13d %13d %n %n",
                random.getRandomInt(1, 99),
                random.getRandomInt(1, 99),
                random.getRandomInt(1, 99),
                random.getRandomInt(1, 99));
        output += String.format("%9s %3d %9s %3d %9s %3d %9s %3d %n",
                "+", random.getRandomInt(1, 99),
                "+", random.getRandomInt(1, 99),
                "+", random.getRandomInt(1, 99),
                "+", random.getRandomInt(1, 99));
        output += String.format("%13s %13s %13s %13s %n %n",
                "______",
                "______",
                "______",
                "______");

        System.out.println(output);
    }

}
