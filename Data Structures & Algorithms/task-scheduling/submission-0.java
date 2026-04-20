class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char ch : tasks) {
            count[ch - 'A']++;
        }
        Arrays.sort(count);
        int maxF = count[25];
        int idles = (maxF-1)*n;
        int i=24;
        while (idles > 0 && i >= 0) {
            idles -= Math.min(count[i], maxF-1);
            i--;
        }
        return tasks.length + Math.max(idles, 0);
    }
}
