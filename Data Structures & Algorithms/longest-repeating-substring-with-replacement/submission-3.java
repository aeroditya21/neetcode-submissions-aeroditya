class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int l=0, r=0;
        int maxFreq=0;
        int wLen = 0;

        while (r < s.length()) {
            char ch = s.charAt(r);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(ch));

            while (r-l+1-maxFreq > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l))-1);
                l++;
            }
            wLen = Math.max(wLen, r-l+1);
            r++;
        }
        return wLen;
    }
}