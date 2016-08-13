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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head==null){
            return null;
        }
        ListNode cur1=head,cur2=cur1.next,cur3=cur2;
        if(cur2==null){
            return head;//如果链表只有一个节点则直接返回该链表
        }
        cur1.next=null;//将链表头结点的next指向null
        while(true){
            cur3=cur2.next;//保存下一个节点信息
            cur2.next=cur1;//调整指针指向上一个节点
            if(cur3==null)
                return cur2;//下一个节点为null则之间cur2头结点
            cur1=cur2;//调整
            cur2=cur3;//调整
        }
    }
}
