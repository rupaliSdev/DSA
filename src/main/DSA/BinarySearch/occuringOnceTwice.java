package DSA.BinarySearch;

public class occuringOnceTwice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,2,3,3,4,5,5,6,6,7,7,8,8};
		System.out.println(answer(arr));
		

	}
	
	public static int answer(int[] arr) {
		int ans=0;
		int l=0,r=arr.length;
		while(l<=r) {
			int mid=(l+r)/2;
			if(arr[mid]!=arr[mid+1]&& arr[mid]==arr[mid-1]) {
				r=mid-1;
			}
			else if(arr[mid]==arr[mid+1]) {
				l=mid+1;
			}
			else {
				ans=mid;
				break;
			}
		}
		return ans;
	}

}
