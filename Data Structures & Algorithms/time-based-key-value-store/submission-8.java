class TimeMap {

    Map<String, TreeMap<Integer, String>> timeMap;
    
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> innerMap = timeMap.getOrDefault(key, new TreeMap<>());
        innerMap.put(timestamp, value);
        timeMap.put(key, innerMap);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> innerMap = timeMap.get(key);
        if (innerMap == null || innerMap.isEmpty()) {
            return "";
        } else {
            System.out.println(innerMap.firstEntry());
            Map.Entry<Integer, String> e = innerMap.floorEntry(Integer.valueOf(timestamp));
            return (e == null ? "" : e.getValue());
        }
    }
}
