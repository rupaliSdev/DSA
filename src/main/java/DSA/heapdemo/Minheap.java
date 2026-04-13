package DSA.heapdemo;

import java.util.Arrays;

public class Minheap {
	
	private int[] heap =new int[100];
	private int size=0;
	private int capacity=100;
	
	
	private int parent(int node) {
		return (node-1)/2;
	}
	//append /push/add
	public void insert(int val) {
		if(size==capacity) {
			grow();
		}
		heap[size]=val;
		rise(size);
		size++;
		
	}
	private void grow() {
		// TODO Auto-generated method stub
		int newCapacity= (capacity+1)*2;
		int[] heapk= Arrays.copyOf(heap,newCapacity);
		
		
	}
	private void rise(int index) {
		// TODO Auto-generated method stub
		
		int parent = parent(index);
		while(parent>=0 && heap[index]<heap[parent]) {
			int temp= heap[index];
			heap[index]=heap[parent];
			heap[parent]=temp;
			
			index=parent;
			parent= parent(index);
		}
		
		
	}
	public int removemin() {
		int minValue = heap[0];
		heap[0]=heap[size-1];
		sink(0);
		size--;
		return minValue;
	}
	
	private void sink(int i) {
		
		while(true) {
			int child= leftChild(i);
			if(child>size) {
				return;
			}
			int rchild=rightChild(i);
			if(rchild<size && heap[rchild] <heap[child]) {
				child= rchild;
				
			}
			if(heap[child] >=heap[i]) {
				return;
				
			}
			int temp= heap[i];
			heap[i]=heap[child];
			heap[child]=temp;
			i=child;
			
			
		}
		
	}
	private int rightChild(int i) {
		// TODO Auto-generated method stub
		return 2*i+2;
	}
	private int leftChild(int i) {
		// TODO Auto-generated method stub
		return 2*i+1;
	}
	public int peekmin() throws Exception {
		if(size()>0) {
			return heap[0];
		}
		else {
			throw new Exception("underflow");
		}
	}
	int size() {
		return this.size;
		
	}
	

}
