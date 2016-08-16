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
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if(T2==null){
             return true;//T2为{}的形式是任何树的子树
        }else if(T1==null){
            return false;//如果T1为{},那么T1只能包含子树{}
        }
        return isSubtree2(T1,T2,T2);

    }
    
    public boolean isSubtree2(TreeNode t1, TreeNode t2,TreeNode T2) {
        if(t2==null&&t1==null){
            return true;
        }else if((t1==null&&t2!=null)||(t2==null&&t1!=null)){
            return false;//当前节点有一个为null一个不为null,那么这两个节点肯定不等
        }

        //节点都不为null
        if(t1.val!=t2.val){
            //T2为t1左右子树的子树
            return (isSubtree2(t1.left,T2,T2)||isSubtree2(t1.right,T2,T2));
        }else{
            if(isSubtree2(t1.left,t2.left,T2)&&isSubtree2(t1.right,t2.right,T2)){
                return true;//T2完全等于t1
            }else if(isSubtree2(t1.left,T2,T2)||isSubtree2(t1.right,T2,T2)){
                return true;//T2为t1左右子树的子树
            }else{
                return false;//T2不完全等于t1,T2又不为t1左右子树的子树
            }
        }
    }
}