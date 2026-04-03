class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int left = 0, right = 1;
        while(right < prices.length) {
            int profit = prices[right] - prices[left];
            if (profit > maxP) {
                maxP = profit;
            }
            if (profit < 0) {
                left = right;
            } 
            right++;
        }
        return maxP;
    }
}

// [10 1 5 6 7 1]
//  L  R, P=-9, MaxP=0
//     L R, P=4, MaxP=4
//.    L   R, P=5, MaxP=5
//.    L     R, P=6, MaxP=6
//     L       R, P=0, MaxP=6