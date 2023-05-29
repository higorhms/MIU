public class ReverseInteger {

    public static void main(String[] args){
        System.out.println(new ReverseIntegerTest().reverse(10000));
    }

}


class ReverseIntegerTest {
    public int reverse(int n){
        if(n == 0) return 0;

        int invertedNumber = 0;

        if( n > 0 ){
           while(n > 0){
               invertedNumber = invertedNumber * 10;
               invertedNumber = invertedNumber + (n % 10);
               n = n / 10;
           }
        }else{
            while(n<0){
                invertedNumber = invertedNumber * 10;
                invertedNumber = invertedNumber + ( n % 10);
                n = n /10;
            }
        }

        return invertedNumber;
    }
}