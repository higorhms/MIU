package prog26remove_str_dups;

public class Prog6 {

    static String[] removeDups(String[] input){
        if(input.length < 1) return input;

        int leng = input.length;

        for(int index = 0; index < leng; index++){
            for(int secondIndex = index + 1 ; secondIndex<leng ; secondIndex++){
                if(input[index].equals(input[secondIndex])){
                    input[secondIndex] = input[leng - 1];
                    leng--;
                    secondIndex--;
                }
            }
        }

        String[] result =   new String[leng];

        System.arraycopy(input, 0, result, 0, leng);

        return result;
    }

    private static boolean contains(String item, String[] arr){


        for(String value : arr){
            if(value.equals(item)) return true;
        }

        return false;
    }
}
