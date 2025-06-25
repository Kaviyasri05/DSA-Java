package queue;
import java.util.*;

class Queue{
	private int front, rear, size, capacity;
	private int[] arr;
	
	public Queue() {
		System.out.println("Default constructor");
	}
	public Queue(int capacity) {
		this.capacity = capacity;
		this.front = 0;
		this.rear = -1;
		this.size = 0;
		this.arr = new int[capacity];
	}
	
	public boolean isEmpty() {
		return size ==0;
	}
	public boolean isFull() {
		return size == capacity;
	}
	
	public void enqueue(int data) {
		if(isFull()) {
			System.out.println("Queue Overflow");
		}
		else {
			rear = (rear+1) % capacity;
			arr[rear] = data;
			size++;
			System.out.println("Enqueue done!");
		}
	}
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue Underflow");
			return -1;
		}
		else {
			int ele = arr[front];
			front = (front+1) % capacity;
			size--;
			System.out.println("Dequeue done!");
			return ele;
		}
		
	}
	
	public int peak() {
		if(isEmpty()) {
			System.out.println("Queue Underflow");
			return -1;
		}
		else {
			int ele = arr[front];
			System.out.println("Peak : "+ele);
			return ele;
		}
	}
	public int getSize() {
		System.out.println(size);
		return size;
	}
	
	public int display() {
		if(isEmpty()) {
			System.out.println("Queue Underflow");
			return -1;
		}
		else {
			for(int i=0;i<size;i++) {
				System.out.println(arr[(front+i) % capacity]+" ");
			}
	        System.out.println();
		}
		return 0;
	}
	
}

public class  Main{
	
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		Queue q = new Queue(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
//		q.dequeue();
		q.enqueue(6);
		q.dequeue();
		q.display();
		q.getSize();
	}	
}