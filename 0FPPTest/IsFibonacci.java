public class IsFibonacci {
        public static void main(String[] args) {
            System.out.println(new TesteIsFibonacci().execute(2));
        }
    }

    class TesteIsFibonacci {
        public int execute(int n) {
            if(n == 1) return 1;

            int firstNumber = 1;
            int secondNumber = 1;
            int thirdNumber = 0;

            while (thirdNumber < n){
                thirdNumber = firstNumber + secondNumber;
                firstNumber = secondNumber;
                secondNumber = thirdNumber;
            }

            if(thirdNumber == n) return 1;

            return 0;
        }
    }

