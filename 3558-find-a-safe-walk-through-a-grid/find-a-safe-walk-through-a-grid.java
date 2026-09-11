class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        Deque<int[]> dq = new ArrayDeque<>();

        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // Cost of starting cell
        res[0][0] = grid.get(0).get(0);

        dq.offerFirst(new int[]{0, 0});

        while (!dq.isEmpty()) {

            int[] curr = dq.pollFirst();

            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;

                int cost = grid.get(nr).get(nc);

                int newCost = res[r][c] + cost;

                if (newCost < res[nr][nc]) {

                    res[nr][nc] = newCost;
                    // other part than dijkastara
                    if (cost == 0) {
                        dq.offerFirst(new int[]{nr, nc});
                    } else {
                        dq.offerLast(new int[]{nr, nc});
                    }
                }
            }
        }

        int unsafeCells = res[m - 1][n - 1];

        return health - unsafeCells > 0;
    }
}