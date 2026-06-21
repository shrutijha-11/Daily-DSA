class Solution {
    String chooseandswap(String s) {
        int n = s.length();

        boolean[] present = new boolean[26];
        for (char ch : s.toCharArray()) {
            present[ch - 'a'] = true;
        }

        char first = 0, second = 0;

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            present[curr - 'a'] = false;

            for (char ch = 'a'; ch < curr; ch++) {
                if (present[ch - 'a']) {
                    first = curr;
                    second = ch;
                    break;
                }
            }

            if (first != 0) break;
        }

        if (first == 0) return s;

        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (arr[i] == first) {
                arr[i] = second;
            } else if (arr[i] == second) {
                arr[i] = first;
            }
        }

        return new String(arr);
    }
}
