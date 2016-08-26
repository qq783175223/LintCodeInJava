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
     * @return: Preorder in ArrayList which contains node values.
     */
    //采用非递归
    //用一个栈实现(DFS遍历)
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack=new Stack<TreeNode>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        stack.push(root);
        while(!stack.empty()){
            TreeNode node=stack.pop();
            list.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return list;
    }
}