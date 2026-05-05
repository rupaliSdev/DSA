package DSA.maths.primeNo;

public class CountNoOfDivisors {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int x = noOfDivisior(360);
        System.out.println(x);
    }

    static int noOfDivisior(int N) {
        int[] spf = new int[N + 1];
        spf[0] = -1;
        spf[1] = -1;
        for (int i = 2; i <= N; i++) {
            spf[i] = i;
        }
        for (int i = 2; i <= N; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= N; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }

                }
            }
        }
        int ans = 1;
        while (N > 1) {
            int f = spf[N];
            int count = 0;
            while (spf[N] == f) {
                count++;
                N = N / f;
            }
            ans *= (count + 1);

        }
        return ans;
    }


}
