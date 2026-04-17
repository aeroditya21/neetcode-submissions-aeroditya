class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            System.out.println(stack);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (c == ')' || c == '}' || c==']') {
                Character close = stack.peek();
                if (close != null && isOpposite(close, c))
                    stack.pop();
                else return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }

    private boolean isOpposite(char c1, char c2) {
        switch (c1) {
            case '(': return (c2==')');
            case '[': return (c2==']');
            case '{': return (c2=='}');
            default: return false;
        }
    }
}
