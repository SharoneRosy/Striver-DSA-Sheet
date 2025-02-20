class MyHashMap {

    // Static nested class for Node
    private static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int INITIAL_SIZE = 10000;
    private Node[] map;

    public MyHashMap() {
        map = new Node[INITIAL_SIZE];
    }

    private int hash(int key) {
        return key % INITIAL_SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        // If no entry at index, create new node
        if (map[index] == null) {
            map[index] = new Node(key, value);
            return;
        }

        // Traverse the linked list at this index
        Node prev = null;
        Node curr = map[index];
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        // Add new node at the end of the chain
        prev.next = new Node(key, value);
    }

    public int get(int key) {
        Node node = findNode(key);
        return (node == null) ? -1 : node.value;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = map[index], prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    map[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    private Node findNode(int key) {
        int index = hash(key);
        Node curr = map[index];
        while (curr != null) {
            if (curr.key == key) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
}
