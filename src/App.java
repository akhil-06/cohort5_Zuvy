public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        int a = 15;

        // if(a > 5){
        // System.out.println("a is greater than 5");
        // }else{
        // System.out.println("a is less than or equal to 5");
        // }

        // nested if-else
        // int marks = 69;
        // if (marks >= 90) {
        // System.out.println("Grade A");
        // } else if (marks >= 80) {
        // System.out.println("Grade B");
        // } else if (marks >= 70) {
        // System.out.println("Grade C");
        // } else if (marks >= 60) {
        // System.out.println("Grade D");
        // } else {
        // System.out.println("Grade F");
        // }

        // int age = 20;
        // boolean haveVoterId = true;
        // if(age >= 18){
        // if(haveVoterId){
        // System.out.println("You are eligible to vote");
        // }
        // }

        // if {if-else} - else {if-else}

        // boolean isRaining = false;
        // boolean isWeekend = true;
        // if (isWeekend) {
        // if (isRaining) {
        // System.out.println("Stay home and watch a movie");
        // } else {
        // System.out.println("Go out and enjoy the day");
        // }
        // } else {
        // if (isRaining) {
        // System.out.println("Go to work and take an umbrella");
        // } else {
        // System.out.println("Go to work and enjoy the day");
        // }

        // switch statement
        int day = -6;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }

        // Question is:- amazon is having 5 delievery options and you have to select one of them. If the user selects 1, then print "You have selected standard delivery", if the user selects 2, then print "You have selected express delivery", if the user selects 3, then print "You have selected same day delivery", if the user selects 4, then print "You have selected next day delivery", if the user selects 5, then print "You have selected two day delivery", if the user selects any other number, then print "Invalid option".

    }
}
