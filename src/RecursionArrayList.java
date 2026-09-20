import java.util.ArrayList;
public class RecursionArrayList {

     // TC:- O(n^2) SC:- O(n)
    static ArrayList<Integer> removeX(ArrayList<Integer> ls, int index, int x) {
        if(index == ls.size()) return new ArrayList<>();
        ArrayList<Integer> ans = removeX(ls, index + 1, x);
        if(ls.get(index) != x) {
            ans.add(0, ls.get(index));
        }
        return ans;
    }
    // 3 7 3 9 3 5 index 6 - [] - [5] - [9,5] - [7,9,5]

     // TC:- O(n) SC:- O(n)
    static void reverseInPlace(ArrayList<Integer> ls, int start, int end) {
        if(start >= end) return;
        // Collections.swap(ls, start, end);
        int temp = ls.get(start);
        ls.set(start, ls.get(end));
        ls.set(end, temp);
        reverseInPlace(ls, start + 1, end - 1);
    }

    // TC:- O(n) SC:- O(n)
    static int max(ArrayList<Integer> ls, int index) {
        if(index == ls.size()-1) return ls.get(index);
        return Math.max(ls.get(index), max(ls, index + 1));
    }
    // 1 2 3 4 5
    //  1  5:- 5

    // TC;- O(n) SC:- O(n)
    static int product(ArrayList<Integer> ls, int index) {
        if(index == ls.size()) return 1;
        return ls.get(index) * product(ls, index + 1);
    }

    // TC;- O(n) SC:- O(n)
    static int sum(ArrayList<Integer> ls, int index) {
        if(index == ls.size()) return 0;
        return ls.get(index) + sum(ls, index + 1);
    }

    // TC;- O(n) SC:- O(n)
    public static void printArrayList(ArrayList<Integer> ls, int index) {
        if(index == ls.size()) return;
        System.out.println(ls.get(index) + " ");
        printArrayList(ls, index + 1);
    }
    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(5);
        ls.add(14);
        ls.add(5);

        // printArrayList(ls, 0);
        System.out.println("Sum: " + sum(ls, 0));
        System.out.println("Product: " + product(ls, 0));
        System.out.println("Max: " + max(ls, 0));
        reverseInPlace(ls, 0, ls.size() - 1);
        printArrayList(ls, 0);
        ls = removeX(ls, 0, 5);
        printArrayList(ls, 0);

        // System.out.println(ls.get(0));
        // System.out.println(ls.get(4));

        // System.out.println(ls.size());

        // ls.set(1,2222);
        // System.out.println(ls.get(1));
        // System.out.println(ls.contains(2222));
    }
}

// int[][] jaggedArray = new int[3][];
// jaggedArray[0] = new int[2]; // First row has 2 columns
// jaggedArray[1] = new int[3]; // Second row has 3 columns
// jaggedArray[2] = new int[1]; // Third row has 1 column