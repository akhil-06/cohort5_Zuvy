public class StringAlgo {
    // public static int[] buildPiTable(String pattern) {
    // int m = pattern.length();
    // int[] pi = new int[m + 1];
    // pi[1] = 0;
    // int k = 0;
    // // this loop calculates the longest prefix which is also suffix for each
    // prefix of the pattern and stores it in the pi array
    // for (int i = 2; i <= m; i++) {
    // // this while loop is used to find the longest prefix which is also suffix
    // for the current prefix of the pattern and stores it in the pi array with the
    // help of the previously calculated values in the pi array
    // while (k > 0 && pattern.charAt(k) != pattern.charAt(i - 1)) {
    // k = pi[k];
    // }
    // if (pattern.charAt(k) == pattern.charAt(i - 1)) {
    // k++;
    // }
    // pi[i] = k;
    // }
    // return pi;

    // }

    // public static int KMPSearch(String text, String pattern) {
    // int n = text.length();
    // int m = pattern.length();
    // if (m == 0) {
    // return 0;
    // }
    // int[] pi = buildPiTable(pattern);
    // // this j variable is used to keep track of the current position in the
    // pattern while searching for the pattern in the text
    // int j = 0;
    // // this loop is used to search for the pattern in the text using the pi array
    // and the previously calculated values in the pi array to avoid unnecessary
    // comparisons
    // for (int i = 0; i < n; i++) {
    // // this loop is used to find the longest prefix which is also suffix for the
    // current prefix of the pattern and stores it in the pi array with the help of
    // the previously calculated values in the pi array
    // while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
    // j = pi[j];
    // }
    // if (text.charAt(i) == pattern.charAt(j)) {
    // j++;
    // }
    // if (j == m) {
    // return i - m + 1;
    // }
    // }
    // return -1;
    // }

    public static int getModQ(String pattern, int q) {
        int val = 0;
        for (int i = 0; i < pattern.length(); i++) {
            val = (val * 10 + pattern.charAt(i)) % q;
        }
        return val;
    }

    public static void search(String text, String pattern, int q) {
        int n = text.length();
        int m = pattern.length();
        int pModQ = getModQ(pattern, q);
        System.out.println("pModQ: " + pModQ);

        for (int i = 0; i <= n - m; i++) {
            String window = text.substring(i, i + m);
            int tModQ = getModQ(window, q);
            // System.out.println("window: " + window + ", tModQ: " + tModQ);
            if (pModQ == tModQ) {
                if (window.equals(pattern)) {
                    System.out.println("Pattern found at index: " + i);
                } else {
                    System.out.println("Hash matched but pattern did not match at index: " + i);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("test 1 :- letters");
        search("abcabcabcabababd", "ababd",13);
        System.out.println("test 2 :- numbers");
        search("12345678901234567890", "56789", 13);
        // String text = "ababcabcabababd";
        // String pattern = "ababd";
        // int[] piTable = buildPiTable(pattern);
        // for (int i = 1; i < piTable.length; i++) {
        // System.out.print(piTable[i] + " ");
        // }
        // System.out.println();
        // int matchIndex = KMPSearch(text, pattern);
        // if (matchIndex >= 0) {
        // System.out.println("Pattern found at index: " + matchIndex);
        // } else {
        // System.out.println("Pattern not found");
        // }
    }
}
