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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        pathSumHelper(root, res, path,sum);
        return res;
    }

    private void pathSumHelper(TreeNode root,List<List<Integer>> res, List<Integer> path, int sum)
    {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
        {
            if (root.val == sum)
            {
                path.add(root.val);
                res.add(new ArrayList<Integer> (path));
                path.remove(path.size()-1);
                return;
            }
            else
            {
                return;
            }
        }
        path.add(root.val);
        pathSumHelper(root.left, res, path, sum-root.val);
        pathSumHelper(root.right, res, path, sum-root.val);
        path.remove(path.size()-1);
        return;
    }
}
