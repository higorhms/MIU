public class MinDIstanceTwoFactors {
        public static void main(String[] args) {
            System.out.println("13013: " + minDistance(13013));

            System.out.println("8: " + minDistance(8));
        }

        static int minDistance(int input) {
            int smallestDistance = input;
            int lastFactor = 1;

            for(int index = 2; index < input; index++){
                boolean isFactor = false;

                if(input % index == 0) isFactor = true;

                if(isFactor){
                    int currentFactorDistance = index - lastFactor;

                    if(currentFactorDistance < smallestDistance) smallestDistance = currentFactorDistance;

                    lastFactor = index;
                }
            }

            return smallestDistance;
        }
    }