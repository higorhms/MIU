package prog25reverse;

import java.util.Scanner;

public class Prog5 {

    public static void main(String[] args) {
        System.out.println("Type any word: ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        scanner.close();

        for(int index = word.length() - 1; index >= 0; index--){
            System.out.print(word.charAt(index));
        }
    }
}
