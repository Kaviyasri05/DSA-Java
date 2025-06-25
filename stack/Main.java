package stack;
import java.util.*;
import java.util.Scanner;

//PascalCase
//camelCase
//snake_case

// Stack implementation using array
// operations = push, pop, peak, get size, display 
class Stack{
	private int top, capacity, size;
	private int[] arr;
	
	public Stack() {
		System.out.println("Hi from default constructor");
	}
	
	public Stack(int capacity) {
		this.capacity = capacity;
		this.top =-1;
		this.size = 0;
		this.arr = new int[capacity];
	}
	
	public boolean isEmpty() {
		return size ==0;
	}
	public boolean isFull() {
		return size == capacity;
	}

	public void  push(int data) {
		if(isFull()) {
			System.out.println("Stack overflow");
		}
		else {
			arr[++top] = data;
			size++;
		}	
	}
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack Underflow");
			return -1;
		}
		else {
			int ele = arr[top];
			top--;
			size--;
			return ele;		
		}
	}
	public int peak() {
		if(isEmpty()) {
			System.out.println("Stack Underflow from peak");
			return -1;
		}
		int ele = arr[top];
		System.out.println("peak "+ele);
		return ele;
	}
	public int getSize() {
		System.out.println(size);
		return size;	
	}
	public int display() {
		if(isEmpty()) {
			System.out.println("Stack underflow from display");
			return -1;
		}
		else {
			for(int i=0;i<size;i++) {
				System.out.print(arr[i] +" ");
			}
			System.out.println();
		}
		return 0;		
	}
}

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		Stack s = new Stack(5);
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.display();
		s.getSize();
		s.pop();
		s.peak();
		s.display();
	}	
}
