public class IsFactorEqual {

        public static void main(String[] args) {
            int[] input = new int[]{-8, 0, 0, 8, 0};

            System.out.println(new TesteIsFactorEqual().execute(10, 12));
        }
    }

    class TesteIsFactorEqual {
        public int execute(int a, int b) {
            int factorsA, factorsB = 0;

            factorsA = this.getNumberOfFactors(a);
            factorsB = this.getNumberOfFactors(b);


            if(factorsA == factorsB) return 1;

            return 0;
        }

        public int getNumberOfFactors(int number){
            int numberOfFactors = 0;

            for(int index = 1; index <= number; index++){
                if(number%index == 0) numberOfFactors++;
            }

            return numberOfFactors;
        }
    }

