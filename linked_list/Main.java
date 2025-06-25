package linked_list;
class Node{
	int data;
	Node next;
	
	public Node(){
		System.out.println("Node creation done!");
	}
	public Node(int data) {
		this();
		this.data = data;
	}
	public Node(int data, Node next) {
		this(data);
		this.next=next;
	}
}

class UDLinked_list { //UserDefined_Linked_List
	private Node head, tail;
	private int size;
	
	public UDLinked_list() {
		head = tail = null;
		size =0;
	}
	
	public boolean isEmpty() {
		return size ==0;
	}
	
	public void add_first(int data) {
		Node n = new Node(data);
		if(isEmpty()) {
			head = tail = n;
		}
		else {
			n.next = head;
			head = n;
		}
		size++;
		
	}
	
	public void add_last(int data) {
		Node n = new Node(data);
		if(isEmpty()) {
			head = tail = n;
		}
		else {
			tail.next = n;
			tail = n;	
		}
		size++;
	}
	
	public void add_at_index(int data, int index) {
		if(index<0 || index>size) {
			System.out.println("Invalid Index, cannot be added"); //Edge case handling
			return;
		}
		Node n = new Node(data);

		if(isEmpty()) {
			head=tail=n;
		}
		if(index == 0) add_first(data);
		else if(index == size) add_last(data);
		
		else {
			Node temp = head;
			for(int i=0;i<index-1;i++) {
				temp = temp.next;
			}
			n.next = temp.next;
			temp.next = n;
		}
		size++;
	}
	
	public int delete_first() {
		if(isEmpty()) {
			System.out.println("No node in LL to delete");
			return -1;
		}
		int temp = head.data;
		head = head.next;
		System.out.println("First node deleted");
		size--;
		return temp;
	}
	
	public int delete_last() {
		if(isEmpty()) {
			System.out.println("No node in LL to delete");
			return -1;
		}
		Node temp = head;
		while(temp.next != tail) {
			temp = temp.next;
		}
		int ele = tail.data;
		temp.next = null;
		tail=temp;
		System.out.println("Last node deleted");
		size--;
		return ele;
	}
	
	public int delete_at_index(int index) {
		if(index<0 || index>size) {
			System.out.println("Invalid Index, cannot be added"); //Edge case handling
			return -1;
		}
		if(index ==0) return delete_first();
		else if(index==size-1) return delete_last();
		else {
			Node temp = head;
			for(int i=0;i<index-1;i++) {
				temp = temp.next;
			}
			int ele = temp.next.data;
			temp.next = temp.next.next;
			System.out.println("Deleted in index : "+index);
			size--;
			return ele;
		}
	}
	
	public int get_value_by_index(int index) {

		if(index<0 || index>=size) {
			System.out.println("value cannot be retrived");
			return -1;
		}
		if(index==0) {
			
//			System.out.println("value found at 1st index: "+index +" is "+head.data);
			return head.data;
		}
		if(index == size-1) {
//			
//			System.out.println("value found at last index: "+index +" is "+tail.data);
			return tail.data;
		}
		Node temp = head;
		for(int i=0;i<index;i++) {
			temp = temp.next;
		}
//			System.out.println("value found at index: "+index +" is "+temp.data);
		
		return temp.data;
	}
	
	public int get_size() {
		return size;
	}
	@Override
	public String toString() {
		String ans = "";
		Node temp = head;
		while(temp!=null) {
			ans+= temp.data+" ";
			temp = temp.next;
		}
		ans+="\n";
		return ans;
	}
	
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		UDLinked_list l1 = new UDLinked_list();
		l1.add_first(5);
		l1.add_first(6);
		l1.add_first(7);
		l1.add_first(8);
		l1.add_at_index(9,3);
		l1.add_last(10);
		l1.delete_first();
		l1.delete_last();
		l1.delete_at_index(3);
		l1.get_value_by_index(3);
		System.out.println(l1);
		System.out.println("Size of Linked List: " + l1.get_size());
	}

}
