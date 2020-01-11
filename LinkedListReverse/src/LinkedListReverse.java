
public class LinkedListReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList(new Node(1));
		list.add(new Node (2));
		Node node = new Node(3);
		list.add(node);
		list.add(new Node (4));
		list.add(new Node (5));
		list.add(new Node (6));
		list.add(new Node (7));
		list.display();
		
		System.out.println("Reverse List :");
		list.reverse();
		list.display();
		System.out.println("Reverse List at Node 3:");
		list.reverse(node);
		list.display();
		
	}

}
