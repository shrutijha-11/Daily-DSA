/* Structure of linked list node
class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    Node compute(Node head) {
        // code her
        
        if (head == null || head.next == null)
            return head;

        head = reverse(head);

        int maxSoFar = head.data;
        Node curr = head;

        while (curr != null && curr.next != null) {
            if (curr.next.data < maxSoFar) {
                curr.next = curr.next.next; // delete node
            } else {
                curr = curr.next;
                maxSoFar = curr.data;
            }
        }

        return reverse(head);
    }
}
