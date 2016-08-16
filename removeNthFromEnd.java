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
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if(head==null){
            return null;
        }
        int len=1;
        ListNode pos=head;
        //遍历得到链表长度
        while(pos.next!=null){
            len++;
            pos=pos.next;
        }
        if(len<n){
            return head;
        }
        ListNode cur1=head;
        ListNode cur2=head;
        for(int i=0;i<len-n;i++){
            cur2=cur1;//cur2指向要删除节点的前一个节点
            cur1=cur1.next;//cur1要删除的节点
        }
        if(len==n){//要删除第一个节点
            cur2=cur1.next;
            return cur2;//返回第二个节点
        }else{//删除非第一个节点
            cur2.next=cur1.next;
            return head;//返回原来的头节点
        }
            
        
    }
}
