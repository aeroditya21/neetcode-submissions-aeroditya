class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j=numbers.length-1;
        int[] res = new int[2];

        while (i < j) {
            int candidate = numbers[i] + numbers[j];
            if (candidate == target) {
                res[0] = i+1;
                res[1] = j+1;
                return res;
            }
            if (candidate < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
