package DSA.stack;

import java.util.Scanner;
import java.util.Stack;

public class GetMinEementFromStack {
 
int minEle =Integer.MAX_VALUE;
    
    Stack<pair> st= new Stack<>();


    /*returns min element from stack*/
    int getMin()
    {
        
         if(!st.isEmpty()){
	       return st.peek().second;
	   }
	//System.out.println("min");
	 return -1;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	   if(!st.isEmpty()){
	       //System.out.println("pop");
	       int x= st.peek().first;
	       st.pop();
	       return x;
	   }
	   return -1;
    }

    /*push element x into the stack*/
    void push(int x)
    {
        
       if(!st.isEmpty()){
           st.push(new pair(x,Math.min(st.peek().second,x)));
           return;
           
       }
	  st.push(new pair(x,x));
	   //System.out.println(minEle+"push "+ x);
	   
	 
    }	



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				int T = sc.nextInt();
				while(T>0)
				{
					int q = sc.nextInt();
					GetMinEementFromStack g = new GetMinEementFromStack();
					while(q>0)
					{
						int qt = sc.nextInt();
						
						if(qt == 1)
						{
							int att = sc.nextInt();
							g.push(att);
							//System.out.println(att);
						}
						else if(qt == 2)
						{
							System.out.print(g.pop()+" ");
						}
						else if(qt == 3)
						{
							System.out.print(g.getMin()+" ");
						}
					
					q--;
					}
					System.out.println();
				T--;
				}
				
			}
		

	

}
class pair{
    int first ;
    int second;
    pair(int x,int y){
        first=x;
        second =y;
    }
}
