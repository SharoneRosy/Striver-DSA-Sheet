class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create new nodes and weave them into the original list
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // Skip to the next original node
        }

        // Step 3: Separate the original and copied lists
        Node dummy = new Node(0);
        Node copyCurr = dummy, copyHead = dummy;
        curr = head;
        while (curr != null) {
            copyCurr.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return dummy.next;
    }
}
