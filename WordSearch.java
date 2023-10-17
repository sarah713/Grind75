public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) {
            return false;
        }

        boolean result = false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int idx) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        char cur = word.charAt(idx);
        if (board[i][j] == cur) {
            char tmp = board[i][j];

            board[i][j] = '$';

            if (idx == word.length() - 1) {
                return true;
            } else if (dfs(board, word, i - 1, j, idx + 1) || dfs(board, word, i + 1, j, idx + 1)
                    || dfs(board, word, i, j + 1, idx + 1) || dfs(board, word, i, j - 1, idx + 1)) {
                return true;
            }
            board[i][j] = tmp;
        }
        return false;
    }
}
