class Solution {
    public int maxTask(int[] h, int[] l) {
        // code here
        int n = h.length;

        int free = 0;  // Previous day: no task
        int work = 0;  // Previous day: task performed

        for (int i = 0; i < n; i++) {
            int prevFree = free;
            int prevWork = work;

            // Do no task today
            free = Math.max(prevFree, prevWork);

            // Do a low-effort task today
            int low = Math.max(prevFree, prevWork) + l[i];

            // Do a high-effort task today
            // Only possible if yesterday was free
            int high = prevFree + h[i];

            work = Math.max(low, high);
        }

        return Math.max(free, work);
    }
}
