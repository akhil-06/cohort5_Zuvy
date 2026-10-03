// https://docs.google.com/presentation/d/1I3cQwDRul-jY9vL2Dk8bWoOXmuwpZ4-4GEzNK-tidCs/edit?slide=id.p1#slide=id.p1
import java.util.ArrayList;
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

    static boolean colorMGraph(int[][] graph, int m, int[] color, int v) {
        // base case: if all vertices are assigned a color then return true
        if (v == graph.length)
            return true;
        // try all colors for vertex v
        for (int c = 1; c <= m; c++) {
            // check if it is ok to color vertex v with color c
            if (isOktoColor(graph, color, v, c)) {
                // I am able to color vertex v with color c, so I will color it and explore for
                // next vertex
                color[v] = c; // choose
                // this if statement is used to check if the coloring of the graph is successful
                // or not, if it is successful then return true, otherwise unchoose the color
                // and try next color
                if (colorMGraph(graph, m, color, v + 1))
                    return true; // explore
                // if coloring of the graph is not successful, then unchoose the color and try
                // next color
                color[v] = 0; // unchoose
            }
        }
        return false;
    }

    static boolean isOktoColor(int[][] graph, int[] color, int v, int c) {
        // check if any adjacent vertex has the same color
        for (int u = 0; u < graph.length; u++) {
            // if u is adjacent to v and u has the same color c, then it is not ok to color
            // v with c
            if (graph[v][u] == 1 && color[u] == c)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int graph[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 } };
        int m = 3; // Number of colors
        int[] color = new int[graph.length];
        if (colorMGraph(graph, m, color, 0)) {
            System.out.println("Graph can be colored with " + m + " colors");
            for (int i = 0; i < color.length; i++) {
                System.out.println("Vertex " + i + " ---> Color " + color[i]);
            }
        } else {
            System.out.println("Graph cannot be colored with " + m + " colors");
        }

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
