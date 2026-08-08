// Strings and StringbuilderPPT:- https://docs.google.com/presentation/d/1sJChRHUlc-phOl1gwWOnr0mKw_4tW2-PQCc1YuNnupE/edit?slide=id.p47#slide=id.p47

public class Strings_practice {
    public static void main(String[] args) {
        boolean[] seen = new boolean[256];
        String str = "aaaabbbbcccccajdajdaaaddbbbccc";
        StringBuilder sb = new StringBuilder();
        for(char c:str.toCharArray()){
            if(!seen[c]){
                seen[c] = true;
                sb.append(c);
            }
        }
        System.out.println(sb.toString()); // abcdj

        // aabbccbbbccc:- abc
        // 242 valid anagram - frequency array approach
        // class Solution {
        // public boolean isAnagram(String s, String t) {
        // if (s.length() != t.length())
        // return false;
        // int[] freqArr = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        // freqArr[s.charAt(i) - 'a']++;
        // freqArr[t.charAt(i) - 'a']--;
        // }
        // for (int i : freqArr) {
        // if (i != 0) {
        // return false;
        // }
        // }
        // return true;
        // // for (int i = 0; i < t.length(); i++) {
        // // freqArr[t.charAt(i) - 'a']--;
        // // }
        // }
        // }

        // 125 valid palindrome - two pointer approach
        // public boolean isPalindrome(String s) {
        // if(s.isEmpty()) return true;
        // int si = 0;
        // int e = s.length() - 1;
        // while(si<=e){
        // char first = s.charAt(si);
        // char last = s.charAt(e);
        // if(!Character.isLetterOrDigit(first)){
        // si++;
        // }else if(!Character.isLetterOrDigit(last)){
        // e--;
        // }else{
        // if(Character.toLowerCase(first) != Character.toLowerCase(last)){
        // return false;
        // }
        // si++;
        // e--;
        // }
        // }
        // return true;
        // }
        // Palindrome check
        String str1 = "racebar";
        int i = 0;
        int j = str1.length() - 1;
        while (i < j) {
            if (str1.charAt(i) != str1.charAt(j)) {
                System.out.println("Not a palindrome");
                return;
            }
            i++;
            j--;
        }
        System.out.println("Is a palindrome");

        // reverse a string
        // String str = "Hello World";
        // char[] charArray = str.toCharArray();
        // int i =0;
        // int j = charArray.length - 1;
        // while(i<j){
        // char temp = charArray[i];
        // charArray[i] = charArray[j];
        // charArray[j] = temp;
        // i++;
        // j--;
        // }
        // String reversedStr = new String(charArray);
        // System.out.println(reversedStr);

        // StringBuilder sb = new StringBuilder(str);
        // sb.reverse();
        // System.out.println(sb.toString()); // dlroW olleH
    }
}
