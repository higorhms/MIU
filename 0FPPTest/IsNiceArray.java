public class IsNiceArray {
    public static void main(String[] args) {
        int[] input = new int[]{8, 5, -5, 5, 3};

        System.out.println(new TesteIsNiceArray().isNiceArray(input));
    }
}

class TesteIsNiceArray {
    public int isNiceArray(int[ ] a) {
        if(a.length == 1 && this.isPrime(a[0]) == 1) return 1;
        if(a.length == 1 && this.isPrime(a[0]) != 1) return 0;

        int sum = 0;

        for(int index = 1; index < a.length; index++){
            if(this.isPrime(a[index]) == 1){
                sum = sum + a[index];
            }
        }

        if(sum == 0 && a[0] == 0) return 1;

        if(sum > 0){
            if(sum == a[0]) return 1;
        }

        return 0;
    }

    public int isPrime(int number){
        if(number < 2) return 0;

        for(int index = 2; index < number; index++){
            if(number % index == 0) return 0;
        }

        return 1;
    }
}

