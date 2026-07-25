import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        int[][] directions = {
                {-1,-1}, {-1,0}, {-1,1},
                {0,-1},          {0,1},
                {1,-1}, {1,0},   {1,1}
        };

        // distance array
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 1;

        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[]{1, 0, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int distance = current[0];
            int row = current[1];
            int col = current[2];

            if (row == n - 1 && col == n - 1)
                return distance;

            // Ignore outdated entries
            if (distance > dist[row][col])
                continue;

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < n &&
                    grid[newRow][newCol] == 0) {

                    int newDistance = distance + 1;

                    if (newDistance < dist[newRow][newCol]) {

                        dist[newRow][newCol] = newDistance;

                        pq.offer(new int[]{
                                newDistance,
                                newRow,
                                newCol
                        });
                    }
                }
            }
        }

        return -1;
    }
}