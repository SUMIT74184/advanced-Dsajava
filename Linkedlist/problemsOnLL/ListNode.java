package Linkedlist.problemsOnLL;

// import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }

            if (list1.val <= list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

        public ListNode mergeTwoList2(ListNode list1, ListNode list2) {
            ListNode dummNode = new ListNode();
            ListNode Node = dummNode;

            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    Node.next = list1;
                    list1 = list1.next;
                } else {
                    Node.next = list2;
                    list2 = list2.next;
                }
                Node = Node.next;

                if (list1 != null) {
                    Node.next = list1;
                } else {
                    Node.next = list2;
                }

            }
            return dummNode.next;
        }

    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        
    }

}
