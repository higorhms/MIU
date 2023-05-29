public class BunkerPrimePlusNumberOne {

        public static void main(String[] args) {
            int[] input = new int[]{7, 6, 10, 1};

            System.out.println(execute(input));
        }

        static int execute(int[] arr) {

            for(int number : arr){
                 int isPrime = isPrime(number);

                 if(isPrime == 1){
                     boolean contains = containsValue(1, arr);
                     if(contains) return 1;
                     return 0;
                 }
            }

            if(containsValue(1, arr)) return 0;

            return 1;
        }

        static int isPrime(int number){
            if(number < 2) return 0;

            for(int index = 2; index < number; index++){
                if(number % index == 0) return 0;
            }

            return 1;
        }

        static boolean containsValue(int value, int[] arr){
            for(int number : arr){
                if(number == value) return true;
            }

            return false;
        }
    }

