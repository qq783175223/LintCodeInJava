/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    //这里实现两层循环,时间复杂度为O(N^2)的算法,
    //利用Hash表的算法时间复杂度是O(N),但空间复杂度是O(N)
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        // write your code here
        ListNode cur=head;
        ListNode pos;
        while(cur!=null){
            pos=cur;
            while(pos.next!=null){
            	if(cur.val==pos.next.val){
            		pos.next=pos.next.next;
            	}else{
            		pos=pos.next;
            	}
            }
            cur=cur.next;
        }
        return head;
    }  
}