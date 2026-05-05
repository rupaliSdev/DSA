package DSA.maths;

public class PowExpo {

    public static void main(String[] args) {

        System.out.println(myPowII(2.0000, 10));
        System.out.println(myPow(1 / 2.0000, -2));

    }

    public static double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }
        double p1 = myPow(x, n / 2);

        if (n % 2 == 1) {
            return p1 * x * p1;
        } else return p1 * p1;

    }

    public static double myPowII(double x, int N) {
        long n= N;
        if(n<0){
            x= 1/x;
            n= -n;
        }
        double result =1;
        while(n>0){
            //n is odd we need to add extra x and even ones will be handled with x
            if((n & 1) ==1){
                result *= x;
            }

            x = x*x;
            n= n >>1;
        }
        return result;
    }
}
