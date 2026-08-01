import java.util.Scanner;
public class ArrayFirst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // String[] cities = new String[n];
        // for (int i = 0; i < cities.length; i++) {
        //     cities[i] = sc.next();
        // }
        // for (int i = 0; i < cities.length; i++) {
        //     System.out.println(i+1 + " " + cities[i]);
        // }






        double[] nums = new double[n];
        for(int i=0;i<nums.length;i++){
            nums[i] = sc.nextDouble();
        }
        double average = 0;
        double sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        average = sum / nums.length;
        System.out.println("Average: " + average);
        
        // nums[0] = 10;
        // nums[1] = 20;
        // nums[2] = 300;
        // nums[3] = 40;
        // nums[4] = 50;

        // int max = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] > max) {
        //         max = nums[i];
        //     }
        // }
        // System.out.println("Max value: " + max);

        // String[] names = new String[15];
        // names[0] = "John";
        // names[1] = "Jane";
        // names[2] = "Alice";
        // names[3] = "Bob";
        // names[4] = "Charlie";

        // for(int i=0;i<names.length;i++){
        // System.out.println(names[i]);
        // }

        // nums[0] = 10;
        // nums[1] = 20;
        // nums[2] = 30;
        // nums[3] = 40;
        // nums[4] = 50;
        // nums[5] = 60;
        // nums[6] = 70;
        // nums[7] = 80;
        // nums[8] = 90;
        // System.out.println(nums.length);
        // for(int i=0;i<nums.length;i++){
        // System.out.println(nums[i]);
        // }
        // nums[5] = 100;
        // System.out.println(nums[2]);

        // int[] nums2 = {10, 20, 30, 40, 50};
        // int []nums3;
        // nums3 = new int[10];
        // System.out.println(nums);
        // System.out.println(nums2);
        // System.out.println(nums3);
    }
}
