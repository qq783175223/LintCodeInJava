 /**
  * 假设单链表的总长度为L，头结点到环入口的距离为a，
  * 环入口到快慢指针相遇的结点距离为x，环的长度为r，
  * 慢指针总共走了s步，则快指针走了2s步。
  * 另外，快指针要追上慢指针的话快指针至少要在环里
  * 面转了一圈多(假设转了n圈加x的距离)，
  * 得到以下关系：
  *  s = a + x;
  *  2s = a + nr + x;
  *  =>a + x = nr;
  *  =>a = nr - x;
  * 由上式可知：若在头结点和相遇结点分别设一指针，
  * 同步(单步)前进，则最后一定相遇在环入口结点！
  * /
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
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // write your code here
        if(head==null)
            return null;
        ListNode slow=head;
        ListNode fast=head;
        while(true){
            slow=slow.next;
            if(fast==null||fast.next==null)
                return null;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        fast=head;
        while(true){
            slow=slow.next;
            fast=fast.next;
            if(slow==fast){
                return slow;
            }
        }
    }
}
