package part1.prob4;

import java.util.List;
import java.util.stream.Stream;

public class A {
    public static void main(String[] args) {
        printFirstNPrimes(10);
    }

    static void printFirstNPrimes(int limit) {
        List<Integer> a = Stream.iterate(2, A::nextPrime).limit(limit).toList();

        System.out.println(a);
    }

    static int nextPrime(int num) {
        int nextPrime = num;
        boolean foundPrime = false;

        while (foundPrime == false) {
            nextPrime++;
            boolean isPrime = isPrime(nextPrime);
            if (isPrime) foundPrime = true;
        }

        return nextPrime;
    }


    static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
