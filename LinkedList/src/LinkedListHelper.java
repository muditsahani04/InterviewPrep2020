
public class LinkedListHelper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList list = new LinkedList(new Node(1));
		list.add(new Node (2));
		Node node = new Node(3);
		list.add(node);
		list.add(new Node (3));
		list.add(new Node (2));
		list.add(new Node (1));
		//list.add(new Node (1));
		list.display();
		System.out.println("Is Palindrome : " + list.isPalindromeUsingStack());
		list.display();
		System.out.println("Is Palindrome Using Stack : " + list.isPalindrome());
		//list.display();
		
	}

}
