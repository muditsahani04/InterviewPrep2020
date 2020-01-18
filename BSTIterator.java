/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    Deque<TreeNode> stack ;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<TreeNode>();
        initializeStack(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int res = node.val;
        if (node.right != null)
        {
            node = node.right;
            while (node != null)
            {
                stack.push(node);
                node = node.left;
            }
        }

        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void initializeStack(TreeNode root)
    {
        TreeNode node = root;
        while (node!= null)
        {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
