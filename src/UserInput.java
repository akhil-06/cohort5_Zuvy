import java.util.Scanner;
public class UserInput {

    public static double calculateAverage(int []num){
        int sum = 0;
        for(int i=0;i<num.length;i++){
            sum += num[i];
        }
        return (double)sum / num.length;
    }

    public static String findGrade(double average){
        if(average >= 90){
            return "A";
        }else if(average >= 80){
            return "B";
        }else if(average >= 70){
            return "C";
        }else if(average >= 60){
            return "D";
        }else{
            return "F";
        }
    }

    // public static int sum(int a, int b) {
    //     int sum = a + b;
    //     return sum;
    // }
    // public static int calculateArea(int length, int breadth) {
    //     int area = length * breadth;
    //     return area;
    // }
    // public static boolean isPrime(int n){
    //     if(n<=1){
    //         return false;
    //     }
    //     for(int i=2;i<n;i++){
    //         if(n%i==0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter your Number:- ");
        // int a = sc.nextInt(); //20
        // boolean ans = isPrime(a);
        // System.out.println(ans);
        // System.out.print("Enter your Second Number:- ");
        // int b = sc.nextInt(); //70
        // int ans = sum(a, b);
        // System.out.println(ans);

        // System.out.print("Enter the length of the rectangle:- ");
        // int length = sc.nextInt();
        // System.out.print("Enter the breadth of the rectangle:- ");
        // int breadth = sc.nextInt();
        // int area = calculateArea(length, breadth);
        // System.out.println("The area of the rectangle is:- " + area);

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter your First Number:- ");
        // int a = sc.nextInt(); //20
        // System.out.print("Enter your Second Number:- ");
        // int b = sc.nextInt(); //70
        // int ans = a+b;
        // System.out.println(ans);
        // sc.close();
    }
}
