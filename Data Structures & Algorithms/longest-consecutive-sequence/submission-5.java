class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            if (map.containsKey(num-1)) {
                map.put(num-1, num);
            }
            if (map.containsKey(num+1)) {
                map.put(num, num+1);
            }
            map.putIfAbsent(num, null);
        }
        System.out.println(map);
        
        int finalMax = 1;
        for (int num : nums) {
            int max = 1;
            while(map.get(num) != null) {
                num = map.get(num);
                max++;
            }
            System.out.println("Max with starting num " + num + " is " + max);
            if (max > finalMax) {
                finalMax = max;
            }
        }
        return finalMax;
    }
}
