package Linkedlist.problemsOnLL;

import java.util.*;

public class ReorderList {
    public void reo(ListNode head){

        if(head == null){
            return;
        }

        List<ListNode> nodes =  new ArrayList<>();
        ListNode cur = head;
        while(cur!= null){
            nodes.add(cur);
            cur = cur.next;

        }
        int i = 0, j =  nodes.size()-1;
        while(i<j){
            nodes.get(i).next = nodes.get(j);
            i++;

            if(i>=j){
                break;
            }

            nodes.get(j).next = nodes.get(i);
            j--;
        }
        nodes.get(i).next = null;

    } //This was the iterative approach


    // This is reversing and merging of the list

    public void reo1(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        ListNode prev = slow.next=null;
        while(second!=null){
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        ListNode first = head;
        second = prev;
        while (second!=null) {
        ListNode temp1 = first.next;
        ListNode temp2 = second.next;
        
        first.next = second;
        second.next = temp1;

        // move forward
        first = temp1;
        second = temp2;
        
        }
    


    }




    public static void main(String[] args) {

    }
    
}
