package org.progmatic.nov26;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
}
