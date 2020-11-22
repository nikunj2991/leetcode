/**
 * 2. AddTwoNumbers
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        
        public ListNode() {}
    
        public ListNode(int val) {
            this.val = val;
        }
    
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode AddTwoNumbers(ListNode n1, ListNode n2) {
        ListNode result = new ListNode(0);
        int carry = 0;

        ListNode current = result;

        while (n1 != null || n2 != null) {
            int first = n1 != null ? n1.val : 0;
            int second = n2 != null ? n2.val : 0;

            int sum = first + second + carry;

            carry = (sum)/10;

            current.next = new ListNode((sum)%10);
            current = current.next;

            if (n1 != null) {
                n1 = n1.next;
            }

            if (n2 != null) {
                n2 = n2.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return result.next;
    }
}


