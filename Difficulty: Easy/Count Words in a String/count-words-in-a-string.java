class Solution {
    public int countWords(String s) {
        // code here
        String tri = s.trim();
        if(tri.isEmpty())
        return 0;
        String[] words = tri.split("\\s+");
        return words.length;
    }
}