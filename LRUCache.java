import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Node> map;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node res = map.get(key);
            remove(res);
            insert(res);
            return res.value;
        } else {
            return -1;
        }
    }

    void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == cap) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    public void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class Node {
        Node prev, next;
        int key, value;

        Node(int k, int val) {
            key = k;
            value = val;
        }
    }

}
