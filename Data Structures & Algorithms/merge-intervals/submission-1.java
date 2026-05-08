class Solution {
    public int[][] merge(int[][] intervals) {
        // sort intervals by start time
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        for (int i=0; i<intervals.length; i++) {
            System.out.print("("+intervals[i][0]+","+intervals[i][1]+"),");
        }

        // setup
        res.add(intervals[0]);
        // loop over all rem intervals
        for (int i=1; i<intervals.length; i++) {
            // is intervals[i] overlapping with last res element, merge them
            if (res.get(res.size()-1)[1] >= intervals[i][0]) {
                int[] popped = res.get(res.size()-1);
                res.remove(res.size()-1);
                int s = Math.min(popped[0], intervals[i][0]);
                int e = Math.max(popped[1], intervals[i][1]);
                res.add(new int[] {s,e});
            } else {
                res.add(intervals[i]);
            }
        }
        return res.stream().toArray(int[][]::new);
    }
}

/**
    0----------------5
        1--------------6
                         7-----9
                               9----11
**/
