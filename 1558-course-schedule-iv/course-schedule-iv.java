import java.util.*;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // In-degree array
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
            inDegree[pre[1]]++;
        }

        // Reachability matrix
        boolean[][] reachable = new boolean[numCourses][numCourses];

        // Queue for Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Kahn's algorithm
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int nextCourse : adj.get(course)) {
                // If course can reach nextCourse, mark it
                reachable[course][nextCourse] = true;
                // Propagate all reachabilities from course to nextCourse
                for (int i = 0; i < numCourses; i++) {
                    if (reachable[i][course]) {
                        reachable[i][nextCourse] = true;
                    }
                }
                // Reduce in-degree and check for zero
                if (--inDegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        // Collect results for queries
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(reachable[query[0]][query[1]]);
        }

        return result;
    }
}
