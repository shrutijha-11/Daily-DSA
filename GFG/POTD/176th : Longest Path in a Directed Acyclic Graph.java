class Solution {
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        // code here
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (ArrayList<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int w = e.get(2);
            adj.get(u).add(new int[]{v, w});
        }

        // Step 1: Topological sort (whole graph)
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topoSort(i, adj, vis, st);
            }
        }

        // Step 2: Initialize distances
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0;

        // Step 3: Relax edges in topological order
        while (!st.isEmpty()) {
            int u = st.pop();
            
            if (dist[u] != Integer.MIN_VALUE) {
                for (int[] edge : adj.get(u)) {
                    int v = edge[0];
                    int w = edge[1];
                    if (dist[u] + w > dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        return dist;
    }
    
    private void topoSort(int u, List<List<int[]>> adj, boolean[] vis, Stack<Integer> st) {
        vis[u] = true;
        for (int[] edge : adj.get(u)) {
            int v = edge[0];
            if (!vis[v]) {
                topoSort(v, adj, vis, st);
            }
        }
        st.push(u);
    }
}
