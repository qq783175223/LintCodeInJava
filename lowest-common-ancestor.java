/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    //二叉树的递归问题,多画一些二叉树例子就清晰很多
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root==null||root==A||root==B){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,A,B);
        TreeNode right=lowestCommonAncestor(root.right,A,B);
        if(left!=null&&right!=null){
            return root;
        }else if(right==null&&left!=null){
            return left;
        }else if(right!=null&&left==null){
            return right;
        }else{
            return null;
        }
    }
}