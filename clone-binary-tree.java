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
     * @param root: The root of binary tree
     * @return root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        // Write your code here
        return preTraverse(root);
    }
    public TreeNode preTraverse(TreeNode root){
        if(root!=null){
            TreeNode node=new TreeNode(root.val);
            node.left=preTraverse(root.left);
            node.right=preTraverse(root.right);
            return node;
        }else{
            return null;
        }
    } 
}