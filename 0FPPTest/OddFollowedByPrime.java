public class OddFollowedByPrime {
    public static void main(String[] args) {
        int[] input = new int[]{4, 9, 6, 15, 21};

        System.out.println(execute(input));
    }

    static int execute(int[] arr) {
        if(arr.length < 2) return 0;

        for (int index = 0; index < arr.length -1; index ++){
            if(arr[index] % 2 != 0){
                if(isPrime(arr[index + 1]) == 1) return 1;
            }
        }

        return 0;
    }

    static int isPrime(int value){
        if(value < 2) return 0;

        for(int index = 2; index < value; index++){
            if(value % index == 0) return 0;
        }

        return 1;
    }
}