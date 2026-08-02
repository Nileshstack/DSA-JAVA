import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] height) {
        int n = height.length;
        int m = height[0].length;
        
        int[][] effort = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        // Min-heap ordered by effort
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // {effort, row, col}
        effort[0][0] = 0;

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!pq.isEmpty()) {
            int[] min = pq.poll();
            int dist = min[0], row = min[1], col = min[2];

            if (row == n - 1 && col == m - 1) {
                return dist;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check bounds
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    int newDist = Math.max(dist, Math.abs(height[newRow][newCol] - height[row][col]));
                    if (newDist < effort[newRow][newCol]) {
                        effort[newRow][newCol] = newDist;
                        pq.offer(new int[]{newDist, newRow, newCol});
                    }
                }
            }
        }
        return 0;
    }
}
