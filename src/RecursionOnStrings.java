public class RecursionOnStrings {


    // remove all occurences of a a character
    // Remove a character from a string using recursion
    // Replace a character in a string using recursion

    // hello, l
    public static String removeChar(String s, char c){
       if(s.length() == 0) return "";
       String recursiveCall = removeChar(s.substring(1), c);
       if(s.charAt(0) == c) return recursiveCall;
       else return s.charAt(0) + recursiveCall;
    }


    
    // palidrome(two pointer approach)
    public static boolean palindrome(String s){
        return palindrome(s, 0, s.length()-1);
    }
    public static boolean palindrome(String s, int start, int end){
        if(start>=end) return true;
        if(s.charAt(start) != s.charAt(end)) return false;
        return palindrome(s, start+1, end-1);
    }
// racecar:- r==r, a==a, c==c, e==e, a==a, r==r;- true
// helloh:- h==h, e==o;- false

    // hello:- ello - llo - lo - o - "" 
    // Akhil 
    public static String reverseString(String s){
       if(s.length()<= 1) return s;
       String smallCalculation = reverseString(s.substring(1));
       return smallCalculation + s.charAt(0);
    }
    // dry run
    // rev("hello"):- rev("ello")+h, 
    // rev("ello"):- rev("llo")+e,
    // rev("llo"):- rev("lo")+l,
    // rev("lo"):- rev("o")+l,
    // rev("o"):- rev("")+o,
    // upon reaching the base case, we will return "" and then we will start returning the values in reverse order
    // o+l:- ol, +l =oll +e = olle + h = olleh
    // public static String reverseString(String s, int index){
    //     if(index >= s.length()) return "";
    //     String smallCalculation = reverseString(s, index + 1);
    //     return smallCalculation + s.charAt(index);
    // }
    public static void main(String[] args) {
        String s = "racecar";
        String ans = reverseString(s);
        System.out.println(ans);
        boolean ans2 = palindrome(s);
        System.out.println(ans2);
    }

}
// reverse a string using recursion
// strings areimmutable in java
// two ways to do recursion
// Stryle A
// peel with substring method (teaching style)
// abcdef:- bcdef:- s.subsrting(1,s.length())

// Style B
// peel with charAt method (index walking)
// abcedf:- count(s, i+1)
// 012345 count(s, 1); looks excatly array

