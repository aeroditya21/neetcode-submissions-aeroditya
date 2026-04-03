class Solution {
    public boolean isAnagram(String s, String t) {
        Map fs = buildFreqTable(s);
        Map ft = buildFreqTable(t);
        return fs.equals(ft);
    }

    private Map<Character, Integer> buildFreqTable(String str) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!freq.containsKey(c)) {
                freq.put(c, 1);
            } else {
                int f = freq.get(Character.valueOf(c));
                freq.put(c, ++f);
            }
        }
        return freq;
    }
}
