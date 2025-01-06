class MyQueue {
    Stack<Integer> stack;
    
    /**
     * Initialize single stack in constructor
     */
    public MyQueue() {
        this.stack = new Stack<>();
    }
    
    /**
     * Push element directly to stack
     * Time complexity: O(1)
     */
    public void push(int x) {
        stack.push(x);
    }
    
    /**
     * Remove and return the first element (bottom of stack)
     * Uses recursive approach to reach bottom element
     * Time complexity: O(n) where n is number of elements
     */
    public int pop() {
        // If only one element, simply pop it
        if (stack.size() == 1) {
            return stack.pop();
        }
        
        // Remove top element and store it
        int top = stack.pop();
        
        // Recursively reach the bottom element
        int first = pop();
        
        // Push back the removed element
        stack.push(top);
        
        return first;
    }
    
    /**
     * View the first element (bottom of stack) without removing it
     * Uses recursive approach similar to pop()
     * Time complexity: O(n) where n is number of elements
     */
    public int peek() {
        // If only one element, just peek it
        if (stack.size() == 1) {
            return stack.peek();
        }
        
        // Remove top element and store it
        int top = stack.pop();
        
        // Recursively reach the bottom element
        int first = peek();
        
        // Push back the removed element
        stack.push(top);
        
        return first;
    }
    
    /**
     * Check if queue is empty
     * Time complexity: O(1)
     */
    public boolean empty() {
        return stack.isEmpty();
    }
}