/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dsa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AORUS
 */
public class Backtracking {

    void callFun() {
//        printPermutation("ABC", "");
        System.out.println(solveNQueens(4));
    }

    void printPermutation(String str, String perm) {
        if (str.length() == 0) {
            System.out.println(perm);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            System.out.println("Inside: currChar:" + currChar + " newStr:" + newStr + " prem:" + (perm + currChar));
            printPermutation(newStr, perm + currChar);
        }
    }

    List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        helper(board, allBoards, 0);

        return allBoards;
    }

    void helper(char[][] board, List<List<String>> allBoards, int col) {
        if (col == board.length) {
            saveBoard(board, allBoards);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, allBoards, col + 1);
                //when quen have no place in column, prev quen replace with X
                board[row][col] = '.';
            }
        }
    }

    void saveBoard(char[][] board, List<List<String>> allBoards) {
        String row = "";
        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            row = "";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q') {
                    row += 'Q';
                } else {
                    row += '.';
                }
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }

//    for check weher queens safe
    boolean isSafe(int row, int col, char[][] board) {
//            horizontal check
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        //            vetical check
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //            uper left check
        int r = row;
        for (int c = col; c >= 0 && r >= 0; c--, r--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        //            uper right check
        r = row;
        for (int c = col; c < board.length && r >= 0; c++, r--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        //            lower left check
        r = row;
        for (int c = col; c >= 0 && r < board.length; c--, r++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        //            lower right check
        r = row;
        for (int c = col; c < board.length && r < board.length; c++, r++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }
//    Check Knight Tour Configuration 2596

    boolean checkKnightTourValid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }

        return helper(grid, 0, 0, 0);
    }

    boolean helper(int[][] grid, int row, int col, int num) {
        int n = grid.length;
        if (grid[row][col] == n * n - 1) {
            return true;
        }

        int i, j;
//      2 up right
        i = row - 2;
        j = col + 1;
        if ((i >= 0 && j < n) && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }
//        2 up left
        i = row - 2;
        j = col - 1;
        if ((i >= 0 && j >= 0) && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }
//      2 down right
        i = row + 2;
        j = col + 1;
        if ((i < n && j < n) && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }
//      2 down left
        i = row + 2;
        j = col - 1;
        if ((i < n && j >= 0) && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }
//      2 right up
        i = row - 1;
        j = col + 2;
        if ((i >= 0 && j < n) && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }
//      2 right down
        i = row + 1;
        j = col + 2;
        if ((i < n && j < n) && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }
//      2 left up
        i = row - 1;
        j = col - 2;
        if ((i >= 0 && j >= 0) && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }
//      2 left down
        i = row + 1;
        j = col - 2;
        if ((i < n && j >= 0) && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        return false;
    }
}
