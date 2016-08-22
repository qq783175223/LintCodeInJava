/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        // write your code here
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(true){
            slow=slow.next;
            fast=fast.next;
            if(fast==null){
                return false;
            }
            if(slow==fast){
                return true;
            }
            fast=fast.next;
            if(fast==null){
                return false;
            }
            if(slow==fast){
                return true;
            }
        }
    }
}
