/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return heapHelper(lists);
    }
    private ListNode helper(ListNode p, ListNode q)
    {
        ListNode currentP = p.next;
        ListNode currentQ = q;
        ListNode prevP = p;
        ListNode temp = null;

        while (currentP!= null && currentQ!=null)
        {
            if (currentQ.val <= currentP.val)
            {
                temp = currentQ;
                prevP.next = temp;
                currentQ = currentQ.next;
                temp.next = currentP;
                prevP = temp;
            }
            else
            {
                prevP = currentP;
                currentP = currentP.next;
            }
        }

        if (currentP == null)
        {
            prevP.next = currentQ;
        }
        return p;
    }

    private ListNode heapHelper(ListNode[] lists)
    {
        if (lists.length == 0)
            return null;
        ListNode res = new ListNode(Integer.MIN_VALUE);
        Queue<ListNode> minHeap = new PriorityQueue<>(
            ((int)lists.length), new Comparator<ListNode>(){
      @Override
      public int compare(ListNode a, ListNode b)
      {
          return Integer.compare(a.val, b.val);
      }

        });

        for (ListNode n : lists)
        {
            if (n!=null)
                minHeap.add(n);
        }

        ListNode curr = res;
        while (!minHeap.isEmpty())
        {
           ListNode out = minHeap.poll();
           curr.next = out;
           curr = curr.next;
           if (out.next!=null)
               minHeap.add(out.next);

        }
        return res.next;
    }
}
