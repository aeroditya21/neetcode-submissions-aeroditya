class LRUCache {
        
    Map<Integer, Integer> cache;
    LinkedHashSet<Integer> recencyList;
    int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>();    
        recencyList = new LinkedHashSet<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int value;
        if (cache.containsKey(key)) {
            value = cache.get(key);
            recencyList.remove(key);
            recencyList.addLast(key);
            return value;
        } else return -1;
        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            recencyList.remove(key);
        } else {
            if (cache.size() == capacity){
                //evict!
                int evict = recencyList.removeFirst();
                cache.remove(evict);
            }
        }
        recencyList.addLast(key);
        cache.put(key, value);
    }
}
