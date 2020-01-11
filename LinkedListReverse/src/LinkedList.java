import java.util.ArrayDeque;
import java.util.Deque;

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

public Node reverse(Node start)
{
	
	Node prev1 = null;
	Node prev = null;
	Node next = null;
	Node curr = head;
	
	while (curr !=  start)
	{
		prev1 = curr;
		curr = curr.next;
	}
	while (curr!= null)
	{
		next = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next;
	}
	prev1.next = prev;
	
	return prev;
}

public boolean isPalindrome()
{
	Node p1 = head;
	Node p2 = head;
	
	while (p2 != null && p2.next != null)
	{
		p1=p1.next;
		p2=p2.next.next;
	}
	
	Node mid = null;
	
	if (p2 == null)
		mid = reverse(p1);
	else
		mid = reverse(p1.next);
	
	Node start = head;
	
	while (mid != null)
	{
		if (start.val != mid.val)
			return false;
		start = start.next;
		mid = mid.next;
	}
	
	return true;
}

public boolean isPalindromeUsingStack()
{
	Deque<Integer> stack = new ArrayDeque<Integer>();
	Node p1 = head;
	Node p2 = head;
	
	while (p2!= null && p2.next!= null)
	{
		p1=p1.next;
		p2=p2.next.next;
	}
	
	if (p2 != null)
		p1 = p1.next;
	
	while (p1!= null)
	{
		stack.push(p1.val);
		p1 = p1.next;
	}
	
	p1 = head;
	
	while (!stack.isEmpty())
	{
		if (stack.pop().intValue() != p1.val)
			return false;
		p1 = p1.next;
	}
	
	return true;
}

public void display()
{
	Node temp = head;
	
	while (temp != null)
	{
		System.out.print(temp.val+" ");
		temp = temp.next;
	}
	System.out.println("");
}
}
