class LRUCache {

    static record Node(Integer key){}
        
    Map<Integer, Map.Entry<Integer, Node>> cache;
    List<Node> recencyList;
    int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>();    
        recencyList = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int value;
        if (cache.containsKey(key)) {
            value = cache.get(key).getKey();
            Node node = cache.get(key).getValue();
            recencyList.remove(node);
            recencyList.addLast(node);
            return value;
        } else return -1;
        
    }
    
    public void put(int key, int value) {
        Node node;
        if(cache.containsKey(key)) {
            node = cache.get(key).getValue();
            recencyList.remove(node);
            recencyList.addLast(node);
        } else {
            if (cache.size() == capacity){
                //evict!
                Node evict = recencyList.removeFirst();
                cache.remove(evict.key());
            }
            node = new Node(key);
            recencyList.addLast(node);
        }
        
        cache.put(key, new AbstractMap.SimpleEntry(value, node));
    }
}
