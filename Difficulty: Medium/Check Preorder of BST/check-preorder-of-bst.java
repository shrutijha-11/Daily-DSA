class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int i=0;i<arr.size();i++) {
            int x = arr.get(i);

            if (x < root)
                return false;

            while (!st.isEmpty() && x > st.peek()) {
                root = st.pop();
            }

            st.push(x);
        }

        return true;
    }
}