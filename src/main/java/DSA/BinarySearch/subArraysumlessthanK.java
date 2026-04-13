package DSA.BinarySearch;

public class subArraysumlessthanK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {3,2,5,4,6,3,7,2};
		System.out.println(answer1(arr,30));

	}
	
    static int answer1(int[] arr,int K) {
    	int ans=0;
		int l=0,r=arr.length;
		while(l<=r) {
			int mid=(l+r)/2;
			int x=sumSubArray(arr,mid);
			System.out.println(x + " mid "+ mid+" ");
			if(x>K) {
				r=mid-1;
			}
			else if(x<K) {
				ans=mid;
				l=mid+1;
			}
			else if(x==K){
				ans=mid;
				break;
			}
		}
		return ans;
    }
    static int sumSubArray(int[] arr,int B) {
    	int sum=0;
    	int j=0;
    	int max= Integer.MIN_VALUE;
    	for(int i=0;i<B;i++) {
    		sum +=arr[i];
    	}
    	for(int i=B;i<arr.length;i++) {
    		max=Math.max(max,sum);
    		sum +=(arr[i]-arr[j]);
    		j++;
    	}
    	max=Math.max(max,sum);
		return sum;
    	
    }
}
