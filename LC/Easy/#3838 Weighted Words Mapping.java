class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            int sum = 0;
            for (char c : word.toCharArray()) {
                sum += weights[c - 'a'];
            }
            int r = sum % 26;
            // 0 -> 'z', 1 -> 'y', ..., 25 -> 'a'
            char mappedChar = (char) ('z' - r);
            result.append(mappedChar);
        }
        
        return result.toString();
    }
}
