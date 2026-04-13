package DSA.problemSolving;

import java.util.Scanner;
///153 = ( 1 * 1 * 1 ) + ( 5 * 5 * 5 ) + ( 3 * 3 * 3 )
public class armstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r=0;
        int sum=0;
        for(int i=1;i<=N;i++){
            while(i>0){
               int p =i%10;
                sum += p*p*p;
                i=i/10;
            }
            if(sum==i){
                System.out.println(i);
            }
        }
        

	}
	

}
