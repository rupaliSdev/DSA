package DSA.LinkedList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class LinkedlistUSingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		boolean[] b = new boolean[2];
		HashMap<node,node> map = new HashMap<>();
		
		node x= new node(2);
		x.next = new node(3);
		x.next.next =new node(4);
		x.next.next.next =new node(5);
		x.next.next.next.next=new node(6);
//		while(x!= null) {
//			System.out.println(x.d);
//			x= x.next;
//		}
		// putting node  and its address in pointer in a map
		node i=x;
		while(i!=null) {
			node y = new node(i.d);
			map.put(i, y);
			i =i.next;
		}
		//now linking them
		node j=x;
		while(j!=null) {
			node y = map.get(j);
			y.next =map.get(j.next);
			
			j=j.next;
		}
	    node curr =x;
		while(curr!= null) {
		System.out.println(curr.d);
		curr= curr.next;
	}
		
		
		
		
		
		
		
		
		
		//printing node values
//		node k=map.get(x);
//		while(k!=null) {
//			System.out.println(k.d);
//			k= k.next;
//			
//		
//		}
//		
		
		
		
//		java.util.Set<Entry<node, node>> s = map.entrySet();    // EntrySet retrieves Key as well as Values 
//		Iterator i1 = s.iterator();
//		while(i1.hasNext()) {
//			System.out.println(i1.next());   //Key = Value
//		}
//		for(Entry<node, node> entry : map.entrySet()) {
//			System.out.println("key: "+ entry.getKey() + ", value: "+ entry.getValue());
//		}
	}
	

}
class node{
	int d;
	node next ;
	
	node(int data){
		d=data;
		next =null;
	}
}