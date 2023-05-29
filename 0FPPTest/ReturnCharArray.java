public class ReturnCharArray {

    public static void main(String[] args){
        char[] input = new char[]{};

        char[] response = new TesteReturnCharArray().execute(input, 0, 1);

        if(response == null) {
            System.out.println("null");
        }else {
            System.out.println(response);
        }

    }
}

class TesteReturnCharArray {
    public char[] execute(char[] chars, int start, int len) {
            if(chars == null) return null;
            if(len >= chars.length && start > 0) return null;
            if(len > chars.length || start >= chars.length) return null;
            if(len < 0 || start < 0) return null;
            if(len == 0) return new char[]{};


            char[] newArray = new char[len];
            int newArrayIndex = 0;

            for(int index=start; index < start+len; index++) {
                newArray[newArrayIndex] = chars[index];
                newArrayIndex++;
            }

            return newArray;
    }
}
