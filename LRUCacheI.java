import java.util.HashMap;

public class LRUCacheI {
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int cap;

    public LRUCacheI(int capacity) {
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node res = map.get(key);
            remove(res);
            insert(res);
            return res.val;
        } else {
            return -1;
        }
    }

    void put(int key, int val) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == cap) {
            remove(tail.prev);
        }
        insert(new Node(key, val));
    }

    public void remove(Node res) {
        map.remove(res.key, res);

        res.prev.next = res.next;
        res.next.prev = res.prev;
    }

    public void insert(Node node) {
        map.put(node.val, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

class Node {
    Node prev, next;
    int key, val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
