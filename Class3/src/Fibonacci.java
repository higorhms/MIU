public class Fibonacci {

    public boolean execute(int n){
        if(n == 1) return true;

        int firstNumber = 1;
        int secondNumber = 1;
        int thirdNumber = 0;

        while (thirdNumber < n){
            thirdNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = thirdNumber;
        }

        if(thirdNumber == n) return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci: " + new Fibonacci().execute(5));
    }
}
