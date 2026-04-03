class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            //minHeap.forEach(x -> System.out.print(" " + x));
            //System.out.println();
        }
        return minHeap.poll();
    }
}
