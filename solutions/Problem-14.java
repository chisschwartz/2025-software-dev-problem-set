// Brute Force //

class MinStack {

    private Stack<Integer> stack;

    public MinStack() {

        stack = new Stack<>();
        
    }
    
    public void push(int val) {

        stack.push(val);
        
    }
    
    public void pop() {

        stack.pop();
        
    }
    
    public int top() {

        return stack.peek();
        
    }
    
    public int getMin() {

        Stack<Integer> tmp = new Stack<>();
        int mini = stack.peek();

        while (!stack.isEmpty()) {
            mini = Math.min(mini, stack.peek());
            tmp.push(stack.pop());
        }

        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }

        return mini;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
 // Two Stacks //

 class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {

        stack = new Stack<>();
        minStack = new Stack<>();
        
    }
    
    public void push(int val) {

        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        
    }
    
    public void pop() {

        if (stack.isEmpty()) return;
        
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
        
    }
    
    public int top() {

        return stack.peek();
        
    }
    
    public int getMin() {

        return minStack.peek();
        
    }
}

// One Stack //

class MinStack {

    long min;
    Stack<Long> stack;

    public MinStack() {

        stack = new Stack<>();
        
    }
    
    public void push(int val) {

        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            
            if (val < min) min = val;
        }
        
    }
    
    public void pop() {

        if (stack.isEmpty()) return;

        long pop = stack.pop();

        if (pop < 0) min = min - pop;
        
    }
    
    public int top() {

        long top = stack.peek();

        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) min;
        }
        
    }
    
    public int getMin() {

        return (int) min;
        
    }
}