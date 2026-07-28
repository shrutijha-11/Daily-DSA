class Solution {
    public int shortestPath(int V, int src, int dest, int[][] edges) {
        // code here
        int extra = 0;
        for (int[] e : edges) if (e[2] == 2) extra++;
        
        int newV = V + extra;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < newV; i++) adj.add(new ArrayList<>());
        
        int dummyId = V;
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            if (w == 1) {
                adj.get(u).add(v);
                adj.get(v).add(u);
            } else {
                int d = dummyId++;
                adj.get(u).add(d);
                adj.get(d).add(u);
                adj.get(d).add(v);
                adj.get(v).add(d);
            }
        }
        
        int[] dist = new int[newV];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        dist[src] = 0;
        q.add(src);
        
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nxt : adj.get(node)) {
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[node] + 1;
                    q.add(nxt);
                }
            }
        }
        
        return dist[dest];
    }
}