package DSA.problemSolving;

import java.util.Scanner;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        while(t>0){
	        long N = sc.nextLong();
	        long sum =1;
	        long i;
	        for( i =2;i*i<N;i++){
	               if(N%i == 0)
	               {
	                   sum += i +(N/i);

	               }
	        }
	        if(i ==N/i){
	            sum +=i; 
	        }
	        if(sum==N){
	            System.out.println("YES");
	        }
	        else{
	            System.out.println("NO");
	        }

	            t--;
	        }
	        

	}
	
	public static int perfectSquare(int A) {
		for(int i=1;i*i<=A;i++){
	         if(i*i==A){
	             return i;
	         }
	     }

	      return -1;  
		
	}
	
	public static int isItPerfect() {
		return 0;
		
	}

}
