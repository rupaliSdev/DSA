package DSA.BinarySearch;

import java.util.ArrayList;

public class peakElementproblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solve(ArrayList<Integer> A) {
        int l = 1, h = A.size()-1;
       
        while(l<=h){
            int mid = (l+h)/2;
            if(A.get(mid)>A.get(mid-1)){

                l=mid+1;
            }
            else{
                h= mid-1;
            }

        }
        return A.get(l-1);
    }
}
