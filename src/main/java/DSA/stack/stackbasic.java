package DSA.stack;

public class stackbasic {
	
	public static void main(String[] args) {
		
		stack1 st = new stack1(5);
		System.out.println(st.pop());
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		st.display();
		System.out.println(st.pop());
		
	}

	
	

}   


class stack1{
	Node1 top ;
	int size;
	int capacity;
	public stack1(int x) {
		//super();
		top = null;
		size = 0;
		capacity=x;
	}
	public void display() {
		// TODO Auto-generated method stub
		Node1 curr=top;
		while(curr!=null) {
			System.out.println(curr.val);
			curr=curr.next;
		}
		
	}
	public int pop() {
		// TODO Auto-generated method stub
		if(size==0) {
			return -1;
		}
		int x= top.val;
		top =top.next;
		size--;
		return x;
	}
	public void push(int val) {
		
		if(size==capacity) {
			System.out.println("the stack is full");
			return;
		}
		Node1 x= new Node1(val);
		x.next=top;
		top=x;
		size++;
	}
	
	
	
}

class Node1{
	int val;
	Node1 next;
	Node1(int val){
		this.val=val;
		next=null;
	}
}