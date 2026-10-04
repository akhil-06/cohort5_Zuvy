// https://docs.google.com/presentation/d/1I3cQwDRul-jY9vL2Dk8bWoOXmuwpZ4-4GEzNK-tidCs/edit?slide=id.p1#slide=id.p1
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {
    // static final String[] keyPad = { "", "", "abc", "def", "ghi", "jkl", "mno",
    // "pqrs", "tuv", "wxyz" };

    // static void combosOfALetter(String digits, int index, StringBuilder curr,
    // ArrayList<String> out) {
    // if (index == digits.length()) {
    // out.add(curr.toString());
    // return;
    // }
    // String letters = keyPad[digits.charAt(index) - '0'];
    // for (char c : letters.toCharArray()) {
    // curr.append(c);// choose
    // combosOfALetter(digits, index + 1, curr, out); // explore
    // curr.deleteCharAt(curr.length() - 1); // un-choose
    // }
    // }

    // static void permus(int[] a, List<Integer> curr, List<List<Integer>> out,
    // boolean[] used) {
    // if (curr.size() == a.length) {
    // out.add(new ArrayList<>(curr));
    // return;
    // }
    // for(int k=0;k<a.length;k++){
    // if(used[k]) continue;
    // used[k] = true;
    // curr.add(a[k]); //choose
    // permus(a, curr, out, used); // explore
    // curr.remove(curr.size()-1); // un-choose
    // used[k] = false;
    // }
    // }

    // static void paths(int r, int c, int R, int C, String curr, List<String> out)
    // {
    // if (r == R - 1 && c == C - 1) {
    // out.add(curr);
    // return;
    // }
    // if (r < R - 1) paths(r + 1, c, R, C, curr + "D", out);
    // if (c < C - 1) paths(r, c + 1, R, C, curr + "R", out);
    // }

    // static void solveRatInMaze(int[][] maze, int r, int c, boolean[][] visited,
    // String curr, List<String> out) {
    // int n = maze.length;
    // if (r < 0 || c < 0 || r >= n || c >= n || maze[r][c] == 0 || visited[r][c])
    // return;
    // if (r == n - 1 && c == n - 1) {
    // out.add(curr);
    // return;
    // }
    // visited[r][c] = true; //choose cell
    // // exploring all 4 directions
    // solveRatInMaze(maze, r+1,c, visited, curr + "D", out); //down
    // solveRatInMaze(maze, r,c+1, visited, curr + "R", out); //right
    // solveRatInMaze(maze, r-1,c, visited, curr + "U", out); //up
    // solveRatInMaze(maze, r,c-1, visited, curr + "L", out); //left
    // // unchoose cell
    // visited[r][c] = false;
    // }

    // static int count = 0;
    // static void solveNqueen(int n,int row, int[] cols){
    // // base case and I am able to place all queens in n rows, so I have found a
    // solution
    // if(row == n){
    // count++;
    // return;
    // }
    // // I am at row, I have to place queen in this row, so I will try all columns
    // for(int col=0;col<n;col++){
    // // check if it is safe to place queen at row, col
    // if(safe(row, col, cols)){
    // // place queen at row, col
    // cols[row] = col; //choose
    // // explore for next row
    // solveNqueen(n, row+1, cols); //explore
    // // unchoose
    // cols[row] = -1; //unchoose
    // }
    // }
    // }
    // static boolean safe(int row, int col, int[] cols){
    // // check if any queen is already placed in the same column or diagonal
    // for(int r=0;r<row;r++){
    // // this math.abs(r-row) == Math.abs(cols[r]-col) is used to check if the
    // queens are on the same diagonal
    // if(cols[r]==col || Math.abs(r-row) == Math.abs(cols[r]-col)) return false;
    // }
    // return true;
    // }

    // static boolean colorMGraph(int[][] graph, int m, int[] color, int v) {
    //     // base case: if all vertices are assigned a color then return true
    //     if (v == graph.length)
    //         return true;
    //     // try all colors for vertex v
    //     for (int c = 1; c <= m; c++) {
    //         // check if it is ok to color vertex v with color c
    //         if (isOktoColor(graph, color, v, c)) {
    //             // I am able to color vertex v with color c, so I will color it and explore for
    //             // next vertex
    //             color[v] = c; // choose
    //             // this if statement is used to check if the coloring of the graph is successful
    //             // or not, if it is successful then return true, otherwise unchoose the color
    //             // and try next color
    //             if (colorMGraph(graph, m, color, v + 1))
    //                 return true; // explore
    //             // if coloring of the graph is not successful, then unchoose the color and try
    //             // next color
    //             color[v] = 0; // unchoose
    //         }
    //     }
    //     return false;
    // }

    // static boolean isOktoColor(int[][] graph, int[] color, int v, int c) {
    //     // check if any adjacent vertex has the same color
    //     for (int u = 0; u < graph.length; u++) {
    //         // if u is adjacent to v and u has the same color c, then it is not ok to color
    //         // v with c
    //         if (graph[v][u] == 1 && color[u] == c)
    //             return false;
    //     }
    //     return true;
    // }

    // static boolean solveSudoku(int[][] board, int row, int col) {
    //     // base case: if we have reached the last row and last column, then we have
    //     // solved the Sudoku
    //     if(row == 9) return true;
    //     // if (row == board.length - 1 && col == board[0].length) {
    //     //     return true;
    //     // }
    //     // this nr and nc is used to move to the next cell in the Sudoku board, if we are at the last column of the current row, then we move to the next row and first column, otherwise we move to the next column of the current row
    //     int nr = (col == 8) ? row + 1 : row;
    //     int nc = (col ==8) ? 0 : col + 1;
    //     //  this for loop is used to try all numbers from 1 to 9 in the current cell, if we are able to place a number in the current cell, then we move to the next cell and try to solve the Sudoku, if we are not able to solve the Sudoku, then we unchoose the number and try the next number
    //     for(int i=1;i<=9;i++){
    //         if(isOk(board, row, col, i)){
    //             board[row][col] = i; // choose
    //             if(solveSudoku(board, nr, nc)) return true; // explore
    //             board[row][col] = 0; // unchoose
    //         }
    //     }
    //     return false; 
    // }

    // static boolean isOk(int[][] board, int row, int col, int num) {
    //     // this for loop is used to check if the number is already present in the current row, current column and current 3x3 box, if it is present in any of these, then we cannot place the number in the current cell
    //     for(int i=0;i<9;i++){
    //         // check if num is not in the current 3x3 box and current row and current column, the formula for the 3x3 box is (3*(row/3) + i/3, 3*(col/3) + i%3), this formula is used to get the starting row and column of the 3x3 box and then we add i/3 and i%3 to get the next cell in the 3x3 box
    //         if(board[row][i]==num || board[i][col] == num || board[3*(row/3) + i/3][3*(col/3) + i%3] == num) return false;
    //     }
    //     return true;  
    // }
    // dry run for sudoko Solver, we start from the first cell (0,0) and try to place numbers from 1 to 9 in it, we check if the number is already present in the current row, current column and current 3x3 box, if it is not present, then we place the number in the cell and move to the next cell (0,1), we repeat this process until we reach the last cell (8,8), if we are able to place a number in the last cell, then we have solved the Sudoku, otherwise we backtrack and unchoose the number and try the next number.



    // 1,2,3,4:- 10/3= 
    static boolean canPartition(int[]a, int k){
        int sum = 0;
        // this for loop is used to calculate the sum of all elements in the array, if the sum is not divisible by k, then we cannot partition the array into k subsets with equal sum
        for(int i=0;i<a.length;i++) sum += a[i];
        if(sum%k != 0) return false;
        // sorting the array in descending order, this is done to optimize the backtracking algorithm, if we start from the largest element, then we can quickly find a solution or determine that no solution exists
        Arrays.sort(a);
        // calling the fillArray function to check if we can partition the array into k subsets with equal sum, we start from the last index of the array and pass an empty buckets array of size k to keep track of the sum of each subset, and the target sum for each subset is sum/k
        return fillAray(a, a.length-1, new int[k], sum/k);
    }

    static boolean fillAray(int[] a, int index, int[] buckets, int target){
        if(index < 0) return true; // base case: if we have placed all elements in the buckets, then we have found a solution
        for(int i=0;i<buckets.length;i++){
            if(buckets[i] + a[index] <= target){ // if we can place the current element in the current bucket, then we place it and move to the next element
                buckets[i] += a[index]; // choose
                if(fillAray(a, index-1, buckets, target)) return true; // explore
                buckets[i] -= a[index]; // unchoose
            }
            if(buckets[i] == 0) break; // if the current bucket is empty, then we cannot place the current element in any other empty bucket, so we break the loop to avoid redundant work  
        }
        return false; // if we have tried all buckets and cannot place the current element in any of them, then we return false
    }
    // dry run for canPartition([4,3,2,3,5,2,1], 4)
    // first we calculate the sum of all elements in the array, which is 20, and since 20 is divisible by 4, we can partition the array into 4 subsets with equal sum of 5. We sort the array in descending order to get [5,4,3,3,2,2,1], and then we call the fillArray function with index 6 (last index of the array), an empty buckets array of size 4, and target sum of 5. We try to place the first element (5) in the first bucket, and since it fits, we move to the next element (4) and try to place it in the first bucket again, but it doesn't fit, so we try the second bucket and it fits. We continue this process until we have placed all elements in the buckets and found a solution.
    public static void main(String[] args) {
        // int graph[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 } };
        // int m = 3; // Number of colors
        // int[] color = new int[graph.length];
        // if (colorMGraph(graph, m, color, 0)) {
        //     System.out.println("Graph can be colored with " + m + " colors");
        //     for (int i = 0; i < color.length; i++) {
        //         System.out.println("Vertex " + i + " ---> Color " + color[i]);
        //     }
        // } else {
        //     System.out.println("Graph cannot be colored with " + m + " colors");
        // }

        // int n = 4;
        // int[] cols = new int[n];
        // for(int i=0;i<n;i++) cols[i] = -1;
        // solveNqueen(n, 0, cols);
        // System.out.println(count);
        // int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1
        // } };
        // List<String> out = new ArrayList<>();
        // boolean[][] visited = new boolean[maze.length][maze[0].length];
        // solveRatInMaze(maze, 0, 0, visited, "", out);
        // System.out.println(out);
        // int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // List<String> out = new ArrayList<>();
        // paths(0, 0, matrix.length, matrix[0].length, "", out);
        // System.out.println(out);
        // int[] a = {1, 2, 3, 4};
        // List<List<Integer>> out = new ArrayList<>();
        // permus(a, new ArrayList<>(), out, new boolean[a.length]);
        // System.out.println(out);
        // String digits = "23";
        // ArrayList<String> out = new ArrayList<>();
        // combosOfALetter(digits, 0, new StringBuilder(), out);
        // System.out.println(out);
    }
}
