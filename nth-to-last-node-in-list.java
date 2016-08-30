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
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if(head==null||n==0){
            return null;
        }
        ListNode pFast=head;
        ListNode pSlow=head;
        for(int i=0;i<n-1;i++){
            if(pFast.next!=null){
                pFast=pFast.next;
            }else{
                return null;
            }
        }
        while(pFast.next!=null){
            pFast=pFast.next;
            pSlow=pSlow.next;
        }
        return pSlow;
    }
}
