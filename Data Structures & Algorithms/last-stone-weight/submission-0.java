class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() >= 2) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            int result = Math.abs(stone1 - stone2);
            if (result != 0) {
                maxHeap.add(result);
            }
        }
        if (maxHeap.size() == 1) {
            return maxHeap.poll();
        } else {
            return 0;
        }        
    }
}
