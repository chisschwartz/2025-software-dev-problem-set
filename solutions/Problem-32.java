// Brute Force //

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
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        int i = 0, j = nodes.size() - 1;

        while (i < j) {
            nodes.get(i).next = nodes.get(j);
            i++;

            if (i >= j) {
                break;
            }

            nodes.get(j).next = nodes.get(i);
            j--;
        }

        nodes.get(i).next = null;
    }
}

// Recursion //

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
class Solution {
    public void reorderList(ListNode head) {
        head = rec(head, head.next);
    }

    private ListNode rec(ListNode root, ListNode cur) {
        if (cur == null) {
            return root;
        }

        root = rec(root, cur.next);
        if (root == null) {
                return null;
        }

        ListNode tmp = null;

        if (root == cur || root.next == cur) {
            cur.next = null;
        } else {
            tmp = root.next;
            root.next = cur;
            cur.next = tmp;
        }

        return tmp;
    }
}

// Reverse and Merge //

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
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        //find the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //We use slow and fast pointers here to seperate the list into two halves

        ListNode second = slow.next;
        //declares the second half
        ListNode prev = slow.next = null;
        //splits the list into two

        //reverses the second half
        while (second != null) {
            ListNode tmp = second.next;
            //creates a temporary variable
            second.next = prev;
            //shifts our pointer to prev
            prev = second;
            second = tmp;
        }

        //merge the two halves
        ListNode first = head;
        //first half starts at the head
        second = prev;
        //second starts at what is stored in prev

        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            //stored in temp variables because we are breaking the links of the list
            first.next = second;
            second.next = tmp1;
            //inserts the second node between first and first.next
            first = tmp1;
            second = tmp2;
            //shifts our pointers
        }
    }
}