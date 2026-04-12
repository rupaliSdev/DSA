package DSA.problemSolving;
//Little Ponny is given an array, A, of N integers. In a particular operation, 
//he can set any element of the array equal to -1.

//He wants your help in finding out the minimum number of operations required such 
//that the maximum element of the resulting array is B. If it is not possible, then return -1.
public class littlePonny {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solve(int[] A, int B) {
        int max = Integer.MIN_VALUE;
        int k =0;
        for(int i =0;i<A.length;i++){
            if(A[i]>B){
                A[i]=-1;
                k++;
            }
           max = Math.max(max,A[i]);
          
        }
        if(max==B){

            return k;
        }
        else{
            return -1;
        }
    }

}
