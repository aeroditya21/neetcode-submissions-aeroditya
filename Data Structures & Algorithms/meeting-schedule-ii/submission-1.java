/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int maxCount = 0;
        int currentRooms = 0;

        // setup intermediate list
        List<IntervalTime> ints = new ArrayList<>();
        for (Interval it : intervals) {
            ints.add(new IntervalTime(it.start, false));
            ints.add(new IntervalTime(it.end, true));
        }
        Collections.sort(ints, (a, b) -> {
            if (a.time != b.time) return Integer.compare(a.time, b.time);
            // If times are equal, 'true' (end) comes before 'false' (start)
            return b.isEnd ? 1 : -1; 
        });
        //ints.forEach(i -> System.out.print(i.time + (i.isEnd?"e":"s") + ","));
        
        for (IntervalTime it : ints) {
            if (!it.isEnd) {
                currentRooms++;
                maxCount = Math.max(maxCount, currentRooms);
            } else {
                currentRooms--;
            }
        }
        return maxCount;
    }

     static class IntervalTime {
        boolean isEnd;
        int time;
        IntervalTime(int time, boolean isEnd) {
            this.time = time;
            this.isEnd = isEnd;
        }
     }
}

/**
0 ----------------------------------------------- 40
     5-----10
                   15 -----20
**/