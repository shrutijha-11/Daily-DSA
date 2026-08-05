class Solution {
    // Function to remove all occurrences of the character from the string
    public void removeCharacter(StringBuilder s, char c) {
        // code here
        for(int i = s.length()-1;i>=0;i--)
        {
            if (s.charAt(i) == c) 
            s.deleteCharAt(i);
        }
    }
}
