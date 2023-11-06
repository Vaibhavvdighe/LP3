class Backtracking {
    /*This line declares a function named "isAttack" that takes four parameters: i, j, board, and N.
The function checks if it's safe to place a queen at position (i, j) on the chessboard represented by the board array of size N×N.
It returns true if the placement is unsafe (i.e., a queen could be attacked), and false otherwise.*/
  public static boolean isAttack(int i, int j, int board[][], int N) {
    int k, l;
    // checking for column j
    for(k=1; k<=i-1; k++) {
      if(board[k][j] == 1)
        return true; /*This line checks if there is a queen in the same column j but in a row k.
                        If a queen is found, the function returns true because the placement is unsafe*/
    }

    // checking upper right diagonal
    k = i-1;
    l = j+1;/* It initializes k to i - 1 and l to j + 1. These are used to check the upper-right diagonal. */
    while (k>=1 && l<=N) {   /* This loop is used to check the upper-right diagonal of the chessboard. */
      if (board[k][l] == 1)  
        return true;        /* This line checks if there's a queen in the upper-right diagonal.
                            If a queen is found, the function returns true because the placement is unsafe. */
      k=k+1;
      l=l+1;  /* These lines increment both k and l to check the next position in the upper-right diagonal. */
    }

    // checking upper left diagonal
    k = i-1;    // This line initializes the variable k to i-1, which is the row above the current position
    l = j-1;    // This line initializes the variable l to j-1, which is the column to the left of the current position
    while (k>=1 && l>=1) {
      if (board[k][l] == 1)   //This line checks if there's a queen in the upper-left diagonal of the current position.
        return true;
      k=k-1;    // This line decrements k to move to the next row above.
      l=l-1;    // This line decrements l to move to the next column to the left.
    }

    return false; /* If no threats are found in the column or diagonals, this line indicates that it's safe to place a queen in the current position and returns false*/
  }

  public static boolean nQueen(int row, int n, int N, int board[][]) {
    if (n==0) //This line checks if there are no queens left to place. If n is 0, it returns true, indicating a successful placement of all queens.
      return true;

    for (int j=1; j<=N; j++) {
      if(!isAttack(row, j, board, N)) {
        board[row][j] = 1;    // If it's safe, this line places a queen on the board by setting the corresponding cell to 1.

        if (nQueen(row+1, n-1, N, board))
          return true;

        board[row][j] = 0; //backtracking --> If no solution is found, this line backtracks by removing the queen from the current cell (setting it to 0) and continues checking other positions.
      }
  }
  return false;
  }

  public static void main(String[] args) {
    int[][] board = new int[5][5];

    for(int i=0;i<=4;i++) {
      for(int j=0;j<=4;j++)
        board[i][j] = 0;
    }

    nQueen(1, 4, 4, board);

    //printing the matix
    for(int i=1;i<=4;i++) {
      for(int j=1;j<=4;j++)
        System.out.print(board[i][j]+"\t");
      System.out.println("");
    }
    }
}