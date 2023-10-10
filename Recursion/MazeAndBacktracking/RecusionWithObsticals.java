package Recursion.MazeAndBacktracking;

public class RecusionWithObsticals {

    static void pathWithRes(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.print(p + " ");
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        if (r < maze.length - 1) {
            pathWithRes(p + 'D', maze, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            pathWithRes(p + 'R', maze, r, c + 1);
        }
    }

    public static void main(String[] args) {

        boolean board[][] = {
                { true, true, true },
                { true, false, true },
                { true, true, true }
        };

        pathWithRes("", board, 0, 0);
    }
}
