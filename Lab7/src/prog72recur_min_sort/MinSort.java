package prog72recur_min_sort;

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

    public static void main(String[] args) {
        MinSort ms = new MinSort();
        String result = ms.sort("zwxuabfkafutbbbb");
        System.out.println(result);
    }
}
