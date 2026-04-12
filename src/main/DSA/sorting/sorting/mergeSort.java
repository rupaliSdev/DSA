package DSA.sorting.sorting;

public class mergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] a= {2,5,10,34};
        int[] b = {-1,4,12,33,35};
        int[] c =merge(a,b);
        
        for(int i=0;i<c.length;i++) {
        	System.out.println(c[i]+" ");
        }
	}

	private static int[] merge(int[] a, int[] b) {
		// TODO Auto-generated method stub
		
		int i=0,j=0;
		int k=0;
		int[] c= new int[a.length+b.length];
		while(i<a.length && j<b.length) {
			c[k++]= a[i]>b[j] ?b[j++]:a[i++];
		}
		
		while(i<a.length) {
			c[k++]=a[i++];
		}
		while(j<b.length) {
			c[k++]=b[j++];
		}
		return c;
	}
	
	
	

}
