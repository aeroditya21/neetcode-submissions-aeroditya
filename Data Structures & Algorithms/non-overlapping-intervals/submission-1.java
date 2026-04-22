class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        // for (int[] inter : intervals) {
        //     System.out.print(String.format("(%d,%d),", inter[0], inter[1]));
        // }
        
        int[] last = intervals[0];
        int remove = 0;
        
        for (int i=1; i<intervals.length; i++) {
            int[] curr = intervals[i];
            //System.out.print(String.format("(%d,%d) & (%d,%d)", curr[0], curr[1], last[0], last[1]));
            if (last[1] > curr[0]) {
                //System.out.println(String.format("Overlap!"));
                remove++;
                last = (last[1] > curr[1])?curr:last;
            } else {
                last = (last[1] > curr[1])?last:curr;
            }
            
        }

        return remove;
    }
}
