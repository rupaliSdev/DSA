package DSA.queue;

public class queueArrayImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queueA x= new queueA(5);
		x.offer(20);
		x.offer(30);
		x.offer(40);
		x.offer(50);
		x.offer(60);
//		x.offer(70);
		x.remove();
		x.print();

	}
	

}

class queueA{
	int size;
	int capacity;
	int[] arr;
	int front =-1;
	int rear = -1;
	
	queueA(int x){
		 capacity = x;
         arr= new int[x];
         
	}
	public void offer(int x) {
		rear++;
		if(rear==capacity) {
			System.out.println("index out of bound");
			return;
		}
		
		arr[rear]= x;
		size++;
	}
	
	public int remove() {
		front++;
		return arr[front];
	}
	public void print() {
		for(int i=front+1 ;i<=rear;i++) {
			System.out.println(arr[i]);
		}
	}
//	@Override
//	public String toString() {
//		return "queueA [size=" + size + ", capacity=" + capacity + ", arr=" + Arrays.toString(arr) + ", front=" + front
//				+ ", rear=" + rear + "]";
//	}
	
}
