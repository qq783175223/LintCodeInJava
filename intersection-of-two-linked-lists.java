/**
 * Definition for singly-linked list.
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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        while(headA==null||headB==null){
            return null;
        }
        if(headA==headB){
            return headA;
        }
        ListNode posA=headA;
        ListNode posB=headB;
        //1,将较短的链表走到最后一个节点
        while(posA.next!=null&&posB.next!=null){
            posA=posA.next;
            posB=posB.next;
        }
        //2,将较长的链表走到最后一个节点
        int difference=0;//记录长度链表之差
        boolean flag=false;//记录哪一个是长链表
        while(posA.next!=null){
            posA=posA.next;
            difference++;
            flag=true;//
        }
        while(posB.next!=null){
            posB=posB.next;
            difference++;
        }
        //3,先将长链表走difference步
        posA=headA;
        posB=headB;
        if(flag){
            while(difference>0){
                posA=posA.next;
                difference--;
            }
        }else{
            while(difference>0){
                posB=posB.next;
                difference--;
            }
        }
        //4,然后一起走
        while(posA!=posB){
            posA=posA.next;
            posB=posB.next;
        }
        return posA;
    }  
}