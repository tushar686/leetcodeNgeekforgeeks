package solutions;


class GFG {

    public static void main (String[] args) {
//        kmpPatternMatching.search("AAAA", "AAAAA");
//        kmpPatternMatching.search("ABCDABD", "ABC ABCDAB ABCDABCDABDE");
            matchPattern("ABCDABD", "ABCABCDABD ABCDABCDABDE");
//        kmpPatternMatching.search("ABCDE", "AABBABCDETUSH");
//        kmpPatternMatching.search("AABAACAABAA", "AABBABCDETUSH");
//        kmpPatternMatching.search("AABAACAABBB", "AABBABCDETUSH");
        // kmpPatternMatching.search("AABAACAABAA", "");
//        kmpPatternMatching.search("AAACAAAAAC", "");
        // kmpPatternMatching.search("AAABAAA", "");
    }

    private static void matchPattern(String pattern, String text) {
        int[] lps = processPattern(pattern);
        
        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j) ) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j-1];
                }
            }
            if (j == pattern.length()) {
                System.out.println("Pattern found @: " + (i-j) );
                j = lps[j-1];
            }
        }
    }

    private static int[] processPattern(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int j = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j) ) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    j = lps[j-1];
                }
            }
        }

        return lps;
    }

}