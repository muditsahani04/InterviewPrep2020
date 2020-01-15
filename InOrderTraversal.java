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
}
