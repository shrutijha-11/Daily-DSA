class Solution {
    public String profession(int level, int pos) {
        // code here
        int flips = 0;

        while (pos > 1) {
            if ((pos & 1) == 0) {
                flips++;
            }
            pos = (pos + 1) / 2;
        }

        return (flips % 2 == 0) ? "Engineer" : "Doctor";
    }
}
