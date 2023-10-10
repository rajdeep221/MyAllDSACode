package StackAndQueue.ImportQuestion;

public class FloodFill {

    public int[][] floodFill(int image[][], int sr, int sc, int color) {
        int cons = image[sr][sc];

        if (cons != color) {
            dfs(image, sr, sc, color, cons);
        }

        return image;
    }

    private void dfs(int image[][], int r, int c, int color, int cons) {
        if (image[r][c] == cons) {
            image[r][c] = color;

            if (r >= 1)
                dfs(image, r - 1, c, color, cons);
            if (c >= 1)
                dfs(image, r, c - 1, color, cons);

            if ((r + 1) < image.length)
                dfs(image, r + 1, c, color, cons);
            if ((c + 1) < image.length)
                dfs(image, r, c + 1, color, cons);
        }
    }
}
