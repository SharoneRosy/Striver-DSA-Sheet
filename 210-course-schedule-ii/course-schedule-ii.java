import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Initialize adjacency list and indegree array
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Step 2: Build the graph
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            adjList.get(prerequisite).add(course);
            indegree[course]++;
        }

        // Step 3: Add courses with no prerequisites (indegree = 0) to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 4: Perform topological sort using BFS
        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            order[index++] = currentCourse;

            for (int dependentCourse : adjList.get(currentCourse)) {
                indegree[dependentCourse]--;
                if (indegree[dependentCourse] == 0) {
                    queue.add(dependentCourse);
                }
            }
        }

        // Step 5: Check if all courses were processed
        return index == numCourses ? order : new int[0];
    }
}
