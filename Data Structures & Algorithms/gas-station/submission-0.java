class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int gasSum = Arrays.stream(gas).sum();
        int costSum = Arrays.stream(cost).sum();
        if (costSum > gasSum) return -1;

        int[] diff = new int[gas.length];
        for (int i=0; i<gas.length; i++) {
            diff[i] = gas[i] - cost[i];
        }

        int total=0, start=0;
        for (int i=0; i<diff.length; i++) {
            total += diff[i];
            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
