class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                String operator = token;
                Integer op2 = stack.pop();
                Integer op1 = stack.pop();
                Integer result = operate(op1, op2, operator);
                stack.push(result);
            } else {
                Integer operand = Integer.parseInt(token);
                stack.push(operand);
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String str) {
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        if (str.length() == 1 && operators.contains(str)) 
            return true;
        else return false;
    }

    private int operate(Integer a, Integer b, String operator) {
        switch (operator) {
            case "+" : return a+b;
            case "-" : return a-b;
            case "*" : return a*b;
            case "/" : {
                if (b != 0)
                    return a/b;
                else return 0;
            }
            default: return 0;
        }
    }
}
