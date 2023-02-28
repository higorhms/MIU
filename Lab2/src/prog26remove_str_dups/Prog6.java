package prog26remove_str_dups;

public class Prog6 {

    static String[] removeDups(String[] input){
        int noDuplicated = 0;


        for(int index = 0; index<input.length; index++){
            for(int secondIndex = index + 1);
        }
        for(String item : input){
            if(contains(item, input)) noDuplicated++;
        }

        String[] result = new String[noDuplicated];

//        for(int index = 0; index < noDuplicated; index++){
//
//        }

        return result;
    }

    private static boolean contains(String item, String[] arr){


        for(String value : arr){
            if(value.equals(item)) return true;
        }

        return false;
    }
}
