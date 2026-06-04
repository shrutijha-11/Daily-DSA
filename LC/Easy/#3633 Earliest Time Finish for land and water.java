class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;

        // Land -> Water
        for (int i = 0; i < landStartTime.length; i++) {
            int landFinish = landStartTime[i] + landDuration[i];

            for (int j = 0; j < waterStartTime.length; j++) {
                int finish = Math.max(landFinish, waterStartTime[j])
                           + waterDuration[j];
                ans = Math.min(ans, finish);
            }
        }

        // Water -> Land
        for (int i = 0; i < waterStartTime.length; i++) {
            int waterFinish = waterStartTime[i] + waterDuration[i];

            for (int j = 0; j < landStartTime.length; j++) {
                int finish = Math.max(waterFinish, landStartTime[j])
                           + landDuration[j];
                ans = Math.min(ans, finish);
            }
        }

        return ans;
    }
}
