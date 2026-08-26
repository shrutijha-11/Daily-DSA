class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        // code here
        int[] dist = new int[V]; // all initialized to 0

        for (int i = 0; i < V - 1; i++) {
            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            if (dist[u] + w < dist[v]) {
                return true;
            }
        }

        return false;
    }
}