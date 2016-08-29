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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        return myBuildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    
    private static int findPosition(int[] arr, int start, int end, int key) {
        for(int i=start;i<=end;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }

    private TreeNode myBuildTree(int[] inorder, int instart, int inend, int[] posorder, int posstart, int posend) {
        if(instart>inend){//等价于posstart>posend
            return null;
        }
        TreeNode root=new TreeNode(posorder[posend]);
        int indexRoot=findPosition(inorder,instart,inend,posorder[posend]);
        root.left=myBuildTree(inorder,instart,indexRoot-1,posorder,posstart,
            posstart + indexRoot - instart - 1);// posstart + indexRoot - instart - 1)我也不懂
        root.right=myBuildTree(inorder,indexRoot+1,inend,posorder,
            posstart + indexRoot - instart,posend-1);// posstart + indexRoot - instart我也不懂
        return root;
    }
}