/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
//原博地址：http://www.cppblog.com/yuech/archive/2011/04/02/143318.html
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head==null){
            return null;
        }
        //1,将复制的节点插在每一个节点的后面
        RandomListNode pos=head;
        while(pos!=null){
            RandomListNode node=new RandomListNode(pos.label);
            node.next=pos.next;
            pos.next=node;
            pos=pos.next.next;
        }
        //2,调整复制节点的random
        pos=head;
        while(pos!=null){
            if(pos.random==null)
                pos.next.random=null;
            else
                pos.next.random=pos.random.next;
            pos=pos.next.next;
        }
        //3,恢复成两个链表
        RandomListNode slow=head;
        RandomListNode fast=head.next;
        RandomListNode result=fast;
        while(fast.next!=null){
            slow.next=slow.next.next;
            fast.next=fast.next.next;
            slow=slow.next;
            fast=fast.next;
        }
        if(fast.next==null){
            slow.next=null;
        }

        return result;
    }
}