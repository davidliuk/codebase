package cn.neud.algorithm.search.bfs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RainWater {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m <= 2 || n <= 2) {
            return 0;
        }

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(o -> o[1])
        );

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            for (int i = 0; i < 4; i++) {
                int newX = curr[0] + dx[i];
                int newY = curr[1] + dy[i];
                if (!check(heightMap, newX, newY) || visited[newX][newY]) {
                    continue;
                }
                if (curr[2] > heightMap[newX][newY]) {
                    ans += curr[2] - heightMap[newX][newY];
                }
                pq.offer(new int[]{newX, newY, Math.max(heightMap[newX][newY], curr[2])});
                visited[newX][newY] = true;
            }
        }

        return ans;
    }

    boolean check(int[][] matrix, int x, int y) {
        if (x < 0 || x >= matrix.length) {
            return false;
        }
        if (y < 0 || y >= matrix[0].length) {
            return false;
        }
        return true;
    }

}