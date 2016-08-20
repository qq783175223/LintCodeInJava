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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if(root==null){
            return null;
        }
        List<DoublyListNode> list=new ArrayList<DoublyListNode>();
        bulidList(root,list);//将中序遍历的结果保存在list
        for(int i=0;i<list.size()-1;i++){
            list.get(i).next=list.get(i+1);
            list.get(i+1).prev=list.get(i);
        }
        return list.get(0);
    }
    public void bulidList(TreeNode root, List<DoublyListNode> list) {
        if(root!=null){
            bulidList(root.left,list);
            DoublyListNode head=new DoublyListNode(root.val);
            list.add(head);
            bulidList(root.right,list);
        }
    }
}
