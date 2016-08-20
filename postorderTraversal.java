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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list=new ArrayList<Integer>();
        postorderTraversal2(root,list);
        return list;
    }
    
    public void postorderTraversal2(TreeNode root,ArrayList<Integer> list){
        if(root!=null){
            postorderTraversal2(root.left,list);
            postorderTraversal2(root.right,list);
            list.add(root.val);
        }
    }
}