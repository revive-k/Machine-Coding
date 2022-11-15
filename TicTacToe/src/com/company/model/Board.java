package com.company.model;

public class Board {
    int n,m;
    String[][] board;
    int maxMoves;
    int moveCount = 0;
    int matchCountToWin;

    public Board(int n, int m) {
        this.n = n;
        this.m = m;
        this.board = new String[n][m];
        this.maxMoves = n*m;
        this.matchCountToWin = Math.min(5, Math.min(n,m));
        printBoard();
    }

    public void refreshBoard(){
        this.board = new String[this.n][this.m];
    }

    public boolean isValidMove(int i, int j){
        return board[i][j]==null;
    }

    public void doMove(int i, int j, String piece){
        board[i][j] = piece;
        moveCount++;
        System.out.println("Move for piece " + piece + " :" + i + "," + j);
        printBoard();
    }

    public boolean gameEnded(){
        return maxMoves == moveCount;
    }

    public boolean hasPlayerWon(int i, int j, String piece){
        return rowCheck(i, piece) || colCheck(j, piece) || diagonalCheck(i, j, piece);
    }

    public boolean rowCheck(int row, String piece){
        int minInd = row-matchCountToWin;
        if(minInd<0){
            minInd = 0;
        }
        int maxInd = row+matchCountToWin;
        if(maxInd>m){
            maxInd = m;
        }
        for(int i = minInd;i <= maxInd-matchCountToWin; i++){
            int count=0;
            for (int j = i; j < i+matchCountToWin; j++) {
                if(!piece.equals(board[row][j])){
                    count = 0;
                    break;
                }
                count++;
            }
            if(count==matchCountToWin) return true;
        }
        return false;
    }

    public boolean colCheck(int col, String piece){
        int minInd = col-matchCountToWin;
        if(minInd<0){
            minInd = 0;
        }
        int maxInd = col+matchCountToWin;
        if(maxInd>n){
            maxInd = n;
        }
        for(int i = minInd;i <= maxInd-matchCountToWin; i++){
            int count=0;
            for (int j = i; j < i+matchCountToWin; j++) {
                if(!piece.equals(board[j][col])){
                    count = 0;
                    break;
                }
                count++;
            }
            if(count==matchCountToWin) return true;
        }
        return false;
    }

    public boolean diagonalCheck(int row, int col, String piece){
        return posDiagonalCheck(row, col, piece) || negDiagonalCheck(row, col, piece);
    }

    public boolean posDiagonalCheck(int row, int col, String piece){
        int minRow = row-matchCountToWin;
        if(minRow<0){
            minRow = 0;
        }
        int maxRow = row+matchCountToWin;
        if(maxRow>n){
            maxRow = n;
        }

        int minCol = col-matchCountToWin;
        if(minCol<0){
            minCol = 0;
        }
        int maxCol = col+matchCountToWin;
        if(maxCol>m){
            maxCol = m;
        }
        for (int i = minRow, j = minCol; i <= maxRow-matchCountToWin && j <= maxCol-matchCountToWin ; i++, j++) {
            int count = 0;
            for (int k = 0; k < matchCountToWin; k++) {
                if(!piece.equals(board[i+k][j+k])){
                    count = 0;
                    break;
                }
                count++;
            }
            if(count==matchCountToWin) return true;
        }
        return false;
    }

    public boolean negDiagonalCheck(int row, int col, String piece){
        int minRow = row-matchCountToWin;
        if(minRow<0){
            minRow = 0;
        }
        int maxRow = row+matchCountToWin;
        if(maxRow>=n){
            maxRow = n-1;
        }

        int minCol = col-matchCountToWin;
        if(minCol<0){
            minCol = 0;
        }
        int maxCol = col+matchCountToWin;
        if(maxCol>m){
            maxCol = m;
        }
        for (int i = maxRow, j = minCol; i >= 4 && j <= maxCol-matchCountToWin ; i--, j++) {
            int count = 0;
            for (int k = 0; k < matchCountToWin; k++) {
                if(!piece.equals(board[i-k][j+k])){
                    count = 0;
                    break;
                }
                count++;
            }
            if(count==matchCountToWin) return true;
        }
        return false;
    }

    public void printBoard(){
        System.out.println("========Printing board======");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]==null){
                    System.out.print("- ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
