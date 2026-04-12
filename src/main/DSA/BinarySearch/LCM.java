package DSA.BinarySearch;

public class LCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(12,8));

	}
	static int LcmVal(int a,int b) {
		return (a*b)/gcd(a,b);
		
	}
	static int gcd(int a ,int b) {
		if(b==0) {
			return a;
		}
		return gcd(b,a%b);
		
	}
	
	

}
