// Brute Force //

class Solution {
    public int evalRPN(String[] tokens) {

        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));

        while (tokenList.size() > 1) {
            for (int i = 0; i < tokenList.size(); i++) {
                String token = tokenList.get(i);

                if ("+-*/".contains(token)) {
                    int a = Integer.parseInt(tokenList.get(i - 2));
                    int b = Integer.parseInt(tokenList.get(i - 1));
                    int result = 0;

                    if (token.equals("+")) {
                        result = a + b;
                    } else if (token.equals("-")) {
                        result = a - b;
                    } else if (token.equals("*")) {
                        result = a * b;
                    } else if (token.equals("/")) {
                        result = a / b;
                    }

                    tokenList.set(i - 2, String.valueOf(result));
                    tokenList.remove(i);
                    tokenList.remove(i - 1);
                    break;
                }
            }
        }
        
        return Integer.parseInt(tokenList.get(0));
    }
}

// Recursion //

class Solution {
    public int evalRPN(String[] tokens) {

        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));
        return dfs(tokenList);
    }

    private int dfs (List<String> tokens) {
        String token = tokens.remove(tokens.size() - 1);

        if (!"+-*/".contains(token)) {
            return Integer.parseInt(token);
        }

        int right = dfs(tokens);
        int left = dfs(tokens);

        switch (token) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
        }

        return 0;
    }
}

// Stack //

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }

        return stack.pop();
    }
}