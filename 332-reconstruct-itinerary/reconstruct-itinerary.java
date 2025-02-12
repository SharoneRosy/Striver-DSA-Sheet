import java.util.*;

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        // Step 1: Build adjacency list with Min-Heap for lexicographical order
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }

        // Step 2: Perform Hierholzer’s Algorithm (Iterative DFS)
        LinkedList<String> result = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String node = stack.peek();
            if (graph.containsKey(node) && !graph.get(node).isEmpty()) {
                stack.push(graph.get(node).poll()); // Move to next lexicographically smallest destination
            } else {
                result.addFirst(stack.pop()); // Backtrack and build the final itinerary
            }
        }

        return result;
    }
}
