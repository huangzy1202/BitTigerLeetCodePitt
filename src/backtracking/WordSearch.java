public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0 || board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean [][] used = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < board[0].length; col ++) {
                if (helper(board, word, 0, row, col, used)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board, String word, int index, int row, int col, boolean[][]used) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        if (used[row][col]) {
            return false;
        }
        used[row][col] = true;
        boolean result = helper(board, word, index + 1, row - 1, col, used) || helper (board, word, index + 1, row, col - 1, used) || helper(board, word, index + 1, row + 1, col, used) || helper(board, word, index + 1, row, col + 1, used);
        used[row][col] = false;
        return result;
    }
}
