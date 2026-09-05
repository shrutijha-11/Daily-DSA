class Solution {
    public int longestSubseq(int[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
                int ans = 1;

                for (int x : arr) {
                    int best = 1;

                    if (map.containsKey(x - 1)) {
                        best = Math.max(best, map.get(x - 1) + 1);
                    }

                    if (map.containsKey(x + 1)) {
                        best = Math.max(best, map.get(x + 1) + 1);
                    }

                    map.put(x, Math.max(map.getOrDefault(x, 0), best));

                    ans = Math.max(ans, map.get(x));
                }

                return ans;
    }
}
