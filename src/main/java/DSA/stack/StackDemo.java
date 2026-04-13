package DSA.stack;

public class StackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        stack s = new stack();
        System.out.println(s.peek());
        s.display();
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.display();
        int data= s.pop();
        System.out.println(data + " popp");
        s.display();
        System.out.println(s.isEmpty());
        System.out.println(s.size());
        System.out.println(s.peek());

}
}
class Node{
	int x;
	Node next;
	Node( int data){
		x= data;
		next = null;
	}
}
 class stack{
	 int size;
	 Node top;
	 stack(){
		 size=0;
		 top =null;
	 }
	 public void push(int data) {
		 Node x= new Node(data);
		 x.next = top;
		 top = x;
		 size++;
	 }
	 public void display() {
		 Node z = top;
		 while(z!=null) {
			 System.out.println(z.x);
			 z = z.next;
		 }
		 System.out.println("now top is null");
	 }
	 public int pop() {
		 int t = top.x;
		 top = top.next;
		 size--;
		return t;
		 
	 }
	 public boolean isEmpty() {
		 
		return top==null;
		 
	 }
	 public int size() {
		return size;
	 }
	 public int peek() {
		 if(top!=null) {
		 return top.x;
	 }
		return -1;
	 }
 }