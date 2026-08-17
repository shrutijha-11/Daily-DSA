class Solution {
    public int minEdgesReq(int n, int[][] edges) {
        if (edges.length < n - 1) return -1;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int components = n;

        for (int[] e : edges) {
            int u = find(parent, e[0]);
            int v = find(parent, e[1]);

            if (u != v) {
                parent[u] = v;
                components--;
            }
        }

        return components - 1;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}