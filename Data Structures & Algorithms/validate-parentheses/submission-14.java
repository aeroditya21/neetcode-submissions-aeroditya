class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            Character stackTop = stack.peek();
            
            if ((stackTop != null) && (mirrorOf(c).equals(stackTop)) && isClosing(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean isClosing(Character c) {
        return c == '}' || c == ']' || c == ')';
    }

    private Character mirrorOf(Character c) {
        switch (c.charValue()) {
            case '{': return '}';
            case '}': return '{';
            case '[': return ']';
            case ']': return '[';
            case '(': return ')';
            case ')': return '(';
            default: return null;
        }
    }
}