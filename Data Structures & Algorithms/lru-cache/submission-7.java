class LRUCache {

    Map<Integer, Node> map;
    Node head, tail;
    int capacity;
    int len;


    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int ret;
        if (map.containsKey(key)) {
            Node n = map.get(key);
            // Move to end of DLL
            delete(n);
            addToTail(n);  
            ret = n.val;
        } else {
            ret = -1;
        }
        //printMap();
        //printDLL();
        return ret;
    }
    
    public void put(int key, int value) {
        // if key exists, update and return
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.val = value;
            // Move to end of DLL
            delete(n);
            addToTail(n); 
            //printMap();
            return;
        }

        // if at capacity then evict first of DLL
        if (len == capacity) {
            evict();
            len--;
        }
        
        // Add node to tail of DLL
        Node n = new Node(key, value, null, null);
        addToTail(n);

        // Add node ref to map
        map.put(key, n);
        len++;
        //printMap();
        //printDLL();
    }

    private void evict() {
        Node n = head;
        map.remove(n.key);
        delete(n);
    }

    private void delete(Node n) {
        Node prev = n.prev;
        Node next = n.next;
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
        }
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }
        n.next = null;
        n.prev = null;
    }

    private void addToTail(Node node) {
        Node end = tail;
        tail = node;
        node.prev = end;
        node.next = null;
        if (end == null) {
            head = node;
        } else {
            end.next = node;
        }
    }

    private void printMap() {
        System.out.print("\nMap = ");
        for (Map.Entry<Integer, Node> e : map.entrySet()) {
            System.out.print(e.getKey() + "->(" + e.getValue().val + "), ");
        }
    }

    private void printDLL() {
        Node n = head;
        System.out.print("\nDLL = ");
        while (n != null) {
            System.out.print(n.key + "," + n.val + "->");
            n = n.next;
        }
    }

    static class Node {
        Node prev, next;
        int val, key;

        Node (int key, int val, Node prev, Node next) {
            this.prev = prev;
            this.next = next;
            this.val = val;
            this.key = key;
        }
    }

}


