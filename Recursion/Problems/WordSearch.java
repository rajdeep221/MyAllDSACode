package Recursion.Problems;

public class WordSearch {

    class Solution {
        private boolean dfs(char[][] board, String word, int index, int i, int j) {
            int rows = board.length;
            int cols = board[0].length;
            if (index == word.length())
                return true;

            if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != word.charAt(index))
                return false;

            char c = board[i][j];
            board[i][j] = '*';
            if (dfs(board, word, index + 1, i + 1, j) || dfs(board, word, index + 1, i - 1, j)
                    || dfs(board, word, index + 1, i, j + 1) || dfs(board, word, index + 1, i, j - 1))
                return true;
            board[i][j] = c;
            return false;
        }

        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (word.charAt(0) == board[i][j] && dfs(board, word, 0, i, j))
                        return true;
                }
            }
            return false;
        }
    }
}
