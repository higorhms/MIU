public class MeeraCannotFindValueX2 {

    public static void main(String[] args){
        int[] input = new int[]{8, 3, 4};

        System.out.println(isMeera(input));
    }

    static int isMeera(int[] arr){
        for(int number : arr){
            boolean contains = contains(number * 2, arr);

            if(contains) return 0;
        }

        return 1;
    }

    static boolean contains(int value, int[] arr){
        for(int number : arr){
            if(value == number) return true;
        }

        return false;
    }
}
