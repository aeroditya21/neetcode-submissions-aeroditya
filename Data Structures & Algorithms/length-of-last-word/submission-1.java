class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        int length = words.length;
        String lastWord = words[length - 1];
        
        while (lastWord.isBlank() && length >= 0) {
            length--;
        }
        return lastWord.length();
    }
}