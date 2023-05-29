public class IsMagicArray {
        public static void main(String[] args) {
            int[] input = new int[]{21, 3, 7, 9, 11, 4, 6};
            System.out.println("Input: {21, 3, 7, 9, 11 4, 6} | Expected Output: (1) | Output: " + isMagicArray(input));

            int[] input2 = new int[]{13, 4, 4, 4, 4};
            System.out.println("Input: {13, 4, 4, 4, 4} | Expected Output: (0) | Output: " + isMagicArray(input2));

            int[] input3 = new int[]{10, 5, 5};
            System.out.println("Input: {10, 5, 5} | Expected Output: (1) | Output: " + isMagicArray(input3));

            int[] input4 = new int[]{0, 6, 8, 20}  ;
            System.out.println("Input: {0, 6, 8, 20}   | Expected Output: (1) | Output: " + isMagicArray(input4));

            int[] input5 = new int[]{3}  ;
            System.out.println("Input: {3}   | Expected Output: (1) | Output: " + isMagicArray(input5));

            int[] input6 = new int[]{8, 5, -5, 5, 3}  ;
            System.out.println("Input: {8, 5, -5, 5, 3}   | Expected Output: (0) | Output: " + isMagicArray(input6));
        }

        static  int isMagicArray (int[ ] a) {
            if(a.length == 1 && isPrime(a[0]) == 1) return 1;

            int sum = 0;
            boolean hasPrimes = false;

            for(int index = 0 ; index < a.length; index++){
                if(index != 0){
                    if(isPrime(a[index]) == 1){

                        sum += a[index];
                        hasPrimes = true;
                    }
                }
            }

            if(!hasPrimes && a[0] != 0) return 0;
            if(hasPrimes && sum != a[0]) return 0;

            return 1;
        }

        static int isPrime(int value){
            if(value < 2) return 0;

            for(int index = 2 ; index < value; index++){
                if(value % index == 0 ) return 0;
            }

            return 1;
        }
    }