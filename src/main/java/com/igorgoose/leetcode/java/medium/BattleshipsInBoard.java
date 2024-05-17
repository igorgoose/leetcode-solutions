package com.igorgoose.leetcode.java.medium;

/*
419. Battleships in a Board
Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.

Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape
1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical
cell separates between two battleships (i.e., there are no adjacent battleships).
 */
public class BattleshipsInBoard {
    public int countBattleships(char[][] board) {
        int count = 0, n = board.length, m = board[0].length;
        boolean foundHorizontal = false;

        for (int i = 0; i < n; i++) {
            foundHorizontal = false;
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') {
                    if (!foundHorizontal && (i == 0 || board[i - 1][j] != 'X')) {
                        foundHorizontal = true;
                        count++;
                    }
                } else {
                    foundHorizontal = false;
                }
            }
        }

        return count;
    }
}
