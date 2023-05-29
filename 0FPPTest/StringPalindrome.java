public class StringPalindrome {
    public static void main(String[] args){
        System.out.println(stringPalindrome("121"));
        System.out.println(numberPalindrome(121));
    }

    static int stringPalindrome(String value){
        String invertedOne = "";

        for(int index = value.length() -1; index >= 0; index--){
            invertedOne += value.charAt(index);
        }

        if(invertedOne.equals(value)) return 1;

        return 0;
    }

    static int numberPalindrome(int value){

        int invertedOne = 0;
        int valueToInvert = value;

        while(valueToInvert > 0){
            invertedOne = invertedOne * 10;
            invertedOne = invertedOne + (valueToInvert % 10);
            valueToInvert = valueToInvert /10;
        }

        if(value == invertedOne) return 1;

        return 0;
    }
}
