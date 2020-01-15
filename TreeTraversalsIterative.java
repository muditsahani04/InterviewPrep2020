/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        iterativeHelper(root, res);
        return res;
    }

    private void iterativeHelper(TreeNode root, List<Integer> res)
    {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode current = root;
        while (current!= null || !stack.isEmpty())
        {
            while (current != null)
            {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            res.add(current.val);
            current = current.right;
        }
    }
    /*
     * Iterative PreOrder traversal Binary Tree
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        TreeNode current = root;
        while (current!= null || !stack.isEmpty())
        {
            while (current!= null)
            {
                res.add(current.val);
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            current = current.right;
        }
        return res;
    }
    /*
     * Iterative PostOrder traversal Binary Tree
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode current = root;
        while (current!= null || !stack.isEmpty())
        {
            while (current!= null)
            {
                res.addFirst(current.val); // reverse of PreOrder
                stack.push(current);
                current = current.right;// reverse of PreOrder
            }

            current = stack.pop();
            current = current.left;// reverse of PreOrder
        }
        return res;
    }
}
