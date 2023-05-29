import java.util.Arrays;

public class HasKSmallFactors {
        public static void main(String[] args) {
            System.out.println("Input: 7, 30 | Expected Output: (true) | Output: " + hasKSmallFactors(7, 30));
            System.out.println("Input: 6, 14 | Expected Output: (false) | Output: " + hasKSmallFactors(6, 14));
            System.out.println("Input: 6, 30 | Expected Output: (false) | Output: " + hasKSmallFactors(6, 30));
            System.out.println("Input: 10, 20 | Expected Output: (true) | Output: " + hasKSmallFactors(10, 20));
            System.out.println("Input: 10, 22 | Expected Output: (false) | Output: " + hasKSmallFactors(10, 22));
        }

        static boolean hasKSmallFactors(int k, int n)  {
            if(k < 1 || n < 1) return false;

            int currentFactor = 1;

            while(currentFactor < k){
                boolean isFactor = n % currentFactor == 0 ? true : false;

                if(isFactor){
                    for(int index = 1; index < k; index++){
                        boolean secondIndexIsFactor = n % index == 0 ? true : false;

                        if(secondIndexIsFactor){
                            if(currentFactor * index == n) return true;
                        }
                    }
                }

                currentFactor++;
            }

            return false;
        }


    }