package DSA.maths;

public class TrailingZerosInFactorial {
    public static void main(String[] args) {

        //nothing but finding factors of 5

        //multiples of 5 contributes to zero
        //there are more no of 2s as compared to 5s all even no contributes to 2

        //we need to find multiples of 5 present

        /* N/5
        * So yes — it counts all numbers divisible by 5 ✅

🔹 But why is that NOT enough?

Because some numbers contribute more than one 5.

Example:

25 = 5 × 5 → contributes 2 fives
50 = 2 × 5 × 5 → contributes 2 fives
75 = 3 × 5 × 5 → contributes 2 fives
100 = 4 × 5 × 5 → contributes 2 fives

👉 These extra 5s are not counted in 100 / 5
        *
        *
        *
        * */

        System.out.println(countTrailingZeros(100));


    }

    private static int countTrailingZeros(int N) {
       int count =0;
        while (N>0){
            N= N/5;
            count+= N;
        }
        return count;
    }
}
