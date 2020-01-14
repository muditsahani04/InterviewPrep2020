import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	int count, size;
	Map<Integer,Node> cache;
	Node head, tail;

	class Node {
		int data;
		int key;
		Node left;
		Node right;

        Node()
        {
            left = null;
            right = null;
            
        }
		Node(int keyVal,int val)
		{
			data = val;
			key = keyVal;
		}
	}

	public LRUCache(int capacity) {
		count = 0;
		size = capacity;
        head = new Node();
        tail = new Node();
		head.right = tail;
		tail.left = head;
		cache = new HashMap<Integer,Node>();
	}

	public int get(int key) {
		Node res = cache.getOrDefault(key, new Node(-1,-1));
		if (res.data != -1)
		{
			remove(res);
			addTail(res);
		}

		return res.data;
	}

	public void put(int key, int value) {
		if (cache.get(key) == null)
		{
			Node newNode = new Node(key,value);
			addTail(newNode);
            cache.put(key,newNode);
			count++;
		}
		else
		{
			Node node = cache.get(key);
			node.data = value;
			remove(node);
			addTail(node);
		}

		if (count > size)
		{
			Node node = removeHead();
			cache.remove(node.key);
			count--;

		}

	}

	private void remove(Node n)
	{
		Node prev = n.left;
		Node next = n.right;
		prev.right = next;
		next.left = prev;
	}

	private void addTail(Node n)
	{
		Node prev = tail.left;
		tail.left = n; /* important */
		prev.right = n;
        n.left = prev;
		n.right = tail;
	}

	private Node removeHead()
	{
		Node temp = head.right;
		head.right = temp.right;
		temp.right.left = head; /* important */
		return temp;
	}
}
