package Linkedlist.problemsOnLL;

import java.util.HashSet;

public class CycleDetection {

    public boolean hasCycle(ListNode head){
        HashSet<ListNode> seen = new HashSet<>();
        ListNode cur = head; //creating the pointer on the head of the linkedlist

        while(cur!=null){
            if(seen.contains(cur)){
                return true;
            }
            seen.add(cur); //also we are going to add the unknow to the ll
            cur=cur.next; //move ahead
        }
        return false;


    }

    //  Fast and slow pointers
    public boolean hasCycle1(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while(fast!= null && fast.next!=null ){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) return true;
        }
        return false;
    }


    
}
