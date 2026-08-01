import java.util.Scanner;

public class Char {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.charAt(i) + i);
        }

        // String fullName = sc.nextLine();
        // System.out.println("Full Name: " + fullName);

        // input :- Akhil sRc sharma
        // outpu:- Akhil
        // String name = sc.nextLine();
        // for(int i=0;i<name.length();i++){
        // char ch = name.charAt(i);
        // if(ch == ' '){
        // break;
        // }
        // System.out.print(ch);
        // }

        // charAt()
        // String
        // String str = "Hello, World!";
        // for(int i=0;i<str.length();i++){
        // char ch = str.charAt(i);
        // System.out.println("Character at index " + i + ": " + ch);
        // }

        // char ch = str.charAt(11);
        // System.out.println("Character at index 11: " + ch);

        // int a = 65;
        // char ch = (char) a;
        // System.out.println( ch);
        // char ch1 = 'A';
        // char ch2 = '5';
        // int numValue = Character.getNumericValue(ch2);
        // System.out.println("Numeric value of " + ch2 + " is: " + numValue);

        // if(ch1 < ch2) {
        // System.out.println(ch1 + " is less than " + ch2);
        // } else if(ch1 > ch2) {
        // System.out.println(ch1 + " is greater than " + ch2);
        // } else {
        // System.out.println(ch1 + " is equal to " + ch2);
        // }
        // char c = 'A';
        // char c1 = '5';
        // char c2 = ' ';
        // char c3 = '@';
        // System.out.println("Character: " + c);
        // System.out.println("Character: " + c1);
        // System.out.println("Character: " + c2);
        // System.out.println("Character: " + c3);
    }
}
