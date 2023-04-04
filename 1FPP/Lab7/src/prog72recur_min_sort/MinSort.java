package prog72recur_min_sort;

import java.util.Arrays;

public class MinSort {

    public String sort(String value){
        if(value.length() == 1) return value;
        char highestChar = value.charAt(0);

        for(int index = 0; index < value.length(); index++){
            if(value.charAt(index) > highestChar) highestChar = value.charAt(index);
        }

        String result = value.replaceFirst(String.valueOf(highestChar), "");

        return sort(result) + highestChar;
    }

    public void sort(int[] arr){
        for(int index = 0; index < arr.length; index++){
            for(int secondIndex = index; secondIndex < arr.length; secondIndex++){
                if(arr[index] > arr[secondIndex]){
                    int aux = arr[index];
                    arr[index] = arr[secondIndex];
                    arr[secondIndex] = aux;
                }
            }
        }
    }

    public static void main(String[] args) {
        MinSort ms = new MinSort();
        String result = ms.sort("zwxuabfkafutbbbb");
        System.out.println(result);

        int[] arr = new int[]{5,9,10,3,5,1,2,3};
        ms.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
