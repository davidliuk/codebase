package cn.dlpenn.algorithm.search.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }

        int numChoose = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        int[] topoOrder = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                topoOrder[numChoose++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                    topoOrder[numChoose++] = neighbor;
                }
            }
        }

        return numChoose == numCourses;
    }

    public int[] findOrder(
            int numCourses,
            int[][] prerequisites
    ) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: prerequisites) {
            graph[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }

        int numChoose = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        int[] topoOrder = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                topoOrder[numChoose++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor: graph[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                    topoOrder[numChoose++] = neighbor;
                }
            }
        }

        return numChoose == numCourses? topoOrder: new int[0];
    }

}
