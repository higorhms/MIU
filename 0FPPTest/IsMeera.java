public class IsMeera {

        public static void main(String[] args) {
            int[] input = new int[]{7, 0};

            System.out.println(new TesteIsMeera().isMeera(input));
        }
    }

    class TesteIsMeera {
        public int isMeera(int[ ] a) {

            for(int number : a){
                boolean isPrime = this.isPrime(number);

                if(isPrime){
                    for(int secondNumber : a){
                        if(secondNumber == 0) return 1;
                    }
                }
            }

            return 0;
        }

        public boolean isPrime(int number){
            if(number < 2) return false;

            for(int index = 2; index < number; index++){
                if(number % index == 0) return false;
            }

            return true;
        }
    }

