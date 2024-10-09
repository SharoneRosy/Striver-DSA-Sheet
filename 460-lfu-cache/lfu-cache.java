class LFUCache {
    class Node {
        int key, val, freq;
        Node next, prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        int listSize;
        Node head, tail;
        public DoublyLinkedList() {
            this.listSize = 0;
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public void insert(Node currNode) {
            Node headNext = head.next;
            head.next = currNode;
            currNode.prev = head;
            currNode.next = headNext;
            headNext.prev = currNode;
            listSize++;
        }

        public void remove(Node currNode) {
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            listSize--;
        }
    }

    final int capacity;
    int currSize, minFreq;
    Map<Integer, Node> cache;
    Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public void updateNode(Node currNode) {
        int currFreq = currNode.freq;
        DoublyLinkedList currList = freqMap.get(currFreq);
        currList.remove(currNode);
        if (currFreq == minFreq && currList.listSize == 0) minFreq++;
        currNode.freq++;
        DoublyLinkedList newList = freqMap.getOrDefault(currNode.freq, new DoublyLinkedList());
        newList.insert(currNode);
        freqMap.put(currNode.freq, newList);
    }

    public int get(int key) {
        Node currNode = cache.get(key);
        if (currNode == null) return -1;
        updateNode(currNode);
        return currNode.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cache.containsKey(key)) {
            Node currNode = cache.get(key);
            currNode.val = value;
            updateNode(currNode);
        } else {
            currSize++;
            if (currSize > capacity) {
                DoublyLinkedList minFreqList = freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.remove(minFreqList.tail.prev);
                currSize--;
            }
            minFreq = 1;
            Node newNode = new Node(key, value);
            DoublyLinkedList currList = freqMap.getOrDefault(1, new DoublyLinkedList());
            currList.insert(newNode);
            freqMap.put(1, currList);
            cache.put(key, newNode);
        }
    }
}
