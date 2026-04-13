package DSA.Hashing;

import java.util.*;
import java.util.Map.Entry;

public class frequency_elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr ={2,3,3,4,2,6,7,8,2,4,3,6};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++) {
        	if(map.containsKey(arr[i])) {
        		int x=  map.get(arr[i]);
        		x++;
        		map.put(arr[i],x);
        	}
        	else {
        	map.put(arr[i], 1);
        	}
        }
        
        
        for(Entry<Integer,Integer>j : map.entrySet()) {
        	System.out.println("the key is "+ j.getKey()+ " & the value is "+ j.getValue());
        }
        frequencyone(arr);
	}
     public static void frequencyone(int[] arr) {
    	 HashMap<Integer,Integer> map = new HashMap<>();
         for(int i =0;i<arr.length;i++) {
         	if(map.containsKey(arr[i])) {
         		int x=  map.get(arr[i]);
         		x++ ;
         		map.put(arr[i],x);
         	}
         	else {
         	map.put(arr[i], 1);
         	}
         }
         for(int j =0;j<arr.length;j++) {
          	if(map.get(arr[j])==1) {
          		System.out.println("the first distinct element " + arr[j]);
          		break;
          	}
          }
     }
     
}
