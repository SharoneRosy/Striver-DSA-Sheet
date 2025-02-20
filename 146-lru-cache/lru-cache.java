import java.util.HashMap;
import java.util.Map;

public class LRUCache{

    private static final int DUMMY_KEY = -1;

    static class ListNode{
        int key,value;
        ListNode prev,next;

        public ListNode ( int key, int value) {
            this.key=key;
            this.value=value;
        }
    }

    private final int capacity;
    private final Map<Integer, ListNode>cache;
    private final ListNode head,tail;

    public LRUCache(int capacity){
        this.capacity=capacity;
        this.cache=new HashMap<>();

        this.head=new ListNode(DUMMY_KEY,DUMMY_KEY);
        this.tail=new ListNode(DUMMY_KEY,DUMMY_KEY);

        head.next=tail;
        tail.prev=head;
    }

    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        ListNode node=cache.get(key);
        moveToFront(node);
        return node.value;
    }

    public void put(int key,int value){
        if(cache.containsKey(key)){
            ListNode existingNode =cache.get(key);
            existingNode.value=value;
            moveToFront(existingNode);
        }else{
            ListNode newNode=new ListNode(key,value);
            cache.put(key,newNode);
            addToFront(newNode);

            if(cache.size()>capacity){
                ListNode lruNode=removeLRUNode();
                cache.remove(lruNode.key);
            }
        }
    }

    private void moveToFront(ListNode node){
        removeNode(node);
        addToFront(node);
    }

    private void addToFront(ListNode node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }

    private void removeNode(ListNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private ListNode removeLRUNode(){
        ListNode lruNode=tail.prev;
        removeNode(lruNode);
        return lruNode;
    }
}