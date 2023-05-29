public class IsTwinArray {

        public static void main(String[] args) {
            int[] input = new int[]{4, 7, 9, 6, 5} ;

            System.out.println(new TesteIsTwinArray().execute(input));
        }
    }

    class TesteIsTwinArray {
        public int execute(int[] arr) {
            for(int number : arr){
                boolean isPrime = this.isPrime(number);
                boolean containTwin = false;

                if(isPrime == true && this.isPrime(number + 2 )){
                    if(this.containsValue(number + 2, arr)) containTwin = true;
                }

                if(isPrime == true && this.isPrime(number - 2 )){
                    if(this.containsValue(number - 2, arr)) containTwin = true;
                }

                if((this.isPrime(number +2) == true || this.isPrime(number - 2) == true) && containTwin == false && isPrime == true) return 0;
            }

            return 1;
        }

        public boolean isPrime(int number){
            if(number < 2) return false;

            for(int index = 2; index < number; index++){
                if(number % index == 0) return false;
            }

            return true;
        }

        public boolean containsValue(int value, int[] arr){
            for(int number : arr){
                if(number == value) return true;
            }

            return false;
        }
    }

