class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;

        // Starting cell is an obstacle
        if (mat[r][c] == '#') {
            return 0;
        }

        // dist[i][j] = minimum number of upward moves
        // required to reach (i, j)
        int[][] dist = new int[n][m];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Deque for 0-1 BFS
        Deque<int[]> deque = new ArrayDeque<>();

        dist[r][c] = 0;
        deque.offerFirst(new int[]{r, c});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!deque.isEmpty()) {

            int[] cur = deque.pollFirst();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {

                int nx = x + dr[k];
                int ny = y + dc[k];

                // Outside the maze
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                // Obstacle
                if (mat[nx][ny] == '#') {
                    continue;
                }

                // Moving upward costs 1.
                // Every other movement costs 0.
                int cost = (nx < x) ? 1 : 0;

                int newDist = dist[x][y] + cost;

                if (newDist < dist[nx][ny]) {

                    dist[nx][ny] = newDist;

                    if (cost == 0) {
                        deque.offerFirst(new int[]{nx, ny});
                    } else {
                        deque.offerLast(new int[]{nx, ny});
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == '#') {
                    continue;
                }

                if (dist[i][j] == Integer.MAX_VALUE) {
                    continue;
                }

                int upMoves = dist[i][j];

                // From:
                // down - up = i - r
                //
                // therefore:
                // down = up + i - r
                int downMoves = upMoves + (i - r);

                if (upMoves <= u && downMoves <= d) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
