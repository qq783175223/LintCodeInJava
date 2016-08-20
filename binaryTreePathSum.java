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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        List<Integer> listInSide=new ArrayList<Integer>();
        binaryTreePathSum2(root,target,listInSide,list);
        return list;
 
    }
    public void binaryTreePathSum2(TreeNode root, int target,List<Integer> listInSide,List<List<Integer>> list) {
        if(root==null){
            return;
        }
        //注意有效路径的定义是指从根节点到叶节点
        if(root.val==target&&root.left==null&&root.right==null){
            listInSide.add(root.val);
            list.add(listInSide);
        }else{//特别注意存在负数的情况
            listInSide.add(root.val);
            List<Integer> listInSide2=new ArrayList<Integer>();
            listInSide2.addAll(listInSide);
            binaryTreePathSum2(root.left, target-root.val,listInSide,list);
            binaryTreePathSum2(root.right, target-root.val,listInSide2,list);
        }
    }
}