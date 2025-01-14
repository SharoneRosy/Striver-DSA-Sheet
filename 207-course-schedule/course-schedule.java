import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        // Step 3: Add courses with no prerequisites (indegree 0) to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 4: Process courses using BFS
        int processedCourses = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            processedCourses++;

            // Reduce indegree of dependent courses
            for (int dependentCourse : adjList.get(currentCourse)) {
                indegree[dependentCourse]--;
                if (indegree[dependentCourse] == 0) {
                    queue.add(dependentCourse);
                }
            }
        }

        // Step 5: Check if all courses are processed
        return processedCourses == numCourses;
    }
}
