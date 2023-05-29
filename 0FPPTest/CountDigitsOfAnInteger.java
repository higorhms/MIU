public class CountDigitsOfAnInteger {

    public static void main(String[] args) {
        int input = -1245;

        System.out.println(countDigit(32121, 1));
    }

    static int countDigit(int input, int digit) {
        if(input < 0 || digit < 0 ) return -1;

        int count = 0;

        while(input > 0){
            if(input % 10 == digit) count ++;
            input = input / 10;
        }

        return count;
    }
}