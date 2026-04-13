package DSA.stack;

public class stackArrayImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        stacks s= new stacks(5);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);
        s.display();
        System.out.println(s.peek());
        
	}

}
class stacks{
	int top ;
	int size;
	int capacity;
	int[] arr;
	stacks(int x){
		top =-1;
		
		capacity =x;
		arr = new int[capacity];
	}
	public int size() {
		return size;
		
	}
	public void push(int x) {
		if(size!=capacity) {
		top = top+1;
		arr[top]=x;
		size++;
	}
		else {
		System.out.println("stack overflow");
		}
	}
	public int pop() {
		if(top!=-1) {
			int x = arr[top];
			top--;
			size--;
			return x;
		}
		System.out.println("stack underflow");
		return -1;
		
	}
	public void display() {
		for(int i=top;i>=0;i--) {
			System.out.println(arr[i]);
		}
	}
	public int peek() {
		if(top==-1) {
			return -1;
		}
		return arr[top];
		
	}
}