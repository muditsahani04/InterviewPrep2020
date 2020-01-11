
public class LinkedList {
Node head;
private Node current;

LinkedList(Node n)
{
	head = n;
	current = n;
}

public void add(Node n)
{
	current.next = n;
	current = n;
}

public void reverse()
{
	Node prev = null;
	Node curr = head;
	Node next = null;
	current = head;
	
	while (curr != null)
	{
		next = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next;
	}
	
	head = prev;
}

public void display()
{
	Node temp = head;
	while (temp != null)
	{
		System.out.print(temp.val+" ");
		temp = temp.next;
	}
}
}
