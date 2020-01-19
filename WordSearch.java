class Solution {
    public boolean exist(char[][] board, String word) {

        if (word.length() == 0)
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i=0; i< board.length; i++)
            {
                for (int j=0; j<board[0].length; j++)
                {
                    if (word.charAt(0) == board[i][j])
                    {
                        if (dfs(board,visited, word, 0,i,j))
                            return true;
                    }
                }
            }
        return false;
    }

    private static boolean dfs (char[][] board, boolean[][] visited, String word, int index, int i, int j)
    {
        if (index >= word.length())
            return true;
        if (i>= board.length || j >= board[0].length || i<0 || j<0 || visited[i][j] == true)
            return false;
        boolean res = false;

        if (word.charAt(index) == board[i][j] )
        {
            visited[i][j] = true;
             res = dfs (board, visited, word, index+1, i+1, j) || dfs (board, visited, word, index+1, i, j+1) || dfs (board, visited, word, index+1, i-1, j) || dfs (board, visited, word, index+1, i, j-1);

        }
        if (!res)
           visited[i][j] = false;

        return res;
    }
}
