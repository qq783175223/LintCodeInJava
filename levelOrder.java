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
    //二叉树的宽度优先算法
    //一个队列搞定
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> listInside=null;
        if(root==null){
            return list;
        }
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        int Qsize=1,tmp=0;//Qsize是每一个层的节点个数
        while(!q.isEmpty()){
            listInside=new ArrayList<Integer>();
            while(Qsize-->0){
                TreeNode node =q.poll();
                listInside.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                    tmp++;
                }
                if(node.right!=null){
                    q.add(node.right);
                    tmp++;
                }
            }
            Qsize=tmp;
            tmp=0;
            list.add(listInside);
        }
        return list;
    }
}