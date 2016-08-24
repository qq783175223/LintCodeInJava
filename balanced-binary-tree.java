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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root==null){
            return true;
        }
        //如果从当前节点开始的子树不是平衡树，那么整个树就不是平衡树
        if(Math.abs(getHeight(root.left)-getHeight(root.right))>1){
            return false;
        }else{
            //如果从当前节点开始的子树是平衡树，那么它的左右子树也都要是平衡树
            return isBalanced(root.left)&&isBalanced(root.right);
        }
        
    }
    
    //得到某个子树的最深度
    public int getHeight(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}