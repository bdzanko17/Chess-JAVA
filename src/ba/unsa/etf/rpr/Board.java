package ba.unsa.etf.rpr;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

public class Board {
    ChessPiece[][] tabla;


    Board() {

        tabla = new ChessPiece[8][8];
        for (int i = 0; i < 8; i++) {               //Postavljanje pijuna bijelih i crnih
            char x = (char) ('A' + i);
            String pozicija1 = x + Integer.toString(7);
            tabla[6][i] = new Pawn(pozicija1, ChessPiece.Color.BLACK);
            String pozicija2 = x + Integer.toString(2);
            tabla[1][i] = new Pawn(pozicija2, ChessPiece.Color.WHITE);

        }

        //Prazna polja
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i != 6 && i != 1 && i != 0 && i != 7) {
                    tabla[i][j] = null;
                }
            }
        }
        //crne

        tabla[0][0] = new Rook("A8", ChessPiece.Color.BLACK);
        tabla[0][1] = new Knight("B8", ChessPiece.Color.BLACK);
        tabla[0][2] = new Bishop("C8", ChessPiece.Color.BLACK);
        tabla[0][3] = new Queen("D8", ChessPiece.Color.BLACK);
        tabla[0][4] = new King("E8", ChessPiece.Color.BLACK);
        tabla[0][5] = new Bishop("F8", ChessPiece.Color.BLACK);
        tabla[0][6] = new Knight("G8", ChessPiece.Color.BLACK);
        tabla[0][7] = new Rook("H8", ChessPiece.Color.BLACK);

        //bijele

        tabla[7][0] = new Rook("A1", ChessPiece.Color.WHITE);
        tabla[7][1] = new Knight("B1", ChessPiece.Color.WHITE);
        tabla[7][2] = new Bishop("C1", ChessPiece.Color.WHITE);
        tabla[7][3] = new Queen("D1", ChessPiece.Color.WHITE);
        tabla[7][4] = new King("E1", ChessPiece.Color.WHITE);
        tabla[7][5] = new Bishop("F1", ChessPiece.Color.WHITE);
        tabla[7][6] = new Knight("G1", ChessPiece.Color.WHITE);
        tabla[7][7] = new Rook("H1", ChessPiece.Color.WHITE);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tabla[i][j] != null)
                    System.out.println(tabla[i][j].getClass());
            }
        }
    }

}
