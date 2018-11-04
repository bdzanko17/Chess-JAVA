package ba.unsa.etf.rpr;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

public class Board {
   public ChessPiece[] tabla;

    Board() {
            tabla=new ChessPiece[32];
            tabla[0]=new Rook("A1", ChessPiece.Color.WHITE);
            tabla[1]=new Knight("B1", ChessPiece.Color.WHITE);
            tabla[2]=new Bishop("C1", ChessPiece.Color.WHITE);
            tabla[3]=new Queen("D1", ChessPiece.Color.WHITE);
            tabla[4]=new King("E1", ChessPiece.Color.WHITE);
            tabla[5]=new Bishop("F1", ChessPiece.Color.WHITE);
            tabla[6]=new Knight("G1", ChessPiece.Color.WHITE);
            tabla[7]=new Rook("H1", ChessPiece.Color.WHITE);
            for(int i=8;i<=23;i++){
                char x = (char) ('A' + i);
                String s= x+Integer.toString(2);
                if(i<16)
                tabla[i]=new Pawn(s, ChessPiece.Color.WHITE);
                else{
                    tabla[i]=new Pawn(s, ChessPiece.Color.BLACK);

                }
            }
        tabla[24]=new Rook("A8", ChessPiece.Color.BLACK);
        tabla[25]=new Knight("B8", ChessPiece.Color.BLACK);
        tabla[26]=new Bishop("C8", ChessPiece.Color.BLACK);
        tabla[27]=new Queen("D8", ChessPiece.Color.BLACK);
        tabla[28]=new King("E8", ChessPiece.Color.BLACK);
        tabla[29]=new Bishop("F8", ChessPiece.Color.BLACK);
        tabla[30]=new Knight("G8",ChessPiece.Color.BLACK);
        tabla[31]=new Rook("H8",ChessPiece.Color.BLACK);




    }

    void move(Class type, ChessPiece.Color color, String position) throws IllegalArgumentException, ChessPiece.IllegalChessMoveException {

    }

}
