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
class Solution {
    public int index=0;
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root==null){
            return "# ";
        }else{
            return root.val+" "+serialize(root.left)+serialize(root.right);
        }
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    //没有对index复原
    public TreeNode deserialize(String data) {
        // write your code here
        String[] strArray=data.split(" ");
        if(strArray[index].equals("#")){
            return null;
        }else{
            TreeNode root=new TreeNode(Integer.parseInt(strArray[index]));
            index++;
            root.left=deserialize(data);
            index++;
            root.right=deserialize(data);
            return root;
        }
    }
}
