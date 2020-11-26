package org.progmatic.nov26;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chess1 {

    private static List<Character> CHESSSYMBOLS = new ArrayList<>();
    private char[][] CHESSBOARD = new char[8][8];

    static {
        CHESSSYMBOLS.add('\u2654'); //white king
        CHESSSYMBOLS.add('\u2655'); //white queen
        CHESSSYMBOLS.add('\u2656'); //white rook
        CHESSSYMBOLS.add('\u2657'); //white bishop
        CHESSSYMBOLS.add('\u2658'); //white knight
        CHESSSYMBOLS.add('\u2659'); //white pawn
        CHESSSYMBOLS.add('\u265A'); //black king
        CHESSSYMBOLS.add('\u265B'); //black queen
        CHESSSYMBOLS.add('\u265C'); //black rook
        CHESSSYMBOLS.add('\u265D'); //black bishop
        CHESSSYMBOLS.add('\u265E'); //black knight
        CHESSSYMBOLS.add('\u265F'); //black pawn
        CHESSSYMBOLS.add(' ');      //blank
    }

    public static void main(String[] args) throws FileNotFoundException, InvalidChessBoardException, ImpossibleChessSetup {
        Chess1 chess = new Chess1();
        chess.readInFile("files/bad.txt");
        chess.printOut();
        System.out.println("----------------");
        chess.step("a2", "a4");
        chess.printOut();
        System.out.println("----------------");
        chess.step("d7", "d5");
        chess.printOut();
        System.out.println("----------------");
        chess.step("a4", "d5");
        chess.printOut();

    }

    public void readInFile(String filepath) throws FileNotFoundException, InvalidChessBoardException, ImpossibleChessSetup {
        Scanner sc = new Scanner(new File(filepath));
        int whiteKing = 0;
        int whiteQueen = 0;
        int whiteRook = 0;
        int whiteBishop = 0;
        int whiteKnight = 0;
        int whitePawn = 0;
        int blackKing = 0;
        int blackQueen = 0;
        int blackRook = 0;
        int blackBishop = 0;
        int blackKnight = 0;
        int blackPawn = 0;
        int row = 0;
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");
            int column = line.length;
            if (column != 8) {
                throw new InvalidChessBoardException("Oszlop hiba");
            }
            int i = 0;
            for (String s : line) {
                char figure = s.toCharArray()[0];
                if (!CHESSSYMBOLS.contains(figure)) {
                    throw new InvalidChessBoardException("Karakter hiba");
                }
                switch (figure) {
                    case '\u2654':
                        whiteKing++;
                        if (whiteKing > 1) {
                            throw new ImpossibleChessSetup();
                        }
                        break;
                    case '\u2655':
                        whiteQueen++;
                        if (whiteQueen > 1) {
                            throw new ImpossibleChessSetup();
                        }
                        break;
                    case '\u2656':
                        whiteRook++;
                        if (whiteRook > 2) {
                            throw new ImpossibleChessSetup();
                        }
                        break;
                    case '\u2657':
                        whiteBishop++;
                        if (whiteBishop > 2) {
                            throw new ImpossibleChessSetup();
                        }
                        break;
                    case '\u2658':
                        whiteKnight++;
                        if (whiteKnight > 2) {
                            throw new ImpossibleChessSetup();
                        }
                        break;
                    case '\u2659':
                        whitePawn++;
                        if (whitePawn > 8) {
                            throw new ImpossibleChessSetup();
                        }
                        break;
                    case '\u265A':
                        blackKing++;
                        if (blackKing > 1) {
                            throw new ImpossibleChessSetup();
                        }
                        break;
                    case '\u265B':
                        blackQueen++;
                        if (blackQueen > 1) {
                            throw new ImpossibleChessSetup();
                        }
                        break;
                    case '\u265C':
                        blackRook++;
                        if (blackRook > 2) {
                            throw new ImpossibleChessSetup();
                        }
                        break;
                    case '\u265D':
                        blackBishop++;
                        if (blackBishop > 2) {
                            throw new ImpossibleChessSetup();
                        }
                        break;
                    case '\u265E':
                        blackKnight++;
                        if (blackKnight > 2) {
                            throw new ImpossibleChessSetup();
                        }
                        break;
                    case '\u265F':
                        blackPawn++;
                        if (blackPawn > 8) {
                            throw new ImpossibleChessSetup();
                        }
                        break;
                }
                CHESSBOARD[row][i] = figure;
                i++;
            }
            row++;
        }
        if (row != 8) {
            throw new InvalidChessBoardException("Sor hiba");
        }
    }

    public void printOut() {
        for (char[] chars : CHESSBOARD) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public void step(String start, String finish) {
        int startColumn = 0;
        int startRow = Integer.parseInt(Character.toString(start.charAt(1)));
        int finishColumn = 0;
        int finishRow = Integer.parseInt(Character.toString(finish.charAt(1)));
        switch (start.charAt(0)) {
            case 'a':
                startColumn = 0;
                break;
            case 'b':
                startColumn = 1;
                break;
            case 'c':
                startColumn = 2;
                break;
            case 'd':
                startColumn = 3;
                break;
            case 'e':
                startColumn = 4;
                break;
            case 'f':
                startColumn = 5;
                break;
            case 'g':
                startColumn = 6;
                break;
            case 'h':
                startColumn = 7;
                break;
        }
        switch (finish.charAt(0)) {
            case 'a':
                finishColumn = 0;
                break;
            case 'b':
                finishColumn = 1;
                break;
            case 'c':
                finishColumn = 2;
                break;
            case 'd':
                finishColumn = 3;
                break;
            case 'e':
                finishColumn = 4;
                break;
            case 'f':
                finishColumn = 5;
                break;
            case 'g':
                finishColumn = 6;
                break;
            case 'h':
                finishColumn = 7;
                break;
        }
        char[][] newBoard = new char[8][8];
        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[i].length; j++) {
                if (i == startRow-1 && j == startColumn) {
                    newBoard[i][j] = ' ';
                } else if (i == finishRow-1 && j == finishColumn) {
                    newBoard[i][j] = CHESSBOARD[startRow-1][startColumn];
                } else {
                    newBoard[i][j] = CHESSBOARD[i][j];
                }
            }
        }
        CHESSBOARD = newBoard;
    }
}
