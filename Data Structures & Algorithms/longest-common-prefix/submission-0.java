class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        int min = Integer.MAX_VALUE;
        // find min length from strs
        for (String s : strs) {
            if (s.length() < min) {
                min = s.length();
            }
        }
        // iterate 0 to min
        for (int i=0; i<min; i++) {
            for (int j=1; j<strs.length; j++) {
                if (strs[j].charAt(i) != strs[j-1].charAt(i)) {
                    return res.toString();
                }
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }
}