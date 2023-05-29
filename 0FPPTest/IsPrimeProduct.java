public class IsPrimeProduct {
        public static void main(String[] args) {
            System.out.println("Input: 22  | Expected Output: (1) | Output: " + isPrimeProduct(22));
            System.out.println("Input: 23  | Expected Output: (0) | Output: " + isPrimeProduct(23));
        }

        static int isPrimeProduct(int number)  {
            if(number < 0) return 0;

            int whileIndex = 2;

            while(whileIndex < number){
                int whileIndexIsPrime = isPrime(whileIndex);

                if(whileIndexIsPrime == 1){
                    for(int forIndex = 2; forIndex < number; forIndex++){
                        int forIndexIsPrime = isPrime(forIndex);

                        if(forIndexIsPrime == 1){
                            if(whileIndex * forIndex == number) return 1;
                        }
                    }
                }

                whileIndex++;
            }

            return 0;
        }

        static int isPrime(int value){
            if(value < 2) return 0;

            for(int index = 2; index < value; index++){
                if(value%index == 0) return 0;
            }

            return 1;
        }


    }