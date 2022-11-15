**TIC-TAC-TOE SOLVER**

This is generic tic-tac-toe solver, and it works for board of any dimension. 
It checks row, column and diagonal(both pos & neg) for matching sequence.
If board size is less than 5 then it will find sequence of length which is minimum of row & column. 
If board size is equal or larger than 5 then it will find sequence of length 5.
If sequence is found then current player wins the game.
It generates moves randomly. 
In order to change board dimension, edit value of row & col in Main class.
To see output, simply run the code. Each move prints move made with board state after the move

Formula for sequence length: this.matchCountToWin = Math.min(5, Math.min(row, column));
