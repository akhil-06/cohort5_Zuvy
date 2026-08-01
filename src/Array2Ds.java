import java.util.Scanner;

public class Array2Ds {
    public static void print2dArray(int [][] nums) {
        for (int rows[] : nums) {
            for (int elem : rows) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static int[][] takeUserInputof2Darray(){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] nums = new int[row][col];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        sc.close();
        return nums;
    }
    public static int findSumofAllelements(int[][] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                sum = sum + nums[i][j];
            }
        }
    //    for (int rows[] : nums) {
    //         for (int elem : rows) {
    //             sum = sum + elem;
    //         }
    //     }
        return sum;
    }

    public static int largestElement(int[][]nums){
        int largest = nums[0][0];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j] > largest){
                    largest = nums[i][j];
                }
            }
        }
        return largest;
    }


    public static boolean searchAnelement(int[][]nums, int target){
        int rowIndex = -1;
        int colIndex = -1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j] ==  target){
                    return true;
                }
            }
        }
        return false;
    }

    public static void rowSum(int[][] nums){
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=0;j<nums[0].length;j++){
                sum = sum + nums[i][j];
            }
            System.out.println("Sum of row " + i + " is: " + sum);
        }
    }

    public static void columnSum(int[][] nums){
         for(int j=0;j<nums[0].length;j++){
            int sum = 0;
            for(int i=0;i<nums.length;i++){
                sum = sum + nums[i][j];
            }
            System.out.println("Sum of column " + j + " is: " + sum);
        }
    }

    public static int diagonalSum(int[][] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(i==j){
                    sum = sum + nums[i][j];
                }
            }
            // sum = sum + nums[i][i];
        }
        return sum;
    }
    public static int diagonalSum2(int[][] nums){
        int sum = 0;
        int n = nums.length;;
        for(int i=0;i<n;i++){
            sum +=nums[i][i];
            sum+=nums[i][n-i-1];
        }
        if(n%2!=0){
            sum -= nums[n/2][n/2];
        }
        return sum;
    }

    public boolean isSymmetric(int[][] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] != nums[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[][] nums = takeUserInputof2Darray();
        print2dArray(nums);
        System.out.println("Sum of all elements: " + findSumofAllelements(nums));
        int maximumNumber = largestElement(nums);
        System.out.println("Largest element: " + maximumNumber);
        boolean isFound = searchAnelement(nums, 5);
        System.out.println("Element found: " + isFound);
        rowSum(nums);
        columnSum(nums);
        int dsum = diagonalSum(nums);
        System.out.println("Diagonal sum: " + dsum);
        int totalDiagonalSum = diagonalSum2(nums);
        System.out.println("Total diagonal sum: " + totalDiagonalSum);
    }
}

// I have done the following tasks in the code:
// 1. Column sum
// 2. Diagonal sum
// 3. tranpose of a matrix
// 4. both diagonal sum - same element
// 123
// 456
// 789
// pd = 159 = 15
// sd = 357 = 15 = 30-5 => 25
// 5. symmetric matrix:- arr[i][j] == arr[j][i]


// You have to do the following tasks in the code:
// 1. Search an element and give me indexes
// 2. 2d array of 10*10, multiplication table of 1 - 10
// 3. Check if Matrix is a Diagonal Matrix
// Example:
// 5 0 0
// 0 8 0
// 0 0 3
// 4. Print Each Row's Maximum Element
// Example:
// 1  5  3
// 8  2  4
// 6  9  7

// Output:
// Row 0 Max = 5
// Row 1 Max = 8
// Row 2 Max = 9

//5.Print Elements Above and below Main Diagonal
// For:
// 1 2 3
// 4 5 6
// 7 8 9

// Output:
// 2 3 6
// 4
// 7 8 

// 6.Find the Most Frequent Element
// 7. Find the Least Frequent Element
// 8. Print Boundary Elements
// For:
// 1 2 3
// 4 5 6
// 7 8 9

// Output:
// 1 2 3 6 9 8 7 4