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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> listInside=null;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        boolean flag=false;//flag=true表示从右往左遍历,flag=false表示从左往右遍历
        int Qsize=1,tmp=0;//Qsize计数器(计算某一层有多少个节点)
        if(root==null){
            return list;
        }
        queue.add(root);
        //注意队列判断空的写法
        while(!queue.isEmpty()){
            listInside=new ArrayList<Integer>();
            while(Qsize-->0){
                TreeNode node=queue.poll();
                listInside.add(node.val);
                if(node.right!=null){
                    queue.add(node.right);
                    tmp++;
                }
                if(node.left!=null){
                    queue.add(node.left);
                    tmp++;
                }
            }
            //判断方向
            if(flag){
                flag=false;
            }else{
                Collections.reverse(listInside);
                flag=true;
            }
            list.add(listInside);
            Qsize=tmp;
            tmp=0;
        }
        return list;
    }
}