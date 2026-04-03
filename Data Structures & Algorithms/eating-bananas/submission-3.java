class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = Arrays.stream(piles).max().getAsInt() + 1;
        //int right = Collections.max(list);
        int left = 1;
        
        int res = Integer.MAX_VALUE;
        while (left < right) {
            int center = (left+right)/2;
            int hours = 0;
            for (int pile : piles) {
                int div = pile/center;
                int rem = pile%center; 
                hours += div + (rem > 0 ? 1 : 0);
            }
            System.out.println("Center = " + center + "Hours = " + hours + "Res = " + res);
            if (hours <= h) {
                res = Math.min(center, res);
                right = center;
                System.out.println("Shifting left");
            } else {
                left = center + 1;
                System.out.println("Shifting right");
            }
        }
        return res;
    }
}
