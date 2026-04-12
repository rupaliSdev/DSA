package DSA.BinarySearch;

public class AthMagical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(solve(19,11,13));
	}
	public static int solve(int A, int B, int C) {
        long l= (long)Math.min(B,C);
        long h = (long)Math.min(B,C)*A;
        long a= (long)A;
        long m = 1000000007;
        long ans=-1;
        while(l<=h){
            long mid = (l+h)/2;
            // System.out.print("limit" + mid + " ");
            long x= countMultiple(B,C,mid);
            if(x<a){
                l=mid+1;
            }
            else {
                ans =mid;
                h=mid-1;
            }
            
        }
    return (int)(ans%m);
    }

    public static long countMultiple(long b,long c,long N){
        long x = N/b + N/c -N/Lcm(b,c);
        // System.out.print(N + " " + x + " ");
        return x;
    }
    public static long Lcm(long a,long b) {
		return (a*b)/gcd(a,b);
		
	}
    public static long gcd(long a,long b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

}
