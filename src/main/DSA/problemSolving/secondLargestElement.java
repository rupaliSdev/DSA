package DSA.problemSolving;

public class secondLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solve(int[] A) {
        if(A.length<2){
            return -1;
        }

        int max1= -1;
        int max2=  -1;
        for(int i=0;i<A.length;i++){
            if(A[i]>max1){
                 max2=max1;
                max1=A[i];
               
                //System.out.print(max2); 
            }
            else if(A[i]==max1){
                continue;
            }
            else {
                max2= Math.max(max2,A[i]);
            }
         // System.out.print(max1);  
        }
        return max2;

    }

}
