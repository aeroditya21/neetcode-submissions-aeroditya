class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    private Integer min;
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (min == null || min >= val) {
            min = val;
            minStack.push(val);
            System.out.println("Min = " + min);
        }
    }
    
    public void pop() {
        if (stack.peek().intValue() == min) {
            System.out.println("Min is top = " + min);
            minStack.pop();
            min = minStack.peek();
            System.out.println("Now Min is prev = " + min);
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
