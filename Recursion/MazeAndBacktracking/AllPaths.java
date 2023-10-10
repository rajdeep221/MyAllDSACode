package Recursion.MazeAndBacktracking;

public class AllPaths {

    static void path(String p, boolean maze[][], int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.print(p + " ");
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // i am considering this block is as false

        maze[r][c] = false;

        if (r < maze.length - 1) {
            path(p + 'D', maze, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            path(p + 'R', maze, r, c + 1);
        }

        if (r > 0) {
            path(p + 'U', maze, r - 1, c);
        }

        if (c > 0) {
            path(p + 'L', maze, r, c - 1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also removed the changes that were made
        // by that function
        maze[r][c] = true;
    }

    public static void main(String[] args) {
        boolean maze[][] = {
                { true, true, true },
                { true, true, true },
                { true, true, true }
        };

        path("", maze, 0, 0);
    }
}
