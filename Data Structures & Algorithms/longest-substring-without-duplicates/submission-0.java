class Solution {
    public int lengthOfLongestSubstring(String s) {
        LinkedHashSet<Character> window = new LinkedHashSet<>();
        int max = 0;

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (!window.contains(ch)) {
                window.add(ch);
                max = (window.size()>max) ? (window.size()) : (max);
            } else {
                // remove start to repeat
                do {
                    window.removeFirst();
                } while(window.contains(ch));
                window.add(ch);
            }
        }

        return max;
    }
}
