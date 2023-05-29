public class SetEqualFirstArrayContainsSecond {
        public static void main(String[] args) {
            int[] input = new int[]{13, 14, 15, 3, 5} ;
            int[] input2 = new int[]{13, 14, 15, 3, 9} ;

            System.out.println(new TesteSetEqualFirstArrayContainsSecond().execute(input, input2));
        }
    }

    class TesteSetEqualFirstArrayContainsSecond {
        public boolean execute(int[] arr1, int[] arr2) {

            boolean firstContains = this.oneContainsTheOther(arr1, arr2);
            boolean secondContains = this.oneContainsTheOther(arr2, arr1);

            if(firstContains == true && secondContains == true) return true;

            return false;
        }

        public boolean oneContainsTheOther(int[] arr1, int[] arr2){
            for(int number : arr1){
                boolean contains = false;

                for(int secondNumber : arr2){
                    if(number == secondNumber) contains = true;
                }

                if(contains == false) return false;
            }

            return true;
        }
    }

