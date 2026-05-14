class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        backtrack(res, sb, n, 0, 0);
        return new ArrayList(res);
    }

    private void backtrack(Set<String> res, StringBuilder sb, int n, int open, int closed) {
        if (closed > open || open > n) return;
        if (open == n && closed == n) {
            res.add(sb.toString());
            return;
        }
        
        sb.append('(');
        backtrack(res, sb, n, open + 1, closed);
        sb.deleteCharAt(sb.length() - 1);

        if (closed < open) {
            sb.append(')');
            backtrack(res, sb, n, open, closed + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
