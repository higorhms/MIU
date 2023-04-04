import java.util.Arrays;

public class BinarySearch {

    public static boolean contains(int[] arr, int value){
        if(arr.length < 1) return false;
        int end = arr.length - 1;
        int init = 0;

        while (init <= end){
//            int middle = init + (end - init) / 2;
            int middle = (init + end) / 2;
            System.out.println("Middle index: " + middle + "\nMiddle value: " + arr[middle] + "\n" + Arrays.toString(arr));
            if(arr[middle] == value) return true;
            boolean left = value < arr[middle] ? true : false;

            if(left){
                end = middle - 1;
            }else{
                init = middle + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[50];

        for(int i = 0; i < 50; i++){
            arr[i] = i;
        }

        System.out.println(String.valueOf(contains(arr, 48)));
    }
}
