class Solution {
    public long totalWaviness(long num1, long num2) {
        return calc(num2) - calc(num1 - 1);
    }

    private String s;
    private long[][][][][] cntMemo;
    private long[][][][][] sumMemo;
    private boolean[][][][][] vis;

    private long calc(long x) {
        if (x <= 0) return 0;

        s = String.valueOf(x);
        int n = s.length();

        cntMemo = new long[n + 1][11][4][2][2];
        sumMemo = new long[n + 1][11][4][2][2];
        vis = new boolean[n + 1][11][4][2][2];

        return dfs(0, 10, 0, 1, 0)[1];
    }

    private long[] dfs(int pos, int lastDigit, int lastCmp,
                       int tight, int started) {

        if (pos == s.length()) {
            return new long[]{1, 0};
        }

        if (vis[pos][lastDigit][lastCmp + 1][tight][started]) {
            return new long[]{
                cntMemo[pos][lastDigit][lastCmp + 1][tight][started],
                sumMemo[pos][lastDigit][lastCmp + 1][tight][started]
            };
        }

        long count = 0;
        long wavinessSum = 0;

        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;

        for (int d = 0; d <= limit; d++) {

            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {
                long[] nxt = dfs(pos + 1, 10, 0, ntight, 0);

                count += nxt[0];
                wavinessSum += nxt[1];
            } else {

                int cmp = 0;
                int add = 0;

                if (started == 1) {
                    cmp = Integer.compare(d, lastDigit);

                    if (lastCmp != 0 && cmp != 0 && cmp != lastCmp) {
                        add = 1;
                    }
                }

                long[] nxt = dfs(
                        pos + 1,
                        d,
                        cmp,
                        ntight,
                        1
                );

                count += nxt[0];
                wavinessSum += nxt[1] + (long) add * nxt[0];
            }
        }

        vis[pos][lastDigit][lastCmp + 1][tight][started] = true;
        cntMemo[pos][lastDigit][lastCmp + 1][tight][started] = count;
        sumMemo[pos][lastDigit][lastCmp + 1][tight][started] = wavinessSum;

        return new long[]{count, wavinessSum};
    }
}
