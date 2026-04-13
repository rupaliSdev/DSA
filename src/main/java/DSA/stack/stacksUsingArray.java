package DSA.stack;

public class stacksUsingArray {
public static void main(String[] args) {
		
		stacks1 st = new stacks1(5);
		System.out.println(st.pop());
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		st.display();
		System.out.println(st.pop());
		
	}
     
     
}


class stacks1{
	int top;
	int size;
	int capacity;
	int[] arr;
	stacks1(int capacity){
		this.capacity =capacity;
		int[] arr = new int[capacity];
		top =-1;
		size=0;
	}
	public void push(int x) {
		if(size>=capacity) {
			System.out.println("stack overflow occured");
			return;
		}
		top=top+1;
		arr[top]=x;
		size++;
	}
	public int pop() {
		if(top==-1) {
			System.out.println("stack underflow occured");
			return -1;
		}
		int x=arr[top];
		top=top-1;
		
		size--;
		return x;
		
	}
	public int peek() {
		if(top ==-1) {
			return -1;
		}
		return arr[top];
		
	}
	public int sizeofstack() {
		return size;
	}
	
	public void display() {
		for(int i=top ;i>=0;i--) {
			System.out.println(arr[i]);
		}
	}
	
	
	
	
	
}