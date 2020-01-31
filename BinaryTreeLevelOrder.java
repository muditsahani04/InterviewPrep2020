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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //helper(0, res,root);
        helperIterative(root,res);
        return res;
    }

    private void helper(int depth, List<List<Integer>> res, TreeNode current)
    {
        if (current == null)
            return;
        if (depth == res.size())
        {
            List<Integer> list = new ArrayList<Integer>();
            res.add(list);
        }

        res.get(depth).add(current.val);
        helper(depth+1, res,current.left);
        helper(depth+1, res,current.right);
        return;
    }

    private void helperIterative(TreeNode root, List<List<Integer>> res)
    {
        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
        if (root == null)
            return;
        TreeNode current = root;
        q.add(current);
        while(!q.isEmpty())
        {

            List<TreeNode> temp = new ArrayList<TreeNode>();
            while (!q.isEmpty())
            {
                current = q.poll();
                temp.add(current);
            }

            if (temp.size() != 0)
            {
                List<Integer> temp1 = new ArrayList<Integer>();
                for (TreeNode num : temp)
                {
                    temp1.add(num.val);
                    if (num.left != null)
                    q.add(num.left);
                    if (num.right != null)
                    q.add(num.right);
                }
                res.add(temp1);
            }

        }
    }
}
