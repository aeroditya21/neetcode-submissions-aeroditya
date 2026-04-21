class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        for (int i=0; i<intervals.length; i++) {
            System.out.print("("+intervals[i][0]+","+intervals[i][1]+"),");
        }

        Queue<int[]> maxH = new PriorityQueue<>(Comparator.comparingInt(x -> (-1)*x[0]));
        for (int i=0; i<intervals.length; i++) {
            if (maxH.isEmpty()) {
                maxH.add(intervals[i]);
                System.out.println("Add to heap " + maxH.size());
            } else {
                if(intervals[i][0] <= maxH.peek()[1]) {
                    int[] top = maxH.poll();
                    int s = Math.min(intervals[i][0], top[0]);
                    int e = Math.max(intervals[i][1], top[1]);
                    int[] newInt = new int[] {s,e};
                    maxH.add(newInt);
                    //System.out.println("Polled, merged and added to heap " + maxH.size());
                } else {
                    maxH.add(intervals[i]);
                    //System.out.println("Add to heap " + maxH.size());
                }
            }
        }
        int count = maxH.size();
        for(int i=0; i<count; i++) {
            int[] inter = maxH.poll();
            //System.out.println(inter[0] + "," + inter[1]);
            res.add(inter);
        }
        Collections.reverse(res);
        return res.stream().toArray(int[][]::new);

    }
}
/**
1----3
1--------5
            6--7
            6----8
**/
