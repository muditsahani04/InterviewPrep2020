
public class LinkedListHelper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList list = new LinkedList(new Node(1));
		list.add(new Node (2));
		list.add(new Node (3));
		list.add(new Node (4));
		list.add(new Node (5));
		list.add(new Node (6));
		list.add(new Node (7));
		list.display();
		list.reverse();
		System.out.println("\nReversed List :");
		list.display();
	}

}
