package com.company;

import com.company.model.Board;
import com.company.model.Player;

import java.util.Random;

public class Main {

    static final int row = 10;
    static final int col = 11;

    public static void main(String[] args) {
        Random random = new Random();
        Player player1 = new Player("Mohan", "X");
        Player player2 = new Player("Shyam", "O");
        Board board = new Board(row, col);
        int tempCount = 0;
        while(true){
            Player currentPlayer;
            if(tempCount%2==0){
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }
            int moveRow = random.nextInt(row);
            int moveCol = random.nextInt(col);
            if(board.isValidMove(moveRow, moveCol)){
                board.doMove(moveRow, moveCol, currentPlayer.getPiece());
                if(board.hasPlayerWon(moveRow, moveCol, currentPlayer.getPiece())){
                    System.out.println("=========== " + currentPlayer.getPiece() + " has won the game ===========");
                    return;
                } else if(board.gameEnded()){
                    System.out.println("---Game ended. No one wins---");
                    return;
                }
                tempCount++;
            }
        }
    }
}
