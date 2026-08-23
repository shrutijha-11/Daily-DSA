class Solution {
    static int extractMaximum(String s) {
        // code here
        String trm = s.trim();
        String[] words = trm.split("[a-zA-Z]+");
        int res = -1,re=0;
        for(String x:words)
        {
            if(!x.isEmpty())
            re = Integer.parseInt(x);
            res = Math.max(res,re);
        }
        return res;
    }
}
