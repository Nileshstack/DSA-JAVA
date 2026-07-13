class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0){
            return;
        }
        int n =board.length;
        int m =board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || i==n-1 || j==0 || j==m-1) && board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                  board[i][j]='X';  
                }else if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }

    }
    public void dfs(char[][] board,int i,int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!='O'){
            return;
        }
        board[i][j]='T';
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
}