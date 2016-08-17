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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1==null&&l2==null){
            return null;
        }else if(l1==null&&l2!=null){
            return l2;
        }else if(l1!=null&&l2==null){
            return l1;
        }
        //slow指针最开始指向头结点较小的那个链表,而后每次往后移
        //fast指针比slow快一步,而后每次往后移
        //head指针最开始指向头结点较大的那个链表,而后每次往后移
        ListNode slow=null,fast=null,head=null,tmp=null;
        if(l1.val<l2.val){
            slow=l1;
            fast=l1.next;
            head=l2;
        }else{
            slow=l2;
            fast=l2.next;
            head=l1;
        }
        ListNode headSlow=slow;//headSlow用于保存头结点较小的那个链表的头结点
        while(head!=null&&fast!=null){
            if(fast.val>=head.val){
                tmp=head;
                head=head.next;//千万注意!!!!!!不能将这一步写错了顺序,会死循环
                slow.next=tmp;
                tmp.next=fast;
                slow=slow.next;
            }else{
                slow=fast;
                fast=fast.next;
            }
        }
        if(fast==null)
            slow.next=head;
        return headSlow;
    }
}