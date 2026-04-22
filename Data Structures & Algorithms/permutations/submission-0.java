class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedHashSet<Integer> soln = new LinkedHashSet<>();

        backtrack(nums, soln, res);
        return res;
    }

    void backtrack(int[] nums, LinkedHashSet<Integer> soln, List<List<Integer>> res) {
        //System.out.println("soln = " + soln);
        if (soln.size() == nums.length) {
            res.add(new ArrayList<>(soln));
            return;
        }
        for (int i : nums) {
            if (!soln.contains(i)) {
                soln.addLast(i);
                backtrack(nums, soln, res);
                soln.removeLast();
            }
        }
    }
}
