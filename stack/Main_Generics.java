package stack;

class MyStack<T> {
    private T[] arr;
    private int top;

    @SuppressWarnings("unchecked")
    public MyStack(int size) {
        this.arr = (T[]) new Object[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

    public void push(T data) {
        if (isFull()) {
            System.out.println("Stack Overflow");
        } else {
            arr[++top] = data;
        }
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return null;
        }
        return arr[top--];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Main_Generics {

    public static void main(String[] args) {
        MyStack<String> s1 = new MyStack<>(5);
        s1.push("hi");
        s1.push("kat");
        s1.push("hello");
        s1.pop();
        s1.display();
    }
}
