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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return list;
        }
        //将上一层的节点放入q1,下一层的节点放入q2
        Queue<TreeNode> q1=new LinkedList<TreeNode>();
        Queue<TreeNode> q2=new LinkedList<TreeNode>();
        q1.add(root);
        while(!q1.isEmpty()||!q2.isEmpty()){
            ArrayList<Integer> listInside1=new ArrayList<Integer>();
            ArrayList<Integer> listInside2=new ArrayList<Integer>();
            while(!q1.isEmpty()){
                TreeNode node=q1.poll();
                listInside1.add(node.val);
                if(node.left!=null){
                    q2.add(node.left);  
                }
                if(node.right!=null){
                    q2.add(node.right); 
                }
            }
            if(listInside1.size()>0)
                list.add(listInside1);
            while(!q2.isEmpty()){
                TreeNode node=q2.poll();
                listInside2.add(node.val);
                if(node.left!=null){
                    q1.add(node.left);  
                }
                if(node.right!=null){
                    q1.add(node.right); 
                }
            }
            if(listInside2.size()>0)
                list.add(listInside2);
        }
        return list;
    }

}