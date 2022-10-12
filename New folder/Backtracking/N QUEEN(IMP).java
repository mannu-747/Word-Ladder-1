/*N Queen */


class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
for(char[] row : board)
Arrays.fill(row,'.');
return nQueen(board,0,n);
}

public List<List<String>> nQueen(char[][] board, int r, int n)
{
    List<List<String>> outer = new ArrayList<List<String>>();
    if(r == n)
    {
        List<String> inner = new ArrayList<String>();
        for(int i = 0; i < n; i++)
        {
            inner.add(String.valueOf(board[i]));
        }
        outer.add(inner);
        return outer;
    }
    for(int c = 0; c < n; c++)
    {
        if(isValid(board,r,c,n))
        {
            board[r][c] = 'Q';
            outer.addAll(nQueen(board,r+1,n));
            board[r][c] = '.';
        }
    }
    return outer;
}

public boolean isValid(char[][] board, int r, int c, int n)
{
    
   
    for(int i = 0; i < r; i++)
    {
        if(board[i][c] == 'Q')
            return false;
    }
    
    int x = r-1;
    int y = c-1;
    while(x>=0 && y>=0)
    {
        if(board[x][y] == 'Q')
            return false;
        x--;
        y--;
    }
   
    x = r-1;
    y = c+1;
    while(x>=0 && y<=n-1)
    {
        if(board[x][y] == 'Q')
            return false;
        x--;
        y++;
    }
    
    return true;  
    }
}