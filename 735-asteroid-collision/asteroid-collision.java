import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            // Process each asteroid
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int diff = a + stack.peek();
                if (diff < 0) {
                    // Current asteroid is stronger, remove the top of the stack
                    stack.pop();
                } else if (diff > 0) {
                    // Top of the stack is stronger, ignore current asteroid
                    a = 0;
                } else {
                    // Both asteroids destroy each other
                    stack.pop();
                    a = 0;
                }
            }
            if (a != 0) {
                // If the current asteroid survives, add it to the stack
                stack.push(a);
            }
        }

        // Convert the stack to an array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
