class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> soln = new ArrayDeque<>();

        backtrack(0, nums, soln, res);
        return res;
    }

    void backtrack(int i, int[] nums, Deque<Integer> soln, List<List<Integer>> res) {
        //System.out.println("i = " + i + ", soln = " + soln);
        if (i == nums.length) {
            res.add(new ArrayList<>(soln));
            return;
        }

        backtrack(i+1, nums, soln, res);
        soln.push(nums[i]);
        backtrack(i+1, nums, soln, res);
        soln.pop();
    }
}
