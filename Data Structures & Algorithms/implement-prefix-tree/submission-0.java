class PrefixTree {

    TreeNode head = new TreeNode(' ', new HashMap<Character, TreeNode>(), false);

    static class TreeNode {
        char ch;
        Map<Character, TreeNode> map;
        boolean isEnd;

        TreeNode(char ch, Map<Character, TreeNode> map, boolean isEnd) {
            this.ch = ch;
            this.map = map;
            this.isEnd = isEnd;
        }
    }

    public PrefixTree() {
         
    }

    public void insert(String word) {
        TreeNode itr = head;
        int i=0;
        while (i<word.length() && itr.map.containsKey(word.charAt(i))) {
            itr = itr.map.get(word.charAt(i));
            if (i == word.length()-1) {
                itr.isEnd = true;
            }
            i++;
        }
        while (i < word.length()) {
            itr.map.put(word.charAt(i), new TreeNode(word.charAt(i), new HashMap<Character, TreeNode>(), (i==word.length()-1)));
            itr = itr.map.get(word.charAt(i));
            i++;
        }
    }

    public boolean search(String word) {
        TreeNode itr = head;
        for (int i=0; i<word.length(); i++) {
            if (itr.map != null && itr.map.containsKey(word.charAt(i))) {
                itr = itr.map.get(word.charAt(i));
            } else {
                return false;
            }
        }
        return itr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode itr = head;
        for (int i=0; i<prefix.length(); i++) {
            if (itr.map != null && itr.map.containsKey(prefix.charAt(i))) {
                itr = itr.map.get(prefix.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }
}
